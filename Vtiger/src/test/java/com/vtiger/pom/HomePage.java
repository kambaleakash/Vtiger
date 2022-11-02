package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class HomePage
{
	@FindBy (linkText = "Logout [rashmi@dell.com]")
	private WebElement logout;

	@FindBy (linkText = "Campaigns")
	private WebElement campaignsTab;
	
	@FindBy (linkText = "Leads")
	private WebElement leadsTab;
	
	@FindBy (linkText = "Accounts")
	private WebElement accountsTab;
	
	@FindBy (linkText = "Contacts")
	private WebElement contactsTab;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getCampaignsTab()
	{
		return campaignsTab;
	}



	public void setCampaignsTab()
	{
		campaignsTab.click();
	}



	public WebElement getLogout()
	{
		return logout;
	}

	public void setLogout()
	{
		logout.click();
	}


	public WebElement getAccountsTab() 
	{
		return accountsTab;
	}



	public void setAccountsTab() 
	{
		accountsTab.click();
	}



	public WebElement getLeadsTab() 
	{
		return leadsTab;
	}



	public void setLeadsTab()
	{
		leadsTab.click();
	}



	public WebElement getContactsTab() 
	{
		return contactsTab;
	}



	public void setContactsTab() 
	{
		contactsTab.click();
	}
	
	
	
	
	



}
