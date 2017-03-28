package com.klindziuk.testtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePage {
private WebDriver driver;
private By dataBaseLocator = By.cssSelector("li.database:nth-child(2) > a:nth-child(3)");
private By tableSelector = By.cssSelector("#row_tbl_1 > th:nth-child(2) > a:nth-child(1)");
private By structureSelector = By.cssSelector("img.icon:nth-child(6)");
private By columnSelector = By.cssSelector(".table > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > i:nth-child(2) > a:nth-child(2)");
public By user1IdSelector = By.cssSelector(".odd > td:nth-child(5) > span:nth-child(1)");
public By user1LoginSelector = By.cssSelector(".odd > td:nth-child(6) > span:nth-child(1)");
public By user1PasswordSelector = By.cssSelector(".odd > td:nth-child(7) > span:nth-child(1)");
public By user1EmailSelector = By.cssSelector(".odd > td:nth-child(8) > span:nth-child(1)");
public By user1NameSelector = By.cssSelector(".odd > td:nth-child(9) > span:nth-child(1)");
public By user1RememberSelector = By.cssSelector(".odd > td:nth-child(10)");
public By user2IdSelector = By.cssSelector(".even > td:nth-child(5) > span:nth-child(1)");
public By user2LoginSelector = By.cssSelector(".even > td:nth-child(6) > span:nth-child(1)");
public By user2PasswordSelector = By.cssSelector(".even > td:nth-child(7) > span:nth-child(1)");
public By user2EmailSelector = By.cssSelector(".even > td:nth-child(8) > span:nth-child(1)");
public By user2NameSelector = By.cssSelector(".even > td:nth-child(9) > span:nth-child(1)");
public By user2RememberSelector = By.cssSelector(".even > td:nth-child(10)");
public By idNameSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(3) > label:nth-child(1)");
public By idTypeSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > bdo:nth-child(1)");
public By idNotNullSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7)");
public By idAutoIncrementSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9)");
public By loginNameSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > label:nth-child(1)");
public By loginTypeSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(4) > bdo:nth-child(1)");
public By loginNotNullSelector =By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(7)");
public By passwordNameSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > th:nth-child(3) > label:nth-child(1)");
public By passwordTypeSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(4) > bdo:nth-child(1)");
public By passwordNotNullSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(7)");
public By emailNameSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > th:nth-child(3) > label:nth-child(1)");
public By emailTypeSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(4) > bdo:nth-child(1)");
public By emailNotNullSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)");
public By nameNameSelector = By.cssSelector("tr.odd:nth-child(5) > th:nth-child(3) > label:nth-child(1)");
public By nameTypeSelector = By.cssSelector("tr.odd:nth-child(5) > td:nth-child(4) > bdo:nth-child(1)");
public By nameNotNullSelector = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)");
public By rememberNameSelector = By.cssSelector("tr.even:nth-child(6) > th:nth-child(3) > label:nth-child(1)");
public By rememberTypeSelector = By.cssSelector("tr.even:nth-child(6) > td:nth-child(4) > bdo:nth-child(1)");
public By rememberNotNullSelector = By.cssSelector("tr.even:nth-child(6) > td:nth-child(7)");
public By collationSelector = By.cssSelector("#tablerowstats > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > dfn:nth-child(1)");
public By autoIncrementSelector = By.cssSelector("#tablerowstats > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)");

	public TablePage(WebDriver driver) {
		this.driver = driver;
		this.driver = driver;
		// Checking for right page is opened 
	//	if ((!driver.getTitle().equals("localhost / localhost | phpMyAdmin 4.5.1"))) {
	//		throw new IllegalStateException("Invalid page opened");
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

	public boolean checkElement(By selector, String type) {
		WebElement element = driver.findElement(selector);
		return element.getText().equals(type);
	}
	
	public void logOut(){
		driver.findElement(By.cssSelector(".ic_s_loggoff")).click();
		driver.close();
	}
}
