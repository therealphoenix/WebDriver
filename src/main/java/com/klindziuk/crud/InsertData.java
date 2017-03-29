package com.klindziuk.crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsertData {
	private WebDriver driver;
	private By insertMenuLocator = By.cssSelector("img.ic_b_insrow:nth-child(1)");
	private By browseMenuLocator = By.cssSelector(".ic_b_browse");
	private By logOffButtonLocator = By.cssSelector(".ic_s_loggoff");
	private By buttonYesLocator = By.cssSelector("#buttonYes");
	private By user1IdFormLocator = By.cssSelector("#field_1_3");
	private By user1LoginFormLocator = By.cssSelector("#field_2_3");
	private By user1PasswordFormLocator = By.cssSelector("#field_3_3");
	private By user1EmailFormLocator = By.cssSelector("#field_4_3");
	private By user1NameFormLocator = By.cssSelector("#field_5_3");
	private By user1RememberFormLocator = By.cssSelector("#field_6_3");;
	private By user2IdFormLocator = By.cssSelector("#field_7_3");
	private By user2LoginFormLocator = By.cssSelector("#field_8_3");
	private By user2PasswordFormLocator = By.cssSelector("#field_9_3");
	private By user2EmailFormLocator = By.cssSelector("#field_10_3");
	private By user2NameFormLocator = By.cssSelector("#field_11_3");
	private By user2RememberFormLocator = By.cssSelector("#field_12_3");

	public InsertData(WebDriver driver) {
		this.driver = driver;
	}

	public void openInsertMenu() {
		driver.findElement(insertMenuLocator).click();
	}
	public void waitFor() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonYesLocator));
	}

	public void fillData() {

		driver.findElement(user1IdFormLocator).sendKeys("1");
		driver.findElement(user1LoginFormLocator).sendKeys("user1");
		driver.findElement(user1PasswordFormLocator).sendKeys("e38ad214943daad1d64c102faec29de4afe9da3d");
		driver.findElement(user1EmailFormLocator).sendKeys("user1@mail.com");
		driver.findElement(user1NameFormLocator).sendKeys("Pupkin");
		driver.findElement(user1RememberFormLocator).sendKeys("");
		driver.findElement(user2IdFormLocator).sendKeys("2");
		driver.findElement(user2LoginFormLocator).sendKeys("user2");
		driver.findElement(user2PasswordFormLocator).sendKeys("2aa60a8ff7fcd473d321e0146afd9e26df395147");
		driver.findElement(user2EmailFormLocator).sendKeys("user2@mail.com");
		driver.findElement(user2NameFormLocator).sendKeys("Smith");
		driver.findElement(user2RememberFormLocator).sendKeys("");
	}

	public void pushButton() {
		driver.findElement(buttonYesLocator).click();
	}

	public void moveToBrowse() {
		driver.findElement(browseMenuLocator).click();
	}

	public void logOut() {
		driver.findElement(logOffButtonLocator).click();
		driver.close();
	}
}
