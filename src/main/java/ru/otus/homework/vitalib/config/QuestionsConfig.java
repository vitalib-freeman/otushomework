package ru.otus.homework.vitalib.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "questions")
public class QuestionsConfig {
  private String filePath;
  private double passRate;

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public double getPassRate() {
    return passRate;
  }

  public void setPassRate(double passRate) {
    this.passRate = passRate;
  }
}
