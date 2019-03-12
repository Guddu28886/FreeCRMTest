package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMBase {
	public static CRMBase instanceDriver=null;
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public CRMBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static CRMBase getInstance()
	{
		if(instanceDriver==null)
			instanceDriver=new CRMBase();
		return instanceDriver;
	}
	
	public void init()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//browser-server//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"//browser-server//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		wait=new WebDriverWait(driver, Long.parseLong(prop.getProperty("EXPLICIT_WAIT")));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//return driver;
	}
	

}
