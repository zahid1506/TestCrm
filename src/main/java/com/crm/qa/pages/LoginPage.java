package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass{
  @FindBy(xpath="//img[@class='img-responsive']")
  WebElement crmlogo;
  
  @FindBy( name="username")
  WebElement nameinput;
  
  @FindBy(name="password")
  WebElement passinput;
  
  public boolean verifylogo(){
	  return crmlogo.isDisplayed();
  }
}
