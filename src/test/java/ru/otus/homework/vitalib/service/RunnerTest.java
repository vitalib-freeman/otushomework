package ru.otus.homework.vitalib.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.vitalib.model.Answer;
import ru.otus.homework.vitalib.model.Question;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RunnerTest {
  @Mock
  CliWriter writer;

  @Mock
  private CliReader reader;

  @InjectMocks
  CliRunner runner;

  @Mock
  private QuestionServiceImpl questionService;
  @Mock
  private SimpleEvaluationService evaluationService;

  @Test
  public void testRunner() {
    Question question = new Question("QuestionText", "QuestionAnswer");
    List<Question> questions = List.of(question);
    Answer questionAnswer = new Answer(question, "QuestionAnswer", false);
    List<Answer> answers = List.of(questionAnswer);
    when(questionService.getQuestions()).thenReturn(questions);
    when(reader.read()).thenReturn("QuestionAnswer");

    runner.run();

    verify(writer).write("Hi, input pls your name: ");
    verify(questionService).getQuestions();
    verify(writer).write("QuestionText");
    verify(reader, Mockito.times(2)).read();
    verify(evaluationService).evaluate(answers);
  }

}