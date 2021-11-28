package ru.otus.homework.vitalib.service;

import java.io.PrintWriter;

public class CliWriter implements Writer {
  private final PrintWriter writer;

  public CliWriter() {
    writer = new PrintWriter(System.out);
  }

  @Override
  public void write(String data) {
    writer.write(data);
  }
}
