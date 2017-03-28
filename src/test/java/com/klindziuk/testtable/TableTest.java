package com.klindziuk.testtable;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.klindziuk.crud.DropDB;
import com.klindziuk.crud.CreateDB;

public class TableTest {
	String baseURL = "http://localhost/phpmyadmin/";
	File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
	StringBuffer verificationErrors = new StringBuffer();
	File pathToProfile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(pathToProfile);
	WebDriver driver;
	LoginPage loginPage;
	TablePage tablePage;
	
	@BeforeSuite
	public void suitSetup() {
		CreateDB run = new CreateDB();
		run.create();
	}
	@AfterSuite
	public void suitSetDown() {
		DropDB drop = new DropDB();
		drop.removeDB();
		drop.logOut();
		
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		driver = new FirefoxDriver(firefoxBinary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		loginPage = new LoginPage(driver);
		loginPage.loginAs("root", "root");
		tablePage = new TablePage(driver);
		tablePage.selectDatabase();
		tablePage.selectTable();
		tablePage.selectStructure();
		tablePage.selectColumns();
	}

	@AfterClass
	public void afterTest() {
		tablePage.logOut();
		driver.close();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	@Test
	public void testTable() {
		Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check id field+
		Assert.assertTrue(tablePage.checkElement(tablePage.idNameSelector, "u_id"));
		Assert.assertTrue(tablePage.checkElement(tablePage.idTypeSelector, "int(11)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.idNotNullSelector, "No"));
		Assert.assertTrue(tablePage.checkElement(tablePage.idAutoIncrementSelector, "AUTO_INCREMENT"));
		// check login+
		Assert.assertTrue(tablePage.checkElement(tablePage.loginNameSelector, "u_login"));
		Assert.assertTrue(tablePage.checkElement(tablePage.loginTypeSelector, "varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.loginNotNullSelector, "No"));
		// check password+
		Assert.assertTrue(tablePage.checkElement(tablePage.passwordNameSelector, "u_password"));
		Assert.assertTrue(tablePage.checkElement(tablePage.passwordTypeSelector, "char(40)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.passwordNotNullSelector, "No"));
		// check email+
		Assert.assertTrue(tablePage.checkElement(tablePage.emailNameSelector, "u_email"));
		Assert.assertTrue(tablePage.checkElement(tablePage.emailTypeSelector, "varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.emailNotNullSelector, "No"));
		// check name+
		Assert.assertTrue(tablePage.checkElement(tablePage.nameNameSelector, "u_name"));
		Assert.assertTrue(tablePage.checkElement(tablePage.nameTypeSelector, "varchar(255)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.nameNotNullSelector, "No"));
		// check remember+
		Assert.assertTrue(tablePage.checkElement(tablePage.rememberNameSelector, "u_remember"));
		Assert.assertTrue(tablePage.checkElement(tablePage.rememberTypeSelector, "char(40)"));
		Assert.assertTrue(tablePage.checkElement(tablePage.rememberNotNullSelector, "No"));
		// check collation+
		Assert.assertTrue(tablePage.checkElement(tablePage.collationSelector, "utf8_general_ci"));
		// check AutoIncrement+
		Assert.assertTrue(tablePage.checkElement(tablePage.autoIncrementSelector, "3"));
		
	}
}