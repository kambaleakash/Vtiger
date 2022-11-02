package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class EditCampaignPage
{
	@FindBy (name = "property(Status)")
	private WebElement satusDropDown;

	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public EditCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSatusDropDown()
	{
		return satusDropDown;
	}

	public void setSatusDropDown()
	{
		satusDropDown.click();
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
