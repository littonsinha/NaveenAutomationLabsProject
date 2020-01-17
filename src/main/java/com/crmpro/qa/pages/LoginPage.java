package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(css = "input[name='email']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(css = "input[name='password']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(css = ".ui.fluid.large.blue.submit.button")
	@CacheLookup
	private WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}

	public HomePage enterLoginCreds(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}