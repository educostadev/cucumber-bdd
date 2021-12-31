package dev.educosta.commons;


import dev.educosta.gorest.GoRestFeignClient;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class CommonSteps {

  @Autowired
  private HealthChecker healthChecker;

  @Value("${backing-services.gorest-api.host}")
  private String gorest;

  /**
   * This step is into common package together with the CucumberSpringConfiguration to demonstrate that us MUST call this step in all your scenario to this
   * package be added as cucumber glue. This service could be generic and check if the service X is running.
   */
  @Given("there is internet connection")
  public void hasInternet() {
    String url = gorest + GoRestFeignClient.HEALTH_ROUTE;
    log.info("Check access to {}", url);
    boolean isRunning = healthChecker.execute(url);
    Assertions.assertTrue(isRunning);
  }

}
