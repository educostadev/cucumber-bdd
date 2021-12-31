package dev.educosta.gorest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "goRestFeignClient", url = "${backing-services.gorest-api.host}")
public interface GoRestFeignClient {

  String HEALTH_ROUTE = "/public/v1/users";

  @RequestMapping(method = RequestMethod.GET, value = HEALTH_ROUTE)
  ResponseEntity<String> checkHealth();

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE, value = "/public/v1/users/{userId}")
  String readUser(@PathVariable("userId") Integer userId);

  @RequestMapping(method = RequestMethod.POST, value = "/public/v1/users")
  UserResponse createUser(@RequestHeader("Authorization") String bearerToken, @RequestBody User user);

}
