package estudos.frameworkautomacaoweb.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		plugin = { "pretty",
					    "html:target/site/cucumber-pretty",
					    "json:target/cucumber.json" },
		glue = { "estudos.frameworkautomacaoweb.specs" }
		)

public class RunTest {
	
}