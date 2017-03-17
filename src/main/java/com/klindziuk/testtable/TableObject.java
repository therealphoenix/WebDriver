package com.klindziuk.testtable;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.klindziuk.createdbandtable.LoginPage;

public class TableObject {
	WebDriver driver;
	

public TableObject(WebDriver driver) {
		
		this.driver = driver;
		this.driver = driver;
		// Провекрка того факта, что мы на верной странице.
		if ((!driver.getTitle().equals("phpMyAdmin")) ||
		(!driver.getCurrentUrl().equals("http://localhost/phpmyadmin/")))
		{
		throw new IllegalStateException("Invalid page opened");
		}
	}


protected void pushButton(){
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
}

protected void setUserName(String userName)
{
	 driver.findElement(By.name("pma_username")).clear();
	 driver.findElement(By.name("pma_username")).sendKeys(userName);
	 
}
protected void setPassword(String password) {
	 driver.findElement(By.name("pma_password")).clear();
	 driver.findElement(By.name("pma_password")).sendKeys(password);
	 
}

public void loginAs(String userName, String password) {
    setUserName(userName);
    setPassword(password);
    pushButton();
}
public boolean checkName(String selector, String name){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals(name);
}
public boolean checkType(String selector,String type){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals(type);
	}
public boolean checkNotNull(String selector,String info){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals("No");
	
}
public boolean checkExtra(String selector,String extra){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals(extra);
}
public boolean checkCollation(String selector, String description){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals(description);
}
public boolean checkAutoIncrement(String selector, String value){
	WebElement element = driver.findElement(By.cssSelector(selector));
	return element.getText().equals(value);
}
}
