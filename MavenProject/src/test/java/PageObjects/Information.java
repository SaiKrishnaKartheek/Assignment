package PageObjects;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assertthat.selenium_shutterbug.core.Capture;

import base.Browser_Setup;

public class Information extends Browser_Setup {
	
	public Information(WebDriver driver) {
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
		//Browser_Setup.driver = driver;
		super();
		
		
	}
	private static WebElement Element = null;
	
	public static WebElement FirstName (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='first-name']"));
		return Element;
		
	}
	public static WebElement LastName (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='last-name']"));
		return Element;
		
	}
	public static WebElement Zipcode (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='postal-code']"));
		return Element;
		
	}
	public static WebElement Continue (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='continue']"));
		return Element;
		
	}
	public void InputDetails(String firstname, String lastname, String postalcode) {
		FirstName(driver).sendKeys(firstname);
		LastName(driver).sendKeys(lastname);
		Zipcode(driver).sendKeys(postalcode);
	
		Continue(driver).click();
	}
}