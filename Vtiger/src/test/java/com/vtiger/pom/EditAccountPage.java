package com.vtiger.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class EditAccountPage 
{
	@FindBy (name = "property(Account Number)")
	private WebElement accountNumber;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public EditAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountNumber() 
	{
		return accountNumber;
	}

	public void setAccountNumber(String accNumber) throws AWTException 
	{
		accountNumber.click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		accountNumber.sendKeys(accNumber);
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
