package estudos.frameworkautomacaoweb.drivermanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{

	@Override
	public void createDriver() {

		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
		@SuppressWarnings("unused")
		FirefoxOptions options = new FirefoxOptions();
		//TO DO - implementar 
		this.driver = new FirefoxDriver();
		
	}

}
