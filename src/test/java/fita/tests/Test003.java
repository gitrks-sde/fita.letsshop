package fita.tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fita.pageobjects.LoginPage;
import fita.utilites.BaseClass;

public class Test003 extends BaseClass{

	static String product;	
	
	@Test()
	public void loginApp() throws InvalidFormatException, IOException
	{

		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUseremail();
		loginPage.enterUserpassword();
		loginPage.clickLogin();

		String actual = driver.findElement(By.xpath("//button[text()=' HOME ']")).getText();
		Assert.assertEquals(actual, "HOME");
	}
	@Test(groups= {"smoke","Regression"}, dependsOnMethods="loginApp")
	public void addProductIphone() throws InterruptedException
	{
		driver.findElement(By.xpath("//b[contains(text(),'IPHONE')]/../following-sibling::button[contains(text(),'Add')]")).click();
		product=driver.findElement(By.xpath("//b[contains(text(),'IPHONE')]")).getText();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods="addProductIphone")
	public void checkIfProductAdded() throws InterruptedException
	{
		WebElement cartButton=driver.findElement(By.xpath("//button[contains(text(),'Cart') and @class='btn btn-custom']/i"));
		Thread.sleep(5000);
		cartButton.click();
		String productAtCart=driver.findElement(By.xpath("/div[@class='cartSection']/h3")).getText();
		Assert.assertEquals(product, productAtCart);
		
	}
}
