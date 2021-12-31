package dev.educosta;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Gradle does not support JUnit platform discovery selectors yet. This class helps Gradle to discover all tests.
 * <p>
 * In order to run examples/scenarios, use 'gradle test'. Executing this class in your IDE won't work.
 *
 * @See <a href="https://stackoverflow.com/questions/64676559/feature-files-discovery-in-cucumber-junit-platform-engine">Thread</a>
 * @see <a href="https://github.com/gradle/gradle/issues/4773">Gradle 4773</a>
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "aero.sita.bdd.commons")
@Deprecated //Not working run .feature tests using Junit
public class CucumberIntegrationTest {

}
