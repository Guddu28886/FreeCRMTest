package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
public class NewContactPageTest extends CRMBase{
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static NewContactPage newContactPage;
	@BeforeMethod
	public void setUp()
	{
		CRMBase b=new CRMBase();
		b.init();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage=new HomePage();
	}
	@Test
	public void newContactAddTest()
	{
		newContactPage=homePage.clickNewContacts();
		newContactPage.addContacts("Myra", "Sahoo");
	}
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}

}
