package PageObjects;
import java.text.BreakIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import base.*;
import junit.framework.Assert;

public class HomePage extends Browser_Setup {

	public HomePage(WebDriver driver) {
		super();
		
		
		
	}
private static WebElement Element = null;
private static boolean check = true;
	
	public static WebElement Products (WebDriver driver) {
		Element= driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
		return Element;
		
	}
	public static WebElement AddProductBackpack (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		return Element;
		
	}
	public static WebElement Cart (WebDriver driver) {
		Element= driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
		return Element;
		
	}
	public static WebElement AddProductbileLight (WebDriver driver) {
		Element= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
		return Element;
		
	}
	
	public static WebElement ClickSort (WebDriver driver) {
		Element= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		return Element;
		
	}
	
public  boolean HomePageCheck(){
	check= Products(driver).isDisplayed();
	if(!Products(driver).isDisplayed()) {
		System.out.println("Home Page is Not displayed");
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
		Assert.fail("Browser not in Home Page");
	}
	return check;
	
}
public void AddRequiredToCart() throws InterruptedException {
	System.out.println("in AddtoCart");
	AddProductBackpack(driver).click();
	Thread.sleep(1000);
	Cart(driver).click();
	Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
	
}
public void AddItemToCart() throws InterruptedException {
	System.out.println("in AddtoCart");
	AddProductbileLight(driver).click();
	Thread.sleep(1000);
	
	Cart(driver).click();
	Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
}
public void SortPriceLowToHigh() throws InterruptedException {
	System.out.println("in AddtoCart");
	Select sort = new Select(ClickSort(driver));
	sort.selectByValue("lohi");
	System.out.println("Sorted from Low to High");
	Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
}

}