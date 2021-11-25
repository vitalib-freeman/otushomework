package ru.otus.homework.vitalib.model;

public class Question {
  private String questionText;
  private String answerText;

  public Question(String text, String answer) {
    this.questionText = text;
    this.answerText = answer;
  }

  @Override
  public String toString() {
    return "Question: " + questionText + "\n\tAnswer:" + answerText;
  }
}
