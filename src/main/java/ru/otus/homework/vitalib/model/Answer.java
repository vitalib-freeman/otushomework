package ru.otus.homework.vitalib.model;

import java.util.Objects;

public class Answer {

  private final Question question;
  private final String answer;
  private final boolean isCorrect;

  public Answer(Question question, String answer) {
    this.question = question;
    this.answer = answer;
    this.isCorrect = false;
  }

  public Answer(Question question, String answer, boolean isCorrect) {
    this.question = question;
    this.answer = answer;
    this.isCorrect = isCorrect;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public String getAnswer() {
    return answer;
  }

  public Question getQuestion() {
    return question;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Answer answer1 = (Answer) o;
    return isCorrect == answer1.isCorrect && Objects.equals(question, answer1.question) && Objects.equals(answer, answer1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question, answer, isCorrect);
  }
}
