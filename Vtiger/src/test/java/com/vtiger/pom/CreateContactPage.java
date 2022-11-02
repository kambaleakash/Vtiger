package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class CreateContactPage
{
	@FindBy (xpath = "//img[@title='Account Name Lookup']")
	private WebElement accountNameLookUp;
	
	@FindBy (name = "property(Last Name)")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountNameLookUp()
	{
		return accountNameLookUp;
	}

	public void setAccountNameLookUp()
	{
		accountNameLookUp.click();
	}

	public WebElement getLastName() 
	{
		return lastName;
	}

	public void setLastName(String name)
	{
		lastName.sendKeys(name);
	}

	

	public void setSaveBtn() 
	{
		saveBtn.click();
	}
	
	
	
	
	

}
