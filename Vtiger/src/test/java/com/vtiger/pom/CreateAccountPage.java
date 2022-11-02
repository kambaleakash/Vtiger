package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CreateAccountPage 
{
	@FindBy (name = "property(Account Name)")
	private WebElement accountName;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;
	
	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountName() 
	{
		return accountName;
	}

	public void setAccountName(String name) 
	{
		accountName.sendKeys(name);
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	public void setSaveBtn() 
	{
		saveBtn.click();
	}
	
	

}
