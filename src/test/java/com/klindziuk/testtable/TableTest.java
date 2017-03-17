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
		//driver.close();
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
	    
	    Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
	    //check id field+
	    Assert.assertTrue(tableObject.checkName("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(3) > label:nth-child(1)","u_id"));
	    Assert.assertTrue(tableObject.checkType("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > bdo:nth-child(1)","int(11)"));
	    Assert.assertTrue(tableObject.checkNotNull("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7)","No"));
	    Assert.assertTrue(tableObject.checkExtra("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9)","AUTO_INCREMENT"));
	    
	    //check login+
	    Assert.assertTrue(tableObject.checkName("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > label:nth-child(1)","u_login"));
	    Assert.assertTrue(tableObject.checkType("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(4) > bdo:nth-child(1)","varchar(255)"));
	    Assert.assertTrue(tableObject.checkNotNull("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(7)","No"));
	    
	  //check password+
	    Assert.assertTrue(tableObject.checkName("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > th:nth-child(3) > label:nth-child(1)","u_password"));
	    Assert.assertTrue(tableObject.checkType("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(4) > bdo:nth-child(1)","char(40)"));
	    Assert.assertTrue(tableObject.checkNotNull("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(7)","No"));
	    
	  //check email+
	    Assert.assertTrue(tableObject.checkName("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > th:nth-child(3) > label:nth-child(1)","u_email"));
	    Assert.assertTrue(tableObject.checkType("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(4) > bdo:nth-child(1)","varchar(255)"));
	    Assert.assertTrue(tableObject.checkNotNull("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)","No"));
	    
	  //check name+
	    Assert.assertTrue(tableObject.checkName("tr.odd:nth-child(5) > th:nth-child(3) > label:nth-child(1)","u_name"));
	    Assert.assertTrue(tableObject.checkType("tr.odd:nth-child(5) > td:nth-child(4) > bdo:nth-child(1)","varchar(255)"));
	    Assert.assertTrue(tableObject.checkNotNull("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)","No"));
	    
	  //check remember+
	    Assert.assertTrue(tableObject.checkName("tr.even:nth-child(6) > th:nth-child(3) > label:nth-child(1)","u_remember"));
	    Assert.assertTrue(tableObject.checkType("tr.even:nth-child(6) > td:nth-child(4) > bdo:nth-child(1)","char(40)"));
	    Assert.assertTrue(tableObject.checkNotNull("tr.even:nth-child(6) > td:nth-child(7)","No"));
	    
	  //check collation
	    Assert.assertTrue(tableObject.checkCollation("#tablerowstats > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > dfn:nth-child(1)", "utf8_general_ci"));
	  
	  //check AutoIncrement
	   Assert.assertTrue(tableObject.checkAutoIncrement("#tablerowstats > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)", "1")); 
	}
}
