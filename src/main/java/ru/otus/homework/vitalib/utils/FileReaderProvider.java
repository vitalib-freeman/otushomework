package ru.otus.homework.vitalib.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReaderProvider implements ReaderProvider {

  @Override
  public Reader getDataReader(String path) {
    InputStream csvStream = Thread.currentThread()
       .getContextClassLoader()
       .getResourceAsStream(path);
    return new InputStreamReader(csvStream);
  }
}
