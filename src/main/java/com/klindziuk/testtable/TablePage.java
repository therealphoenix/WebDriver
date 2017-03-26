package com.klindziuk.testtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePage {
	WebDriver driver;
	By dataBaseLocator = By.cssSelector("li.database:nth-child(2) > a:nth-child(3)");
	By tableSelector = By.cssSelector("#row_tbl_1 > th:nth-child(2) > a:nth-child(1)");
	By structureSelector = By.cssSelector("img.icon:nth-child(6)");
	By columnSelector = By.cssSelector(
			".table > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > i:nth-child(2) > a:nth-child(2)");

	public TablePage(WebDriver driver) {

		this.driver = driver;
		this.driver = driver;
		// Checking for right page is opened - we can move this method to
		// abstract class
		if ((!driver.getTitle().equals("localhost / localhost | phpMyAdmin 4.5.1"))) {
			throw new IllegalStateException("Invalid page opened");
		}
	}

	// open database
	public void selectDatabase() {
		driver.findElement(dataBaseLocator).click();
	}

	// open table
	public void selectTable() {
		driver.findElement(tableSelector).click();
	}

	// open structure
	public void selectStructure() {
		driver.findElement(structureSelector).click();
	}

	// open columns
	public void selectColumns() {
		driver.findElement(columnSelector).click();
	}

	public boolean checkElement(String selector, String type) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		return element.getText().equals(type);
	}
}
