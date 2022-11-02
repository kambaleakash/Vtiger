package com.vtiger.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class DisplayingCustomViewDetailsPage
{
	@FindBy (xpath = "//input[@value='New Campaign']")
	private WebElement newCampaignbtn;

	@FindBy (xpath = "(//a[text()='Edit'])[2]")  
	private WebElement editLink;

	@FindBy (xpath = "(//a[text()='Del'])[5]")
	private WebElement deleteLink;

	@FindBy (name = "searchString")
	private WebElement findCampaign;

	@FindBy (xpath = "//div[text()='< No Campaigns found >']")
	private WebElement noCampaign;

	@FindBy (xpath = "//tr[@class='tableHeadBg']/../tr[2]")
	private WebElement searchCampaign;

	@FindBy (xpath = "(//a[text()='Del'])[5]/../../../td[3]")
	private WebElement deleteCampaign;
	
	@FindBy (xpath = "//a[text()='Del']")
	private WebElement fetchCampaign;
	
	@FindBy (xpath = "//input[@value='New Lead']")
	private WebElement newLeadBtn;
	
	@FindBy (xpath = "//input[@value='New Account']")
	private WebElement newAccountBtn;
	
	@FindBy (xpath = "//input[@value='New Contact']")
	private WebElement newContactBtn;
	
	@FindBy (id = "searchword")
	private WebElement searchTxtBx;
	
	@FindBy (xpath = "//input[@value='Go']")
	private WebElement goButton;
	
	@FindBy (xpath = "//span[text()='Note :']")
	private WebElement actNonMatchingText; 

	@FindBy (xpath = "//td[contains(text(),'Matching')]")
	private WebElement actMatchingText;
	 

	
	
	public DisplayingCustomViewDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewCampaignbtn()
	{
		return newCampaignbtn;
	}

	public void setNewCampaignbtn()
	{
		newCampaignbtn.click();
	}

	public WebElement getEditLink()
	{
		return editLink;
	}

	public void setEditLink()
	{
		editLink.click();
	}

	public WebElement getDeleteLink()
	{
		return deleteLink;
	}

	public void setDeleteLink()
	{
		deleteLink.click();
	}

	public WebElement getFindCampaign()
	{
		return findCampaign;
	}

	public void setFindCampaign(String CampaignName)
	{
		findCampaign.click();
		findCampaign.sendKeys(CampaignName + Keys.ENTER);
	}

	public WebElement getNoCampaign()
	{
		return noCampaign;
	}

	public void setNoCampaign()
	{
		this.noCampaign = noCampaign;
	}

	public WebElement getSearchCampaign()
	{
		return searchCampaign;
	}

	public void setSearchCampaign(String name)
	{
		searchCampaign.click();
		searchCampaign.sendKeys(name);
	}

	public void setDeleteLink(WebElement deleteLink)
	{
		this.deleteLink = deleteLink;
	}

	public WebElement getDeleteCampaign()
	{
		return deleteCampaign;
	}

	public void setDeleteCampaign()
	{
		this.deleteCampaign = deleteCampaign;
	}

	public WebElement getFetchCampaign() 
	{
		return fetchCampaign;
	}

	public void setFetchCampaign(WebElement fetchCampaign) 
	{
		this.fetchCampaign = fetchCampaign;
	}

	public WebElement getNewLeadBtn() 
	{
		return newLeadBtn;
	}

	public void setNewLeadBtn() 
	{
		newLeadBtn.click();
	}

	public WebElement getNewAccountBtn() 
	{
		return newAccountBtn;
	}

	public void setNewAccountBtn() 
	{
		newAccountBtn.click();
	}

	public WebElement getNewContactBtn() 
	{
		return newContactBtn;
	}

	public void setNewContactBtn() 
	{
		newContactBtn.click();
	}

	public WebElement getSearchTxtBx() 
	{
		return searchTxtBx;
	}

	public void setSearchTxtBx(String value) 
	{
		searchTxtBx.sendKeys(value);
	}

	public WebElement getGoButton() 
	{
		return goButton;
	}

	public void setGoButton() 
	{
		goButton.click();
	}

	public WebElement getActNonMatchingText() 
	{
		return actNonMatchingText;
	}

	public WebElement getActMatchingText() 
	{
		return actMatchingText;
	}

	
	
	
	
	
	

	














}
