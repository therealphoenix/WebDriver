package com.klindziuk.crud;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;



public class ScreenShot {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String base_url = "https://vk.com/klindziuk";
		File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		StringBuffer verificationErrors = new StringBuffer();
		File path_to_profile = new File("d:/FireFox/");
		FirefoxProfile profile = new FirefoxProfile(path_to_profile);
		WebDriver driver = new FirefoxDriver(firefoxBinary, profile);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(base_url);
		driver.findElement(By.cssSelector("#quick_email")).sendKeys("9-phoenix@tut.by");
		driver.findElement(By.cssSelector("#quick_pass")).sendKeys("nexusp29");
		driver.findElement(By.cssSelector("#quick_login_button")).click();
		driver.findElement(By.cssSelector("#l_msg > a > span > span.left_label.inl_bl")).click();
		Thread.sleep(2000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("D:\\tmp\\vkScreen.png"));
		driver.close();
		
	}

}
