package com.klindziuk.createdbandtable;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	String baseUrl = "http://localhost/phpmyadmin/";
	WebDriver driver;

 public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
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
 
 
 

}