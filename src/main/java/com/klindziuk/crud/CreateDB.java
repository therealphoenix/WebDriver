package com.klindziuk.crud;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class CreateDB {
	String baseURL = "http://localhost/phpmyadmin/";
	File pathBinary = new File("C:\\program files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
	StringBuffer verificationErrors = new StringBuffer();
	File pathToProfile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(pathToProfile);
	WebDriver driver;
	
		public void create() {
		driver = new FirefoxDriver(firefoxBinary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("root", "root");
		AddDB dbPage = new AddDB(driver);
		dbPage.createDB();
		AddColumns tablePage = new AddColumns(driver);
		tablePage.addTable();
		tablePage.addColumns("2");
		tablePage.waitForAddColumns();
		tablePage.addNamesOfColumn();
		tablePage.selectTypes();
		tablePage.setLengthOfValues();
		tablePage.setPrimaryKey();
		tablePage.setAutoIncrement();
		tablePage.selectTableCollation();
		tablePage.submitCreatingTable();
		tablePage.waitForAddColumns();
		DataInsertion dataInsertion = new DataInsertion(driver);
		dataInsertion.openInsertMenu();
		dataInsertion.fillData();
		dataInsertion.pushButton();
		dataInsertion.moveToBrowse();
		driver.close();
		
	}

}
