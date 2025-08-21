package estudos.frameworkautomacaoweb.drivermanager;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager{

	@Override
	public void createDriver() {
		
		System.setProperty("java.net.preferIPv4Stack", "true");
		System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/geckodriver.exe");
		EdgeOptions options = new EdgeOptions();
		
		this.driver = new EdgeDriver();
		
	}
}
