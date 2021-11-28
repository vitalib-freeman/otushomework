package ru.otus.homework.vitalib.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.vitalib.model.Answer;
import ru.otus.homework.vitalib.model.Question;
import ru.otus.homework.vitalib.model.VerifiedAnswer;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RunnerTest {
  @Mock
  CliWriter writer;
  @Mock
  private CliReader reader;
  @Mock
  private QuestionServiceImpl questionService;
  @Mock
  private SimpleEvaluationService evaluationService;
  @Mock
  private SimpleGradeService gradingService;

  @Test
  public void testSuccessTest() {
    Question question = new Question("QuestionText", "QuestionAnswer");
    List<Question> questions = List.of(question);
    Answer answer = new Answer(question, "QuestionAnswer");
    List<Answer> answers = List.of(answer);
    VerifiedAnswer verifiedAnswer = new VerifiedAnswer(question, "QuestionAnswer", true);
    when(questionService.getQuestions()).thenReturn(questions);
    when(reader.read()).thenReturn("QuestionAnswer");
    when(evaluationService.evaluate(answers)).thenReturn(List.of(verifiedAnswer));
    when(gradingService.hasPass(List.of(verifiedAnswer), 1d)).thenReturn(true);

    new CliRunner(writer, reader, questionService, evaluationService, gradingService, 1d).run();

    verify(writer).write("Hi, pls enter your name: ");
    verify(questionService).getQuestions();
    verify(writer).write("---> QuestionText: ");
    verify(reader, Mockito.times(2)).read();
    verify(evaluationService).evaluate(answers);
    verify(gradingService).hasPass(List.of(verifiedAnswer), 1);
    verify(writer).write("Congratulations, you have passed the test\n");
  }
}