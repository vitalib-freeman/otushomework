package ru.otus.homework.vitalib.dao;

import ru.otus.homework.vitalib.converter.CsvConverter;
import ru.otus.homework.vitalib.utils.DataParser;
import ru.otus.homework.vitalib.model.Question;
import ru.otus.homework.vitalib.utils.ReaderProvider;

import java.io.Reader;
import java.util.List;

public class QuestionDaoCsv implements QuestionDao {
  private final ReaderProvider readerProvider;
  private final DataParser dataParser;
  private final String filePath;

  public QuestionDaoCsv(String filePath, ReaderProvider readerProvider, DataParser dataParser) {
    this.readerProvider = readerProvider;
    this.filePath = filePath;
    this.dataParser = dataParser;
  }

  @Override
  public List<Question> getQuestions() {
    Reader dataReader = readerProvider.getDataReader(filePath);
    List<String[]> allRows = dataParser.getLines(dataReader);
    return CsvConverter.convert(allRows);
  }
}
