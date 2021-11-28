package ru.otus.homework.vitalib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.vitalib.model.Answer;
import ru.otus.homework.vitalib.model.Question;
import ru.otus.homework.vitalib.model.VerifiedAnswer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CliRunner extends Runner {
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
  protected void printResult(boolean hasPass) {
    if (hasPass) {
      writer.write("Congratulations, you have passed the test\n");
    } else {
      writer.write("Sorry, you have failed the test\n");
    }
  }

  @Override
  protected boolean getGrade(List<Answer> answers) {
    List<VerifiedAnswer> verifiedAnswers = evaluationService.evaluate(answers);
    return gradeService.hasPass(verifiedAnswers, passRate);
  }

  @Override
  protected List<Answer> getUserAnswers(String userName) {
    writer.write(String.format("%s, please answer the following questions:\n", userName));
    List<Question> questions = questionService.getQuestions();
    List<Answer> answers = new ArrayList<>();
    for (Question question : questions) {
      writer.write(String.format("---> %s: ", question.getQuestionText()));
      String answer = reader.read();
      answers.add(new Answer(question, answer));
    }
    return answers;
  }

  @Override
  protected String getUserName() {
    writer.write("Hi, pls enter your name: ");
    return reader.read();
  }
}
