package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class SignInPage
{
	@FindBy (name="j_username")
	private WebElement login_Name;

	@FindBy (id = "passWord")
	private WebElement password;

	@FindBy (xpath = "//input[@alt='Sign In']")
	private WebElement signIn;

	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin_Name()
	{
		return login_Name;
	}

	public void setLogin_Name(String un)
	{
		login_Name.sendKeys(un);
	}

	public WebElement getPassword()
	{
		return password;
	}

	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}

	public WebElement getSignIn()
	{
		return signIn;
	}

	public void setSignIn()
	{
		signIn.click();
	}



}
