package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends CRMBase{
  
  HomePage homePage;
  LoginPage loginPage;
  @BeforeMethod
  public void setUp() 
  {
	  CRMBase b=CRMBase.getInstance();
	  b.init();
	  loginPage=new LoginPage();
	  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	  homePage=new HomePage();
  }
  @Test(dependsOnMethods= {"com.crm.qa.testcases.LoginPageTest.crmTitleTest"})
   public void homePageTitleTest() 
  {
	   Assert.assertEquals(homePage.validateHomePageTitle(), "CRMPRO");
  }
  @Test
  public void homePageLogoTest()
  {
	  Assert.assertEquals(homePage.validateHomePageLogo(),"CRMPRO");
	 
  }
  @AfterMethod
  public void tearDown() 
  {
	  driver.close();
	  
  }

}
