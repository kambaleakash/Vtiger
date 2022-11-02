package com.vtiger.testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.FileLib;
import com.vtiger.pom.CampaignDetailsPage;
import com.vtiger.pom.CreateCampaignPage;
import com.vtiger.pom.DisplayingCustomViewDetailsPage;
import com.vtiger.pom.EditCampaignPage;
import com.vtiger.pom.HomePage;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class Campaigns extends BaseClass
{

	@Test(priority = 1, groups = "smoke", invocationCount = 1)
	public void createCampaign() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Campaigns>>createCampaign>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Campaigns>>createCampaign>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("campaigns").getLastRowNum(); i++)
		{

			HomePage h=new HomePage(driver);
			h.setCampaignsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setNewCampaignbtn();

			CreateCampaignPage c=new CreateCampaignPage(driver);

			FileLib f=new FileLib();
			c.setCampaignName(f.getExcelData("campaigns", i, 0));

			Select s=new Select(c.getTypeDropDown());
			s.selectByValue(f.getExcelData("campaigns", i, 1));

			c.setSaveBtn();

			CampaignDetailsPage c1=new CampaignDetailsPage(driver);
			
			SoftAssert s1=new SoftAssert();
			s1.assertEquals(c1.getActualCampaignName().getText(), f.getExcelData("campaigns", i, 0));
		
			s1.assertAll();
		}
		
	}

	//	@Test (priority = 2 )
	//	public void fetchCampaign()
	//	{
	//		HomePage h=new HomePage(driver);
	//		h.setCampaignsTab();
	//
	//		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
	//		d.setSearchCampaign(name);
	//		
	//		boolean actual = d.getFetchCampaign().isDisplayed();
	//		
	//		
	//
	//		Assert.assertEquals(actual, true);
	//
	//	}





	@Test(priority = 2, groups = "regression", invocationCount = 1)
	public void editCampaign() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Campaigns>>editCampaign>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Campaigns>>editCampaign>>Thread ID "+Thread.currentThread().getId());
		//		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<4; i++)
		{
			HomePage h=new HomePage(driver);
			h.setCampaignsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setEditLink();

			EditCampaignPage e=new EditCampaignPage(driver);
			Select s=new Select(e.getSatusDropDown());
			FileLib f=new FileLib();
			s.selectByValue(f.getExcelData("campaigns", i, 2));
			e.setSaveBtn();


			CampaignDetailsPage c1=new CampaignDetailsPage(driver);
			
			SoftAssert s1=new SoftAssert();
			s1.assertEquals(c1.getActualStatus().getText(), f.getExcelData("campaigns", i, 2));
			
			s1.assertAll();
		}
	}

	@Test(priority = 3, groups = {"smoke", "regression"}, invocationCount = 1)
	public void deleteCampaign()
	{
		Reporter.log("Campaigns>>deleteCampaign>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Campaigns>>deleteCampaign>>Thread ID "+Thread.currentThread().getId());
		HomePage h=new HomePage(driver);
		h.setCampaignsTab();

		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
		d.setDeleteLink();

		Alert al = driver.switchTo().alert();
		al.accept();

		//		h.setCampaignsTab();
		//
		//		String expDeletedCampaign = d.getDeleteCampaign().getText();
		//
		//		d.setSearchCampaign(expDeletedCampaign);
		//
		//		String actText = d.getNoCampaign().getText();
		//
		//		Assert.assertNotEquals(actText, expDeletedCampaign);




	}



}
