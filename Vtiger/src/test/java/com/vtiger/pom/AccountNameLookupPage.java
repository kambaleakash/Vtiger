package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class AccountNameLookupPage
{
	@FindBy (xpath = "//a[@class='tableHead']/../../../tr[2]/td[1]/a")
	private WebElement account;
	
	public AccountNameLookupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccount()
	{
		return account;
	}

	public void setAccount() 
	{
		account.click();
	}
	
	

}
