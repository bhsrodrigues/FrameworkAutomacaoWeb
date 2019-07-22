package estudos.frameworkautomacaoweb.specs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import estudos.frameworkautomacaoweb.common.CommonFunctions;

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