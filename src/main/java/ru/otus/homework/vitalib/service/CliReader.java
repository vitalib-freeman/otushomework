package ru.otus.homework.vitalib.service;

import java.util.Scanner;

public class CliReader implements Reader {
  private Scanner scanner;

  @Override
  public String read() {
    return scanner.nextLine();
  }
}
