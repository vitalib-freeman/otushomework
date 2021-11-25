package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.dao.QuestionDao;
import ru.otus.homework.vitalib.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
  @InjectMocks
  private QuestionServiceImpl questionService;
  @Mock
  private QuestionDao questionDao;

  @Test
  public void getSimpleQuestionList() {
    List<Question> preparedQuestions = List.of(new Question("Question", "Answer"));
    when(questionDao.getQuestions()).thenReturn(preparedQuestions);

    List<Question> questions = questionService.getQuestions();

    assertAll(
       () -> assertNotNull(questions),
       () -> assertEquals(preparedQuestions, questions),
       () -> verify(questionDao).getQuestions()
    );
  }
}
