package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CampaignNameLookUpPage 
{
	@FindBy (xpath = "//tr[@class='tableHeadBg']/../tr[2]/td[1]/a")
	private WebElement campaign;
	
	public CampaignNameLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaign() 
	{
		return campaign;
	}

	public void setCampaign()
	{
		campaign.click();
	}
	
	

}
