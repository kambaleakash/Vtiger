package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CreateLeadPage
{
	@FindBy (name = "property(First Name)")
	private WebElement firstName;
	
	@FindBy (name = "property(Last Name)")
	private WebElement lastName;
	
	@FindBy (name = "property(Company)")
	private WebElement companyName;
	
	@FindBy (xpath = "//img[@title='Campaign Name Lookup']")
	private WebElement campaignNameLookup;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String name)
	{
		firstName.click();
		firstName.sendKeys(name);
	}

	public WebElement getLastName() 
	{
		return lastName;
	}

	public void setLastName(String name) 
	{
		lastName.sendKeys(name);
	}

	public WebElement getCompanyName() 
	{
		return companyName;
	}

	public void setCompanyName(String name)
	{
		companyName.sendKeys(name);
	}

	public WebElement getCampaignNameLookup() 
	{
		return campaignNameLookup;
	}

	public void setCampaignNameLookup()
	{
		campaignNameLookup.click();
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
