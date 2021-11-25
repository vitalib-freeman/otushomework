package ru.otus.homework.vitalib.dao;

import ru.otus.homework.vitalib.model.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuestionDaoImplTest {

  @Test
  public void getQuestionsFromFile() {
    QuestionDao questionDao = new QuestionDaoCsv("test.csv");
    List<Question> questions = questionDao.getQuestions();
    assertNotNull(questions);
  }
}