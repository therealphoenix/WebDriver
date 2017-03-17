package com.klindziuk.createdbandtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateDBPage {
	WebDriver driver;

	public CreateDBPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void createTable() {
		
		    driver.findElement(By.linkText("New")).click();
		    driver.findElement(By.id("text_create_db")).clear();
		    driver.findElement(By.id("text_create_db")).sendKeys("auth");
		    driver.findElement(By.xpath("//select[@name = 'db_collation']//*[text() = 'utf8_general_ci']")).click();
	}
	
	
	
}

