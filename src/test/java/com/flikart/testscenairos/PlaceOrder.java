package com.flikart.testscenairos;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchProductPage;

public class PlaceOrder extends TestBase {
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	
  @BeforeClass
  public void setupDriver() {
	  launchBrowser();
	  navigateToURL();
  }

  @AfterClass
  public void tearDown() {
  }

  
  @Test(priority = 0)
  public void validateLoginTest() { 
	  loginPage = new LoginPage();
	  boolean loginResult = loginPage.login("mitu.pati24@gmail.com", "Nkpati@1997");
	  Assert.assertTrue(loginResult);
  }
  
  @Test(priority = 1)
  public void validateSeachProductTest() {
	  SearchProductPage searchPage = new SearchProductPage();
	  searchPage.searchProduct("laptop");
	  
  }
  
  @Test(priority = 2)
  public void validateSelectProductTest() {
	  
  }
  
  @Test(priority = 3)
  public void validateAddToCartTest() {
	  
  }
  
  @Test(priority = 4)
  public void validatePlaceOrderTest() {
	  
  }
  
  @Test(priority = 5)
  public void validateMakePayment() {
	  
  }
  
  @Test(priority = 6)
  public void validateLogoutTest() {
	  
  }
  
  
}
