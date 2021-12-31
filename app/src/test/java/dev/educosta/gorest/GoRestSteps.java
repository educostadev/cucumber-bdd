package dev.educosta.gorest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class GoRestSteps {

  @Autowired
  GoRestFeignClient goRestFeignClient;


  @Value("${backing-services.gorest-api.access-token}")
  private String token;

  UserResponse response;

  @When("I create the user with name {string}")
  public void createUser(String name) {
    Assertions.assertThat(token).isNotNull();
    log.info("Creating user {}", name);
    var user = User.builder()
        .name(name)
        .gender("Male")
        .email(UUID.randomUUID().toString() + "@bddtest.com")
        .status("active")
        .build();
    response = goRestFeignClient.createUser("Bearer " + token, user);
    log.info("Creating response {}", response);
  }


  @Then("I will have user created with success")
  public void readUSer() {
    Assertions.assertThat(response).isNotNull();
    var user = goRestFeignClient.readUser(response.getData().getId());
    log.info("Reading response {}", user);
    Assertions.assertThat(user).isNotNull();
  }

}
