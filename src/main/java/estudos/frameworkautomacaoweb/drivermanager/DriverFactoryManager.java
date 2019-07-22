package estudos.frameworkautomacaoweb.drivermanager;

public class DriverFactoryManager {
	
	public static DriverManager getDriverManager(DriverType type) {
		
		DriverManager driverManager = null;
		
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
		default:
			break;
		}
		
		return driverManager;
		
	}

}
