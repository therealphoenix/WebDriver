package com.klindziuk.testtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By loginButtonLocator = By.xpath("//input[@type='submit']");
	By loginUserName = By.name("pma_username");
	By loginPassword = By.name("pma_password");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver = driver;
		// Checking for right page is opened
		if ((!driver.getTitle().equals("phpMyAdmin"))
				|| (!driver.getCurrentUrl().equals("http://localhost/phpmyadmin/"))) {
			throw new IllegalStateException("Invalid page opened");
		}
	}

	protected void pushLoginButton() {
		driver.findElement(loginButtonLocator).click();
	}

	protected void setUserName(String userName) {
		driver.findElement(loginUserName).clear();
		driver.findElement(loginUserName).sendKeys(userName);
	}

	protected void setPassword(String password) {
		driver.findElement(loginPassword).clear();
		driver.findElement(loginPassword).sendKeys(password);
	}

	public void loginAs(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		pushLoginButton();
	}
}