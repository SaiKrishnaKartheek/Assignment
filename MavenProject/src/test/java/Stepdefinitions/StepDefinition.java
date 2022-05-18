package Stepdefinitions;
import java.util.Map;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import base.Browser_Setup;
import PageObjects.HomePage;
import PageObjects.Information;
import PageObjects.LoginPage;
import PageObjects.CheckOut;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends base.Browser_Setup{
	public static String email;
	public static String password;
	public static String envData ;
	public static String driverType;
	public static String url="https://www.saucedemo.com/";

	
	@Before
	public void startTest() { // happen before each test scenario
		driverType = "chrome";
		
		driver = Browser_Setup(driverType);
		//driver.get(url);
	}

	@After
	public void endTest(Scenario scenario) {

		if (scenario.isFailed()) {
			Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
		}
		driver.quit();
	}
	
	LoginPage login = new LoginPage(driver);
	HomePage  Homepage = new HomePage(driver);
	CheckOut checkout= new CheckOut(driver);
	Information info = new Information(driver);
	
	@Given("user is on saucedemo homepage")
	       
	public void Saucedemo() {
		System.out.println("in to user is on sauce demo homepage step");
		login.LoginPageDisplayed();
   
	}
	@And("user logged in using {string} , {string} credentials")
	public void LogintoSaucedemo(String username,String password) throws InterruptedException {
		System.out.println("in to user looged in step");
		login.Login(username,password);
		Thread.sleep(2000);
		Boolean HomepageVisible= Homepage.HomePageCheck();
		System.out.println(HomepageVisible);
   
	}
	@And("user adds required item to cart")
	public void AddItemsToCart() throws InterruptedException {
		/*if(!Homepage.HomePageCheck()) {
			Assert.fail();
		}*/
		System.out.println("in AddItmes to Cart");
		Homepage.AddRequiredToCart();
	}
	@And("user proceeds to checkout")
	public void CheckOut() {
		checkout.clickcheckout();
	}
	@And("user enters {string} , {string} , {string} details for checkout")
	public void i_input_details(String FirstName, String LastName,String PostalCode) {
		info.InputDetails(FirstName,LastName,PostalCode);
		System.out.println("Inputted Details Succesfully");
	}
	@When("User Confirms checkout")
	public void ConfirmCheckOut() throws InterruptedException {
		checkout.confirmcheckout();
	}
	@Then("User Verify Final Confirmation Message")
	public void confirmmessage() {
		checkout.confirmationmessage();
	}
	@And("user adds one item and then remove that item to go back")
	public void AddItemRemove() throws InterruptedException {
		Homepage.AddItemToCart();
		checkout.RemoveFromCart();
		checkout.clickcontinueshopping();
		}
	@And("user sorts item low to high")
	public void SortItemsLowtoHigh() throws InterruptedException {
		Homepage.SortPriceLowToHigh();
	}
}