package estudos.frameworkautomacaoweb.drivermanager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	public abstract void createDriver();
	
	public void quitDriver() {
		if (driver != null) {
			driver.close();
		}
	}
	
	public WebDriver getWebDriver() {
		if (driver == null) {
			createDriver();
		}
		
		return driver;
	}
	
}
