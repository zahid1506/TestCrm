package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.utill.Webdriverlistener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	static WebDriverEventListener wel;
	static EventFiringWebDriver e_driver;
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
	public static void initialization(){
	String browser=prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","./src/main/java/com/crm/qa/testdata/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.firefox.marionette","./src/main/java/com/crm/qa/testdata/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	e_driver=new EventFiringWebDriver(driver);
	wel=new Webdriverlistener();
	e_driver.register(wel);
	driver=e_driver;
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
}
