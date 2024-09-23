package fita.pageobjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fita.utilites.BaseClass;
import fita.utilites.Utilities;

public class LoginPage{

	public By useremail=By.id("userEmail");
	By userpassword=By.id("userPassword");
	By loginbutton=By.id("login");

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	public WebElement userEmail;
	
	public WebElement getElement(String path)
	{
		return this.getElement(path);
	}
	public void enterUseremail() throws InvalidFormatException, IOException
	{
		driver.findElement(useremail).sendKeys(Utilities.getUsername());
	}
	
	public void enterUserpassword() throws InvalidFormatException, IOException
	{
		driver.findElement(userpassword).sendKeys(Utilities.getPassword());
	}
	
	public void clickLogin()
	{
		driver.findElement(loginbutton).click();
	}
	
	public void performLogin() throws InvalidFormatException, IOException
	{
		enterUseremail();
		enterUserpassword();
		clickLogin();
	}
}
