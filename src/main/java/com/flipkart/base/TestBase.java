package com.flipkart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	protected static WebDriver driver;
	//public WebDriverWait wait;
	FileInputStream fis;
	Properties prop;
	
	public void launchBrowser() {
		
		try {
			fis = new FileInputStream(".\\src\\main\\resources\\Config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}
	
	public void captureScreenshot(String pageName) {
		System.out.println("This is the Screenshot for: " + pageName);
		
		Date date = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); //yyyy-MM-dd
		String dateTime = sdf.format(date);
		String fileName = "screenshot_" + dateTime;
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);		
		File destFile = new File(".\\src\\test\\resources\\Screenshots\\" + fileName + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
