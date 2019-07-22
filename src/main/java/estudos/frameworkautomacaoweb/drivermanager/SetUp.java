package estudos.frameworkautomacaoweb.drivermanager;

import estudos.frameworkautomacaoweb.common.CommonFunctions;

public class SetUp {

	
	protected void setUpBrowser() {
		
		if (CommonFunctions.driver == null) {
			CommonFunctions.driver  = DriverFactoryManager.getDriverManager(DriverType.CHROME).getWebDriver();
			CommonFunctions.driver.manage().window().maximize();
		}
	}
	
	protected void tearDownBrowser() {
		CommonFunctions.driver.quit();
		CommonFunctions.driver = null;
	}
}
