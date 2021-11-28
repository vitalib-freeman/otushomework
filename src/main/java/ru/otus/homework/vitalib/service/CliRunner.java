package ru.otus.homework.vitalib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.vitalib.model.Answer;
import ru.otus.homework.vitalib.model.Question;
import ru.otus.homework.vitalib.model.VerifiedAnswer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CliRunner implements Runner {
  private final Writer writer;
  private final Reader reader;
  private final QuestionService questionService;
  private final EvaluationService evaluationService;
  private final GradeService gradeService;
  private final double passRate;

  public CliRunner(Writer writer,
                   Reader reader,
                   QuestionService questionService,
                   EvaluationService evaluationService,
                   GradeService gradeService,
                   @Value("${passRate}") double passRate) {
    this.writer = writer;
    this.reader = reader;
    this.questionService = questionService;
    this.evaluationService = evaluationService;
    this.gradeService = gradeService;
    this.passRate = passRate;
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
    List<VerifiedAnswer> verifiedAnswers = evaluationService.evaluate(answers);
    boolean hasPass = gradeService.hasPass(verifiedAnswers, passRate);
    if (hasPass) {
      writer.write("Congratulations, you have passed");
    } else {
      writer.write("Sorry, you have failed");
    }

  }
}
