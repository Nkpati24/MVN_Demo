package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.flipkart.base.TestBase;

public class SearchProductPage extends TestBase {
	
By searchLoc = By.className("_3704LK");
	
	
	public void searchProduct(String productName) {
		
		driver.findElement(searchLoc).sendKeys(productName);
		sleep(2000);
		driver.findElement(searchLoc).sendKeys(Keys.ENTER);
		}


}
