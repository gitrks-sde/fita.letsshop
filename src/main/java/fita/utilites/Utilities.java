package fita.utilites;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Utilities extends BaseClass {

	static File file = new File(
			"C:\\Users\\karth\\eclipse-workspace\\fita.letsshop\\external_resources\\sampleinput.xlsx");

	public static String getLocator(String identifier) throws InvalidFormatException, IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("WebElement");// name or index
		String locator = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row.getCell(0).toString().equals(identifier)) {
				locator = row.getCell(1).toString();
				break;
			}

		}
		workbook.close();
		return locator;
	}

	public static String getUsername() throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("logininfo");// name or index
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);

		workbook.close();
		return cell.toString();

	}

	public static String getPassword() throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("logininfo");// name or index
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(0);

		workbook.close();
		return cell.toString();

	}

	public void getWebElementById() throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("WebElement");
		String element = null;
		System.out.println(sheet.getDefaultRowHeight());
		for (int i = 0; i <= sheet.getDefaultRowHeight(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row.getCell(i).equals("userEmail")) {
				element = row.getCell(1).toString();
				break;
			}
		}
		System.out.println(element);

	}
}
