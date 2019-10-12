package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HomePageCalenderMoveTest extends CRMBase{
  
  public static LoginPage loginPage;
  public static HomePage homePage;
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  CRMBase b=new CRMBase();
	  b.init();
	  loginPage=new LoginPage();
	  homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
  }
  @Test
  public void calenderMovetest() 
  {
	  homePage.moveCalender();
  }
  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
