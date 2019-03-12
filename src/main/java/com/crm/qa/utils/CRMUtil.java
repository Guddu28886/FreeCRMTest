package com.crm.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.CRMBase;

public class CRMUtil extends CRMBase{
	
	public void switchToFrame()
	{
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
	}

}
