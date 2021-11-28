package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.model.Answer;
import ru.otus.homework.vitalib.model.Question;

import java.util.ArrayList;
import java.util.List;

public class CliRunner implements Runner {
  private final Writer writer;
  private final Reader reader;
  private final QuestionService questionService;
  private final EvaluationService evaluationService;

  public CliRunner(Writer writer,
                   Reader reader,
                   QuestionService questionService,
                   EvaluationService evaluationService) {
    this.writer = writer;
    this.reader = reader;
    this.questionService = questionService;
    this.evaluationService = evaluationService;
  }
  @Override
  public void run() {
    writer.write("Hi, input pls your name: ");
    String userName = reader.read();
    List<Question> questions = questionService.getQuestions();
    List<Answer> answers = new ArrayList<>();
    for (Question question : questions) {
      writer.write(question.getQuestionText());
      String answer = reader.read();
      answers.add(new Answer(question, answer));
    }
    evaluationService.evaluate(answers);

  }
}
