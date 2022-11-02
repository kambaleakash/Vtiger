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
public class EditContactPage 
{
	@FindBy (name = "property(Mobile)")
	private WebElement mobile;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public EditContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMobile()
	{
		return mobile;
	}

	public void setMobile(String number) throws AWTException 
	{
		mobile.click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		mobile.sendKeys(number);
	}

	
	public void setSaveBtn() 
	{
		saveBtn.click();
	}
	
	


}
