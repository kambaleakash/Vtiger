package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CampaignDetailsPage
{
	@FindBy (id = "value_Campaign Name")
	private WebElement actualCampaignName;

	@FindBy (id = "value_Status")
	private WebElement actualStatus;

	public CampaignDetailsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getActualCampaignName()
	{
		return actualCampaignName;
	}


	public WebElement getActualStatus()
	{
		return actualStatus;
	}



}
