package fita.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import fita.utilites.BaseClass;

public class HomePage extends BaseClass{

	By homeHeader=By.xpath("//button[text()=' HOME ']");
	By add_Zara=By.xpath("//b[contains(text(),'ZARA')]/../following-sibling::button[contains(text(),'Add')]");
	By add_Iphone=By.xpath("//b[contains(text(),'IPHONE')]/../following-sibling::button[contains(text(),'Add')]");
	By add_Shoe=By.xpath("//b[contains(text(),'ADIDAS')]/../following-sibling::button[contains(text(),'Add')]");
	By productZara=By.xpath("//b[contains(text(),'ZARA')]");
	By productIphone=By.xpath("//b[contains(text(),'IPHONE')]");
	
	public void addProduct(String product)
	{
		driver.findElement(By.xpath("//b[contains(text(),'"+product+"')]/../following-sibling::button[contains(text(),'Add')]")).click();
		
	}
	public void checkHomepageLoaded()
	{
		String actual=driver.findElement(homeHeader).getText();
		Assert.assertEquals(actual, "HOME");
	}
	
	public void addProductZara()
	{
		driver.findElement(add_Zara).click();
	}
	
	public void addProductIphone()
	{
		driver.findElement(add_Iphone).click();
	}
	
	public void addProductAdidas()
	{
		driver.findElement(add_Shoe).click();
	}
	
	public String getProductZara()
	{
		String product=driver.findElement(productZara).getText();
		return product;
	}
	
	public String getProductIphone()
	{
		String product=driver.findElement(productIphone).getText();
		return product;
	}
}
