package fita.utilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeSuite
	public void openURL() throws InterruptedException {
		String path = "C:\\Users\\karth\\eclipse-workspace\\" + "e-commercetest\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Owner", "Fita");
		extent.setSystemInfo("System", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "SIT");

	}
//	@BeforeTest
//	public void loadURL() throws InterruptedException
//	{
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Thread.sleep(4000);
//
//	}

	public void capturScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File("C:\\Users\\karth\\eclipse-workspace\\fita.letsshop\\testScreenshots\\testss.png"));
	}

	public WebElement getElementByID(String key) throws InvalidFormatException, IOException {
		String locator = Utilities.getLocator(key);
		WebElement ele = driver.findElement(By.id(locator));
		return ele;
	}

	public WebElement getElementByXPath(String key) throws InvalidFormatException, IOException {
		String locator = Utilities.getLocator(key);
		WebElement ele = driver.findElement(By.xpath(locator));

		return ele;
	}

	@AfterSuite
	public void end() {
		extent.flush();
	}
}
