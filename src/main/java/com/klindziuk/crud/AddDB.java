package com.klindziuk.crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDB {
	private WebDriver driver;
	private By newDBLocator = By.linkText("New");
	private By dbNameLocator = By.id("text_create_db");
	private By buttonGoLocator = By.id("buttonGo");
	
	public AddDB(WebDriver driver) {
		this.driver = driver;
	}

	public void createDB() {
		driver.findElement(newDBLocator).click();
		driver.findElement(dbNameLocator).clear();
		driver.findElement(dbNameLocator).sendKeys("auth");
		// sometimes it doensn't work
		// driver.findElement(By.xpath("//select[@name = 'db_collation']//*[text() = 'utf8_general_ci']")).click();
		driver.findElement(buttonGoLocator).click();
	}

	public boolean checkDataBase(By selector, String type) {
		WebElement element = driver.findElement(selector);
		return element.getText().equals(type);
	}
}