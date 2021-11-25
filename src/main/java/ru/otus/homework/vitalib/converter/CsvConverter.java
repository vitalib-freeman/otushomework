package ru.otus.homework.vitalib.converter;

import ru.otus.homework.vitalib.model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
  public static List<Question> convert(List<String[]> allRows) {
    return allRows.stream()
       .map(line -> new Question(line[0], line[1]))
       .collect(Collectors.toList());
  }
}
