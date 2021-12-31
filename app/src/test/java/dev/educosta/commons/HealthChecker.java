package dev.educosta.commons;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import io.restassured.internal.http.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@Slf4j
public class HealthChecker {

  private final RestTemplate restTemplate = new RestTemplate();

  public boolean execute(String healthHostAndEndpoint) {
    log.info("Check if service is running at {}", healthHostAndEndpoint);
    var response = this.restTemplate.exchange(
      healthHostAndEndpoint,
      HttpMethod.GET,
      buildHttpEntity(),
      String.class
    );
    var status = response.getStatusCode();
    log.debug("Health Check Response [{}]: {}", status, response.getBody());
    return Status.SUCCESS.matches(status.value());
  }

  private HttpHeaders generateStandardHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    return headers;
  }

  private <T> HttpEntity<T> buildHttpEntity() {
    return new HttpEntity<>(generateStandardHeaders());
  }

}
