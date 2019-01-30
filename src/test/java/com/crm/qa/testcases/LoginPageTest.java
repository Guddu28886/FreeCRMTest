package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.CRMBase;

public class LoginPageTest extends CRMBase{
	
	@BeforeMethod
	public void setUp()
	{
		CRMBase b=CRMBase.getInstance();
		b.initialization();
	}
	@Test
	public void login()
	{
		driver.get(prop.getProperty("url"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
