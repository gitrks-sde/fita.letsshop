package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import fita.pageobjects.CartPage;
import fita.pageobjects.HomePage;
import fita.pageobjects.LoginPage;
import fita.utilites.BaseClass;
import fita.utilites.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
		
	@Before
	public void load_browser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		BaseClass.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		Thread.sleep(4000);
	}

	@After
	public void closeConnection() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();
	}
	
	@BeforeStep
	public void beforesteps(Scenario s)
	{
		System.out.println(s.getName());
	}
	
	@Given("Letsshop URL is loaded")
	public void letsshop_url_is_loaded() throws InterruptedException {
		

	}

	@When("user enter the email")
	public void user_enter_the_email() throws InvalidFormatException, IOException {
		LoginPage login=new LoginPage(driver);
		login.enterUseremail();
	}

	@When("user enter the password")
	public void user_enter_the_password() throws InvalidFormatException, IOException {
		LoginPage login=new LoginPage(driver);
		login.enterUserpassword();
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		LoginPage login=new LoginPage(driver);
		login.clickLogin();
	}

	@Then("check navigates to homepage")
	public void check_navigates_to_homepage() {
		HomePage homePage=new HomePage();
		homePage.checkHomepageLoaded();
	}
	
	@When("user add fashion product")
	public void user_add_fashion_product() {
		HomePage homePage=new HomePage();
		homePage.addProductZara();
	}

	@When("user click on carts")
	public void user_click_on_carts() throws InterruptedException {
		CartPage cartPage=new CartPage(driver);
		Thread.sleep(5000);
		cartPage.clickOnCart();
	}

	@When("user add electronic product")
	public void user_add_electronic_product() {
		HomePage homePage=new HomePage();
		homePage.addProductIphone();
	}
	
	@When("user click on {string} product to add")
	public void user_click_on_product_to_add(String string) {
		HomePage homePage=new HomePage();
		homePage.addProduct(string);
		
	}
	

	@When("user enter the email {string} with path {string}")
	public void entertext(String string, String path) throws InvalidFormatException, IOException
	{
		getElementByID(path).sendKeys(string);

	}
	
	@When("user clicks on the login button with id {string}")
	public void clickLogin(String path) throws InvalidFormatException, IOException
	{
		getElementByID(path).click();
	}
	
	@When("^user clicks on \"(.*)\" product to add$")
	public void user_clicks_on_product_to_add(String products) {
		HomePage homePage=new HomePage();
		homePage.addProduct(products.toUpperCase());
	}
	
	

	
	@And("close the browser")
	public void close_the_browser() throws InterruptedException {
	
	}
	

}
