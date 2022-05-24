package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;
	private static DriverManager instance;
	
	private DriverManager() {
	}
	
	private void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browser/chromedriver4");
	    driver= new ChromeDriver();
	}
	
	public static synchronized DriverManager getInstance() {
		if(instance ==null) {
			instance = new DriverManager();
		}
		return instance;
	}
	
	public WebDriver getDriver() {
		if(driver==null) {
			createDriver();
		}
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
		driver=null;
		
	}

}
