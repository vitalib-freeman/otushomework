package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.model.Answer;

import java.util.List;

public interface Runner {
  void run();
  void printResult(boolean hasPass);
  boolean getGrade(List<Answer> answers);
  List<Answer> getUserAnswers(String userName);
  String getUserName();
}
