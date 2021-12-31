# cucumber-bdd project
This project show how to use Cucumber + Spring Framework + Gradle to run BDD scenarios for End-to-End test.
It is used a public rest API at "Go REST" to make request and show the behaviour. See the `Running` session bellow.

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

After these plugins be installed you can right click on `.feature` files and run it.

# Running

Clone the repository
```bash
git clone git@github.com:educostadev/cucumber-bdd.git
cd cucumber-bdd
```

Run the cucumber scenario annotated with @success.
```
./gradlew cucumber -DspringProfile=dev -PcucumberArgs="--tags,@success"
```

Run the cucumber scenarios and ignore the ones annotated with @ignore
```
./gradlew cucumber -DspringProfile=dev -PcucumberArgs="--tags,not @ignore"
```

Create an account at  [gorest.con.in](https://gorest.co.in) and get your ACCESS TOKEN, so edit the file `app/src/test/resources/application-dev.xml` and add your ACCESS TOKEN into the `access-token` entry or pass the value as environment variable named `GO_REST_ACCESS_TOKEN` when run.

Run all cucumber scenarios
```
./gradlew cucumber -DspringProfile=dev
```

Or on Linux you can pass the token as environment variable the following way:

```
GO_REST_ACCESS_TOKEN=<TOKEN VALUE>  ./gradlew clean cucumber -DspringProfile=dev
```

Check the report: `app/build/cucumber-reports/index.html`

# Good to know
- The `gradle.build` has a `cucumber` task to run the scenarios by command line. 
- In this example your scenarios should call a step with the commons package becaus the `CucumberSpringConfiguration` class need to be discovered.
- The `CucumberIntegrationTest` is not working. Should be possible run it inside intellij or using `./gradlew test`.