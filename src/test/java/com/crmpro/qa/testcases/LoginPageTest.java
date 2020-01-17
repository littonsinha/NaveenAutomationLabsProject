package com.crmpro.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crmpro.qa.base.TestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void logintoApp()
	{
		launchBrowser();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void pageTitleTest()
	{
		String PageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(PageTitle, prop.getProperty("ActualPageTitle"));
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		homePage = loginPage.enterLoginCreds(prop.getProperty("username"), prop.getProperty("password"));
	}
}