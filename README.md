# cucumber-bdd project
Using Cucumber + Spring Framework + Gradle to run BDD scenarios for End-to-End test.

### Library versions
- Cucumber 7.0
- Gradle 6.8.1
- JDK 11 
- Spring
- Spring Feign
- JUnit 5 (Jupiter)


### IntelliJ Plugin
For better experience while running and editing cucumber files install the following plugin.
- [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)
- [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin)
- [Cucumber+](https://plugins.jetbrains.com/plugin/16289-cucumber-)

# Running

Clone the repository
```bash
git clone git@github.com:educostadev/cucumber-bdd.git
cd cucumber-bdd
```

Run the Cucumber scenarios
```
./gradlew cucumber -DspringProfile=dev
```

Check the report: