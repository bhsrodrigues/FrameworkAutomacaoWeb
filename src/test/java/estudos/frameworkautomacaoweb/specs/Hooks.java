package estudos.frameworkautomacaoweb.specs;


import estudos.frameworkautomacaoweb.common.CommonFunctions;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void beforeScenario(Scenario scenario){
		String nomeCenario;
		nomeCenario = scenario.getName();
		CommonFunctions.scenarioName = nomeCenario;
		CommonFunctions.screenshotIndex = 1;
		CommonFunctions.firstExecution();
    }	
}