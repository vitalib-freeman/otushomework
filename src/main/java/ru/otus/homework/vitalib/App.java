package ru.otus.homework.vitalib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.homework.vitalib.service.Runner;

@SpringBootApplication
@EnableConfigurationProperties
public class App {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    Runner runner = context.getBean(Runner.class);
    runner.run();
  }
}
