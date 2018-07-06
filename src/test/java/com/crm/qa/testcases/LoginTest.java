package com.crm.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage lp;
	public LoginTest() {
		super();
		
	}

	@BeforeMethod
	public void init(){
		initialization();
	     lp=PageFactory.initElements(driver,LoginPage.class);
		}
	@Test
	public void logotest(){
		Assert.assertEquals(true,lp.verifylogo());
	}
	@AfterMethod
	public void breakdown(){
		driver.quit();
	}
	
	

	}
