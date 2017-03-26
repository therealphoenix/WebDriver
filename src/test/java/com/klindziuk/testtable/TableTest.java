package com.klindziuk.testtable;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
	LoginPage loginPage;
	TablePage tablePage;
	
	String idNameSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(3) > label:nth-child(1)";
	String idTypeSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > bdo:nth-child(1)";
	String idNotNullSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7)";
	String idAutoIncrementSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9)";
	
	String loginNameSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > label:nth-child(1)";
	String loginTypeSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(4) > bdo:nth-child(1)";
	String loginNotNullSelector ="#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(7)" ;
	
	String passwordNameSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > th:nth-child(3) > label:nth-child(1)";
	String passwordTypeSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(4) > bdo:nth-child(1)";
	String passwordNotNullSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(7)" ;
	
	String emailNameSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > th:nth-child(3) > label:nth-child(1)" ;
	String emailTypeSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(4) > bdo:nth-child(1)";
	String emailNotNullSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)" ;
	
	String nameNameSelector = "tr.odd:nth-child(5) > th:nth-child(3) > label:nth-child(1)";
	String nameTypeSelector = "tr.odd:nth-child(5) > td:nth-child(4) > bdo:nth-child(1)";
	String nameNotNullSelector = "#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)" ;
	
	String rememberNameSelector = "tr.even:nth-child(6) > th:nth-child(3) > label:nth-child(1)";
	String rememberTypeSelector = "tr.even:nth-child(6) > td:nth-child(4) > bdo:nth-child(1)";
	String rememberNotNullSelector = "tr.even:nth-child(6) > td:nth-child(7)" ;
	
	String collationSelector = "#tablerowstats > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > dfn:nth-child(1)";
	String autoIncrementSelector = "#tablerowstats > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)";

	@BeforeClass
	public void beforeTest() throws Exception {
			driver = new FirefoxDriver(firefoxBinary, profile);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseURL);
			loginPage  = new LoginPage(driver);
			loginPage.loginAs("root", "root");
			tablePage = new TablePage(driver);
			tablePage.selectDatabase();
			tablePage.selectTable();
			tablePage.selectStructure();
			tablePage.selectColumns();
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
	public void testTableCreation() {
		
		Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check id field+
		Assert.assertTrue(tablePage.checkElement(idNameSelector, "u_id"));
		Assert.assertTrue(tablePage.checkElement(idTypeSelector, "int(11)"));
		Assert.assertTrue(tablePage.checkElement(idNotNullSelector, "No"));
		Assert.assertTrue(tablePage.checkElement(idAutoIncrementSelector, "AUTO_INCREMENT"));
		// check login+
		Assert.assertTrue(tablePage.checkElement(loginNameSelector, "u_login"));
		Assert.assertTrue(tablePage.checkElement(loginTypeSelector, "varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(loginNotNullSelector, "No"));
		// check password+
		Assert.assertTrue(tablePage.checkElement(passwordNameSelector,	"u_password"));
		Assert.assertTrue(tablePage.checkElement(passwordTypeSelector, "char(40)"));
		Assert.assertTrue(tablePage.checkElement(passwordNotNullSelector, "No"));
		// check email+
		Assert.assertTrue(tablePage.checkElement(emailNameSelector, "u_email"));
		Assert.assertTrue(tablePage.checkElement(emailTypeSelector,	"varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(emailNotNullSelector, "No"));
		// check name+
		Assert.assertTrue(tablePage.checkElement(nameNameSelector, "u_name"));
		Assert.assertTrue(tablePage.checkElement(nameTypeSelector, "varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(nameNotNullSelector, "No"));
		// check remember+
		Assert.assertTrue(tablePage.checkElement(rememberNameSelector, "u_remember"));
		Assert.assertTrue(tablePage.checkElement(rememberTypeSelector, "char(40)"));
		Assert.assertTrue(tablePage.checkElement(rememberNotNullSelector, "No"));
		// check collation+
		Assert.assertTrue(tablePage.checkElement(collationSelector,"utf8_general_ci"));
		// check AutoIncrement+
		Assert.assertTrue(tablePage.checkElement(autoIncrementSelector, "3"));
		driver.close();
	}
}
