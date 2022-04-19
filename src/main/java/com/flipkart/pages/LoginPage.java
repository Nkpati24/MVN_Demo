package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class LoginPage extends TestBase {

	By emailLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	By passwordLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	By loginButtonLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span");

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public boolean login(String userName, String pwd) {
	
		boolean isLoginSuccess = true;

		sleep(2000);
		driver.findElement(emailLoc).sendKeys(userName);
		sleep(2000);
		driver.findElement(passwordLoc).sendKeys(pwd);
		sleep(2000);
		driver.findElement(loginButtonLoc).click();

		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Nalinikanta']")));
		 
//			isLoginSuccess = driver.findElement(By.xpath("//*[text()='Senthil']")).isDisplayed();
		
			isLoginSuccess = true;
			System.out.println("Is Nalinikanta Present: " + isLoginSuccess);
			captureScreenshot("Login page");
		
		return isLoginSuccess;
	}

}
