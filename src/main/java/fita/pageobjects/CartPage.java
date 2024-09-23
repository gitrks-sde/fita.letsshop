package fita.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="userEmail")
	public WebElement userEmail;
	
	@FindBy(xpath="//button[contains(text(),'Cart') and @class='btn btn-custom']/i")
	WebElement cartbutton;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	WebElement productOnCart;
	
	
	public void clickOnCart()
	{
		cartbutton.click();
	}
	
	public String getProductOnCart()
	{
		return productOnCart.getText();
	}
	
	public void checkIfProductAdded(String expected)
	{
		String actual=productOnCart.getText();
		Assert.assertEquals(actual, expected);
	}
}
