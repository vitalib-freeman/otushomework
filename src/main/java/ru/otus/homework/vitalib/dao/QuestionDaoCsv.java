package ru.otus.homework.vitalib.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework.vitalib.config.QuestionsConfig;
import ru.otus.homework.vitalib.converter.CsvConverter;
import ru.otus.homework.vitalib.utils.DataParser;
import ru.otus.homework.vitalib.model.Question;
import ru.otus.homework.vitalib.utils.ReaderProvider;

import java.io.Reader;
import java.util.List;

@Repository
public class QuestionDaoCsv implements QuestionDao {
  private final ReaderProvider readerProvider;
  private final DataParser dataParser;
  private final String filePath;
  private final CsvConverter csvConverter;

  public QuestionDaoCsv(QuestionsConfig questionsConfig,
                        ReaderProvider readerProvider,
                        DataParser dataParser,
                        CsvConverter csvConverter) {
    this.readerProvider = readerProvider;
    this.filePath = questionsConfig.getFilePath();
    this.dataParser = dataParser;
    this.csvConverter = csvConverter;
  }

  @Override
  public List<Question> getQuestions() {
    Reader dataReader = readerProvider.getDataReader(filePath);
    List<String[]> allRows = dataParser.getLines(dataReader);
    return csvConverter.convert(allRows);
  }
}
