package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.CRMBase;

public class LoginPage extends CRMBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@class='img-responsive' and contains(@src,'logo.png')]")
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
	
	public HomePage login(String un,String pw)
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pw);
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		//wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible)
			loginbtn.click();
		else
			return null;
		return new HomePage();
	}
}
