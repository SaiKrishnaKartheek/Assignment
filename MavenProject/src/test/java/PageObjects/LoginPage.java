package PageObjects;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import base.*;
import junit.framework.Assert;

public class LoginPage extends Browser_Setup {
	
	public LoginPage(WebDriver driver) {
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
		//Browser_Setup.driver = driver;
		super();
		
		
	}
	private static WebElement Element = null;
	
	public static WebElement UserName (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='user-name']"));
		return Element;
		
	}
	
	public static WebElement Password (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='password']"));
		return Element;
		
	}
	
	public static WebElement LoginBtn (WebDriver driver) {
		Element= driver.findElement(By.xpath("//input[@id='login-button']"));
		return Element;
		
	}
	//@FindBy(xpath= "//input[@id='user-name']")
	//public WebElement UserName;
	//= driver.findElement(By.xpath("//input[@id='user-name']"));
	
	/*@FindBy(xpath="//input[@id='password']")
	public WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
	public WebElement LoginBtn; */
	
	

	public void Login(String Username, String password) {
		UserName(driver).sendKeys(Username);
		Password(driver).sendKeys(password);
		LoginBtn(driver).click();
		
		
	}
	public void LoginPageDisplayed() {
		if(!UserName(driver).isDisplayed()) {
			//System.out.println("In If Loop");
			Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
			Assert.fail("Browser not in Login Page");
			
		}
		
	}

}