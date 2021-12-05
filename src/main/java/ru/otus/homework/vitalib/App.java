package ru.otus.homework.vitalib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.vitalib.config.QuestionsConfig;
import ru.otus.homework.vitalib.service.CliRunner;
import ru.otus.homework.vitalib.service.Runner;

@SpringBootApplication
@EnableConfigurationProperties
@PropertySource("application.yml")
public class App {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    Runner runner = context.getBean(Runner.class);
    runner.run();
  }
}
