package com.klindziuk.testtable;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DataTableTest {
 
  String baseURL = "http://localhost/phpmyadmin/";
	File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
	StringBuffer verificationErrors = new StringBuffer();
	File path_to_profile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(path_to_profile);
	WebDriver driver = null;
	TableObject tableObject;

	@BeforeClass
	public void beforeTest() throws Exception {
		driver = new FirefoxDriver(firefoxBinary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		tableObject = new TableObject(driver);
		tableObject.loginAs("root", "root");
		// open database
		driver.findElement(By.cssSelector("li.database:nth-child(2) > a:nth-child(3)")).click();
		// open table
		driver.findElement(By.cssSelector("#row_tbl_1 > th:nth-child(2) > a:nth-child(1)")).click();
	}

	@AfterClass
	public void afterTest() {
		driver.close();
		driver = null;
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
		@Test
		public void testData_User1() {
			//check u_id
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(5) > span:nth-child(1)", "1"));
			//check u_login
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(6) > span:nth-child(1)", "user1"));
			//check u_password
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(7) > span:nth-child(1)", "e38ad214943daad1d64c102faec29de4afe9da3d"));
			//check u_email
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(8) > span:nth-child(1)", "user1@mail.com"));
			//check u_name
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(9) > span:nth-child(1)", "Pupkin"));
			//check u_remember
			Assert.assertTrue(tableObject.checkType(".odd > td:nth-child(10)", ""));
			driver.close();
		}
		
		@Test
		public void testData_User2() {
			//check u_id
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(5) > span:nth-child(1)", "2"));
			//check u_login
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(6) > span:nth-child(1)", "user2"));
			//check u_password
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(7) > span:nth-child(1)", "2aa60a8ff7fcd473d321e0146afd9e26df395147"));
			//check u_email
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(8) > span:nth-child(1)", "user2@mail.com"));
			//check u_name
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(9) > span:nth-child(1)", "Smith"));
			//check u_remember
			Assert.assertTrue(tableObject.checkType(".even > td:nth-child(10)", ""));
			driver.close();
		}

}

