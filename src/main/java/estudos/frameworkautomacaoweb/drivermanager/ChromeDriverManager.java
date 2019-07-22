package estudos.frameworkautomacaoweb.drivermanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		
	}

}
