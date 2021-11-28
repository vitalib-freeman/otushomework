package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.model.Answer;

import java.util.List;

public interface EvaluationService {
  List<Answer> evaluate(List<Answer> answers);
}
