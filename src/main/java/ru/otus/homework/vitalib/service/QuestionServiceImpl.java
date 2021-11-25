package ru.otus.homework.vitalib.service;

import ru.otus.homework.vitalib.dao.QuestionDao;
import ru.otus.homework.vitalib.model.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
  private final QuestionDao questionDao;

  public QuestionServiceImpl(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public List<Question> getQuestions() {
    return questionDao.getQuestions();
  }
}
