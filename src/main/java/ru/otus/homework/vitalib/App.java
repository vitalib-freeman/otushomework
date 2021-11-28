package ru.otus.homework.vitalib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.vitalib.service.CliRunner;
import ru.otus.homework.vitalib.service.Runner;

@ComponentScan
@PropertySource("classpath:application.properties")
public class App {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    Runner runner = context.getBean(CliRunner.class);
    runner.run();
  }
}
