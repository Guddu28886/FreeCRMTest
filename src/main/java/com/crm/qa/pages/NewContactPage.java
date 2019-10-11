package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.CRMBase;
import com.crm.qa.utils.CRMUtil;

public class NewContactPage extends CRMBase{
	
	CRMUtil util=new CRMUtil();
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//td[input[@value='Load From Company']]/input[@value='Save']")
	WebElement saveBtn;
	
	public NewContactPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addContacts(String firstName,String lastName)
	{
		util.switchToFrame();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		saveBtn.click();
	}

}
