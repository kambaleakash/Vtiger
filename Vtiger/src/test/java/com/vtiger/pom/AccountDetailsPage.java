package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class AccountDetailsPage 
{
	@FindBy (id = "value_Account Name")
	private WebElement actualAccName;
	
	@FindBy (id = "mouseArea__Account Number")
	private WebElement actAccNum;
	
	public AccountDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getActualAccName() 
	{
		return actualAccName;
	}

	public WebElement getActAccNum()
	{
		return actAccNum;
	}

	
	
	
	
	
	

}
