package com.klindziuk.testtable;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.util.concurrent.TimeUnit;
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
	File pathToProfile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(pathToProfile);
	WebDriver driver = null;
	LoginPage loginPage;
	TablePage tablePage;
	
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
	public void testData_User1() {
		// check for right page is opened(sometimes it PRESENT sometimes NOT. WTF ???)
	//	Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check u_id
		Assert.assertTrue(tablePage.checkElement(tablePage.user1IdSelector, "1"));
		// check u_login
		Assert.assertTrue(tablePage.checkElement(tablePage.user1LoginSelector, "user1"));
		// check u_password
		Assert.assertTrue(tablePage.checkElement(tablePage.user1PasswordSelector, "e38ad214943daad1d64c102faec29de4afe9da3d"));
		// check u_email
		Assert.assertTrue(tablePage.checkElement(tablePage.user1EmailSelector, "user1@mail.com"));
		// check u_name
		Assert.assertTrue(tablePage.checkElement(tablePage.user1NameSelector, "Pupkin"));
		// check u_remember
		Assert.assertTrue(tablePage.checkElement(tablePage.user1RememberSelector, ""));
		
	}

	@Test
	public void testData_User2() {
		// check for right page is opened(sometimes it PRESENT sometimes NOT. WTF ???)
	//	Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check u_id
		Assert.assertTrue(tablePage.checkElement(tablePage.user2IdSelector, "2"));
		// check u_login
		Assert.assertTrue(tablePage.checkElement(tablePage.user2LoginSelector, "user2"));
		// check u_password
		Assert.assertTrue(tablePage.checkElement(tablePage.user2PasswordSelector, "2aa60a8ff7fcd473d321e0146afd9e26df395147"));
		// check u_email
		Assert.assertTrue(tablePage.checkElement(tablePage.user2EmailSelector, "user2@mail.com"));
		// check u_name
		Assert.assertTrue(tablePage.checkElement(tablePage.user2NameSelector, "Smith"));
		// check u_remember
		Assert.assertTrue(tablePage.checkElement(tablePage.user2RememberSelector, ""));
		
	}
}
