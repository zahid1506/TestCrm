package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass(){
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/main/java/com/crm/qa/properties/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	}
	}
	public void initialization(){
	String browser=prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","./src/main/java/com/crm/qa/testdata/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.firefox.marionette","./src/main/java/com/crm/qa/testdata/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	}
}
