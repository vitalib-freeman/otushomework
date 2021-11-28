package ru.otus.homework.vitalib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.vitalib.service.QuestionService;
import ru.otus.homework.vitalib.utils.DataParser;

@ComponentScan
@PropertySource("classpath:application.properties")
public class App {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    QuestionService questionService = context.getBean(QuestionService.class);
    questionService.getQuestions().forEach(System.out::println);
  }
}
