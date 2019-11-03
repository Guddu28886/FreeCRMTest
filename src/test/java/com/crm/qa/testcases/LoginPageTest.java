package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends CRMBase{
	
	LoginPage loginPage;
	@BeforeMethod
	public void setUp()
	{
		CRMBase b=CRMBase.getInstance();
		//b.init();
		loginPage=new LoginPage();
	}
	@Test
	public void crmTitleTest()
	{
		//loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(dependsOnMethods="crmTitleTest")
	public void logoTest()
	{
		Assert.assertTrue(loginPage.validateLogo());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
