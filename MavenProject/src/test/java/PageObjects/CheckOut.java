package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Browser_Setup;

public class CheckOut extends Browser_Setup {
	
	public CheckOut(WebDriver driver) {
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
		//Browser_Setup.driver = driver;
		super();
		
		
	}
	private static WebElement Element = null;
	
	public static WebElement checkout (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='checkout']"));
		return Element;
		
	}
	
	public static WebElement finish (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='finish']"));
		return Element;
		
	}
	
	public static WebElement SuccesfullMessage (WebDriver driver) {
		Element= driver.findElement(By.xpath("//div[contains(text(),'Your order has been dispatched, and will arrive just as fast as the pony can get there!')]"));
		return Element;
		
	}
	public static WebElement RemoveItemBikeLight (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']"));
		return Element;
		
	}
	public static WebElement ContinueShopping (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='continue-shopping']"));
		return Element;
		
	}
	
	public void clickcheckout() {
		if(checkout(driver).isDisplayed()) {
			System.out.println("in clickcheckout");
			checkout(driver).click();
		}
		else
			Assert.fail("checkout is not displayed");
	}
	public void confirmcheckout() throws InterruptedException {
		finish(driver).click();
		Thread.sleep(1000);
}
	public void confirmationmessage() {
		if(SuccesfullMessage(driver).isDisplayed()) {
			System.out.println("Succesfull Message is Displayed");
		}
		else 
			Assert.fail("No Succesfull Message is Displayed");
	}
	public void RemoveFromCart() {
		if(RemoveItemBikeLight(driver).isDisplayed()) {
			RemoveItemBikeLight(driver).click();
		}
		else
			Assert.fail("Bike Light not visible in cart");
		
	}
	public void clickcontinueshopping() {
		if(ContinueShopping(driver).isDisplayed()) {
			ContinueShopping(driver).click();
		}
		else
			Assert.fail("continue shopping button not visible in cart");
		
	}
}