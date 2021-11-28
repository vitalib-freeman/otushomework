package ru.otus.homework.vitalib.utils;

import com.opencsv.CSVReader;
import ru.otus.homework.vitalib.exception.CsvFileException;

import java.io.Reader;
import java.util.List;

public class CsvParser implements DataParser {
  @Override
  public List<String[]> getLines(Reader reader) {
    try {
      return new CSVReader(reader).readAll();
    } catch (Exception e) {
      throw new CsvFileException(e);
    }
  }
}
