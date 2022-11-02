package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class LeadDetailsPage 
{
	@FindBy (xpath = "//td[contains(text(),'Lead Name')]/../td[4]")
	private WebElement actualLeadName;
	
//	@FindBy (xpath = "//td[contains(text(),'Lead Status')]/../td[4]")
	@FindBy (id = "mouseArea__Lead Status")
	private WebElement actualLeadStatus;
	
	public LeadDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getActualLeadName() 
	{
		return actualLeadName;
	}


	public WebElement getActualLeadStatus()
	{
		return actualLeadStatus;
	}

	
	
	
	

	
}
