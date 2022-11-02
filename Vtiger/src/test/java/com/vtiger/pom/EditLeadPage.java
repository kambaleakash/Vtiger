package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class EditLeadPage 
{
	@FindBy (name = "property(Lead Status)")
	private WebElement leadStatusDropDown;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public EditLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadStatusDropDown()
	{
		return leadStatusDropDown;
	}

	public void setLeadStatusDropDown()
	{
		leadStatusDropDown.click();
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
