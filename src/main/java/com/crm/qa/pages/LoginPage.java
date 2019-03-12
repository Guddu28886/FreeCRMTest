package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;

public class LoginPage extends CRMBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@class='img-responsive' and contains(@src,'logo@2x.png')]")
	WebElement crmLogo;
	//Initializing Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions 
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public void login(String un,String pw)
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pw);
		loginbtn.click();
	}
}
