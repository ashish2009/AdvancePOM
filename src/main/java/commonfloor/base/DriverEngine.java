package commonfloor.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverEngine {
	
	private static WebDriver driver;
	public static WebDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", "/home/quikr/Documents/Browser-Driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://groups-stage4.commonfloor.com/");
		driver.manage().window().maximize();
		return driver;
	}

}
