package com.crm.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.crm.qa.base.CRMBase;

public class RetryAnalyzer extends CRMBase implements IRetryAnalyzer{
	int counter=0, retry=3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retry)
		{
			counter++;
			return true;
		}
		return false;
	}

}
