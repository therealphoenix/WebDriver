package com.klindziuk.createdbandtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTablePage {
	WebDriver driver;

	public CreateTablePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	protected void addTable() {
		driver.findElement(By.id("buttonGo")).click();
		driver.findElement(By.name("table")).clear();
		driver.findElement(By.name("table")).sendKeys("users");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	protected void addColumns(String columns) {
		driver.findElement(By.name("added_fields")).clear();
		driver.findElement(By.name("added_fields")).sendKeys(columns);
		driver.findElement(By.name("submit_num_fields")).click();
	}

	protected void waitForAddColumns() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void addNamesOfColumn() {
		driver.findElement(By.name("field_name[0]")).sendKeys("u_id");
		driver.findElement(By.name("field_name[1]")).sendKeys("u_login");
		driver.findElement(By.name("field_name[2]")).sendKeys("u_password");
		driver.findElement(By.name("field_name[3]")).sendKeys("u_email");
		driver.findElement(By.name("field_name[4]")).sendKeys("u_name");
		driver.findElement(By.name("field_name[5]")).sendKeys("u_remember");
	}

	protected void selectTypes() {
		driver.findElement(By.xpath("//select[@id = 'field_0_2']//*[text() = 'INT']")).click();
		driver.findElement(By.xpath("//select[@id = 'field_1_2']//*[text() = 'VARCHAR']")).click();
		driver.findElement(By.xpath("//select[@id = 'field_2_2']//*[text() = 'CHAR']")).click();
		driver.findElement(By.xpath("//select[@id = 'field_3_2']//*[text() = 'VARCHAR']")).click();
		driver.findElement(By.xpath("//select[@id = 'field_4_2']//*[text() = 'VARCHAR']")).click();
		driver.findElement(By.xpath("//select[@id = 'field_5_2']//*[text() = 'CHAR']")).click();
	}

	protected void setLengthOfValues() {
		driver.findElement(By.id("field_0_3")).sendKeys("11");
		driver.findElement(By.id("field_1_3")).sendKeys("255");
		driver.findElement(By.id("field_2_3")).sendKeys("40");
		driver.findElement(By.id("field_3_3")).sendKeys("255");
		driver.findElement(By.id("field_4_3")).sendKeys("255");
		driver.findElement(By.id("field_5_3")).sendKeys("40");
	}

	protected void setPrimaryKey() {
		driver.findElement(By.xpath("//select[@id = 'field_0_7']//*[text() = 'PRIMARY']")).click();
		// close pop up window
		driver.findElement(By.cssSelector("button.ui-button:nth-child(1)")).click();
	}
	
	protected void setAutoIncrement() {
		driver.findElement(By.xpath("//input[@name='field_extra[0]']")).click();
	}

	protected void submitCreatingTable(){
		driver.findElement(By.xpath("//input[@name='do_save_data']")).click();
	}
}
