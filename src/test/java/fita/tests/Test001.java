package fita.tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fita.pageobjects.CartPage;
import fita.pageobjects.HomePage;
import fita.pageobjects.LoginPage;
import fita.utilites.BaseClass;

public class Test001 extends BaseClass {

	static String product;
	
	@Test(testName="TC-002")
	public void loginApp() throws InvalidFormatException, IOException
	{

		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.performLogin();
		HomePage homePage=new HomePage();
		homePage.checkHomepageLoaded();
		
	}
	@Test(dependsOnMethods="loginApp",testName="TC-005")
	public void addProduct() throws InterruptedException, IOException
	{
		HomePage homePage=new HomePage();
		homePage.addProductZara();
		product=homePage.getProductZara();
		test.info(product);
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="addProduct",testName="TC-006")
	public void checkIfProductAdded() throws InterruptedException, IOException
	{
		CartPage cartPage=new CartPage(driver);
		Thread.sleep(5000);
		cartPage.clickOnCart();
		cartPage.checkIfProductAdded(product);
		
		
	}
	
	
}
