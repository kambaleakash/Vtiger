package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CreateCampaignPage
{
	@FindBy (name = "property(Campaign Name)")
	private WebElement campaignName;

	@FindBy (name = "property(Type)")
	private WebElement typeDropDown;

	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignName()
	{
		return campaignName;
	}

	public void setCampaignName(String name)
	{
		campaignName.sendKeys(name);
	}

	public WebElement getTypeDropDown()
	{
		return typeDropDown;
	}

	public void setTypeDropDown()
	{
		typeDropDown.click();
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
