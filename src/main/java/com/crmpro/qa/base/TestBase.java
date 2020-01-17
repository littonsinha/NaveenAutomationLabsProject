package com.crmpro.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmpro.qa.utils.TestUtil;

public class TestBase
{
	public static Logger log;
	public static Properties prop;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static String browserName;
	
	public TestBase() 
	{
		{
			log = LogManager.getLogger(getClass());
			try
			{
				prop = new Properties();
				fis = new FileInputStream("..\\NaveenAutomationLabsProject\\src\\main\\java\\com\\crmpro\\qa\\config\\Config.properties");
				prop.load(fis);
				
			} catch (Exception e)
			{
				log.warn("Config file not found. Retry again...");
			}
		}
	}
	
	public void launchBrowser()
	{
		browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "..\\NaveenAutomationLabsProject\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "..\\NaveenAutomationLabsProject\\Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else
		{
			driver = null;
		}
		log.info(prop.getProperty("URL") + "browser is getting launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLYWAIT, TimeUnit.SECONDS);
		log.info("Navigating to the URL: " + prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));	
	}
}