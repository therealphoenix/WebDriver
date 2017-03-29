package com.klindziuk.crud;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import com.klindziuk.testtable.LoginPage;

public class DropDB {
	String baseURL = "http://localhost/phpmyadmin/";
	File pathBinary = new File("C:\\Program files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
	File pathToProfile = new File("d:/FireFox/");
	FirefoxProfile profile = new FirefoxProfile(pathToProfile);
	WebDriver driver = null;
	By newDBLocator = By.cssSelector("li.first > a:nth-child(3)");
	By dbForRemoveLocator = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
	By submitButtonLocator = By.cssSelector(".mult_submit");
	By popUpMenuButtonLocator = By.cssSelector(".submitOK");

	public void removeDB() {
		driver = new FirefoxDriver(firefoxBinary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAs("root", "root");
		driver.findElement(newDBLocator).click();
		driver.findElement(dbForRemoveLocator).click();
		driver.findElement(submitButtonLocator).click();
		driver.findElement(popUpMenuButtonLocator).click();
	}

	public void logOut() {
		driver.findElement(By.cssSelector(".ic_s_loggoff")).click();
		driver.close();
	}

	public static void main(String[] args) {
		DropDB d = new DropDB();
		d.removeDB();
	}
}