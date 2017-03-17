package com.klindziuk.createdbandtable;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Runnert {

	public static void main(String[] args) {
		String base_url = "http://localhost/phpmyadmin/";
		File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		StringBuffer verificationErrors = new StringBuffer();
		File path_to_profile = new File("d:/FireFox/");
		FirefoxProfile profile = new FirefoxProfile(path_to_profile);
		WebDriver driver = new FirefoxDriver(firefoxBinary, profile);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(base_url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("root", "root");
		CreateDBPage dbPage = new CreateDBPage(driver);
		dbPage.createTable();
		CreateTablePage tablePage = new CreateTablePage(driver);
		tablePage.addTable();
		tablePage.addColumns("2");
		tablePage.waitForAddColumns();
		tablePage.addNamesOfColumn();
		tablePage.setLengthOfValues();
		tablePage.setPrimaryKey();
		tablePage.setAutoIncrement();
		tablePage.submitCreatingTable();

	}

}
