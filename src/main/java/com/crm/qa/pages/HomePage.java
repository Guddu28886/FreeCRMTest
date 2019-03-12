package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.CRMBase;

public class HomePage extends CRMBase{
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement homePageText;
	
	@FindBy(xpath="//div[@id='handle_CALENDAR' and contains(text(),'Calendar')]")
	WebElement calender;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	
	Actions action=new Actions(driver);
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateHomePageLogo()
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
		return homePageText.getText();
	}
	
	public void moveCalender()
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
		action.dragAndDropBy(calender, 200, 200).perform();
	}
	
	public ContactsPage clickContacts()
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
		contactsLink.click();
		return new ContactsPage();
	}
	
	public NewContactPage clickNewContacts()
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
		action.moveToElement(contactsLink).perform();
		newContactLink.click();
		return new NewContactPage();
	}
}
