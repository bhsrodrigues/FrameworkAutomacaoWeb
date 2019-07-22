package estudos.frameworkautomacaoweb.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		plugin = { "pretty",
					    "html:target/site/cucumber-pretty",
					    "json:target/cucumber.json" }, 
		tags = { "@amazon" },
		glue = { "estudos.frameworkautomacaoweb.specs" }
		)

public class RunTest {
	
}