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
 
 protected void loginAs(String userName, String password) {
     setUserName(userName);
     setPassword(password);
     pushButton();
}
 
 protected void selectTableCollation(){
		 driver.findElement(By.xpath("//select[@name = 'tbl_collation']//*[text() = 'utf8_general_ci']")).click();
  }
 

}