package estudos.frameworkautomacaoweb.drivermanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		String pastaChromeForTesting = "rc/test/resources/Navegador/chrome/chrome.exe";
		ChromeOptions options = new ChromeOptions();
		options.setBinary(pastaChromeForTesting);
		this.driver = new ChromeDriver(options);
		
	}

}
