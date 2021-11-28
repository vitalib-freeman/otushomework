package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.model.Answer;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleEvaluationService implements EvaluationService {
  @Override
  public List<Answer> evaluate(List<Answer> answers) {
    return answers.stream()
       .map(ans -> new Answer(ans.getQuestion(), ans.getAnswer(), ans.getQuestion().getAnswerText().equals(ans.getAnswer())))
       .collect(Collectors.toList());
  }
}
