package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmpro.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(css = "span.user-display")
	@CacheLookup
	private WebElement loginName;
	
	@FindBy(css = "a[href='/home']")
	@CacheLookup
	private WebElement homesubMenu;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyloginName()
	{
		String LoginName =  loginName.getText();
		Assert.assertEquals(prop.getProperty("Name"), LoginName);
	}
	
	public void verifyhomeSubMenuIsDisplayed()
	{
		boolean flag = homesubMenu.isDisplayed();
		Assert.assertTrue(flag);
	}

}
