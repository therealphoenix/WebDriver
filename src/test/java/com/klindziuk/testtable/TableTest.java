package com.klindziuk.testtable;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableTest {
	String baseURL = "http://localhost/phpmyadmin/";
	File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
	StringBuffer verificationErrors = new StringBuffer();
	File path_to_profile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(path_to_profile);
	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new FirefoxDriver(firefoxBinary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
	//	driver.close();
		driver = null;
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	@Test
	public void testTable() {
		driver.get(baseURL);
		// С этого момента можно использовать PajeObject.
		TableObject tableObject = new TableObject(driver);
		tableObject.loginAs("root", "root");
		Assert.assertTrue("localhost / localhost | phpMyAdmin 4.5.1".equals(driver.getTitle()) );
		//open database
		driver.findElement(By.cssSelector("li.database:nth-child(2) > a:nth-child(3)")).click();
		//open table
		driver.findElement(By.cssSelector("#row_tbl_1 > th:nth-child(2) > a:nth-child(1)")).click();
		//open structure
		driver.findElement(By.cssSelector("img.icon:nth-child(6)")).click();
		//open columns
	    driver.findElement(By.cssSelector(".table > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > i:nth-child(2) > a:nth-child(2)")).click();
	}
}
