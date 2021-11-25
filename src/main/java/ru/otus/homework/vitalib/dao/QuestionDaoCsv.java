package ru.otus.homework.vitalib.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.otus.homework.vitalib.converter.CsvConverter;
import ru.otus.homework.vitalib.exception.CsvFileException;
import ru.otus.homework.vitalib.model.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class QuestionDaoCsv implements QuestionDao {
  private final String filePath;

  public QuestionDaoCsv(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public List<Question> getQuestions() {
    InputStream csvStream = Thread.currentThread()
       .getContextClassLoader()
       .getResourceAsStream(filePath);
    CSVReader reader = new CSVReader(new InputStreamReader(csvStream));
    List<String[]> allRows = null;
    try {
      allRows = reader.readAll();
    } catch (IOException | CsvException e) {
      throw new CsvFileException(e);
    }
    return CsvConverter.convert(allRows);
  }
}
