package ru.otus.homework.vitalib;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework.vitalib.service.QuestionService;

public class App {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    QuestionService questionService = context.getBean(QuestionService.class);
    questionService.getQuestions().forEach(System.out::println);
  }
}
