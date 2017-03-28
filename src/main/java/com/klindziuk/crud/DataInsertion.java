package com.klindziuk.crud;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataInsertion {
	WebDriver driver;

	public DataInsertion(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void openInsertMenu(){
		driver.findElement(By.cssSelector("#topmenu > li:nth-child(5) > a:nth-child(1)")).click();
		}
	
	public void fillData(){
	
		driver.findElement(By.cssSelector("#field_1_3")).sendKeys("1");
		driver.findElement(By.cssSelector("#field_2_3")).sendKeys("user1");
		driver.findElement(By.cssSelector("#field_3_3")).sendKeys("e38ad214943daad1d64c102faec29de4afe9da3d");
		driver.findElement(By.cssSelector("#field_4_3")).sendKeys("user1@mail.com");
		driver.findElement(By.cssSelector("#field_5_3")).sendKeys("Pupkin");
		
		driver.findElement(By.cssSelector("#field_7_3")).sendKeys("2");
		driver.findElement(By.cssSelector("#field_8_3")).sendKeys("user2");
		driver.findElement(By.cssSelector("#field_9_3")).sendKeys("2aa60a8ff7fcd473d321e0146afd9e26df395147");
		driver.findElement(By.cssSelector("#field_10_3")).sendKeys("user2@mail.com");
		driver.findElement(By.cssSelector("#field_11_3")).sendKeys("Smith");
	}
	
	public void pushButton(){
		driver.findElement(By.cssSelector("#buttonYes")).click();
	}

	public void moveToBrowse() {
		driver.findElement(By.cssSelector("#topmenu > li:nth-child(1) > a:nth-child(1)")).click();;
	}
}
