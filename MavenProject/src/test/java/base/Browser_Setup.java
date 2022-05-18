package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Setup{
	public static WebDriver driver;
	








public static WebDriver Browser_Setup(String browser) {
	if (browser.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	if (browser.contains("firefox")) {
		WebDriverManager.firefoxdriver().setup();	
		driver = new FirefoxDriver();
	}
	if (browser.contains("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
	
}
}
	
