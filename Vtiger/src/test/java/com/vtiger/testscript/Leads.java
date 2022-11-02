package com.vtiger.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

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
import com.vtiger.pom.CampaignNameLookUpPage;
import com.vtiger.pom.CreateLeadPage;
import com.vtiger.pom.DisplayingCustomViewDetailsPage;
import com.vtiger.pom.EditLeadPage;
import com.vtiger.pom.HomePage;
import com.vtiger.pom.LeadDetailsPage;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class Leads extends BaseClass
{
	@Test (priority = 1, groups = "smoke", invocationCount = 1)
	public void createLead() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Leads>>createLead>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Leads>>createLead>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis=new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("leads").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setLeadsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setNewLeadBtn();

			CreateLeadPage c=new CreateLeadPage(driver);
			FileLib f=new FileLib();

			c.setFirstName(f.getExcelData("leads", i, 0));
			c.setLastName(f.getExcelData("leads", i, 1));
			c.setCompanyName(f.getExcelData("leads", i, 2));



			String parentTitle = driver.getWindowHandle();

			c.setCampaignNameLookup();

			String childTitle="Zoho CRM - Campaign Name Lookup";


			Set<String> awh = driver.getWindowHandles();

			for(String wh:awh)
			{
				driver.switchTo().window(wh);
				if(driver.getTitle().contains(childTitle))
				{
					CampaignNameLookUpPage c1=new CampaignNameLookUpPage(driver);
					c1.setCampaign();
				}
			}


			driver.switchTo().window(parentTitle);
			c.setSaveBtn();

			String expTitile = "Zoho CRM - Lead Details";

			LeadDetailsPage l=new LeadDetailsPage(driver);

			SoftAssert s=new SoftAssert();
			s.assertEquals(driver.getTitle().contains(expTitile), true);
			//		Assert.assertEquals(l.getActualLeadName().getText(), " "+f.getExcelData("leads", i, 0) +" "+f.getExcelData("leads", i, 1));
			
			s.assertAll();
		}
	}

	@Test (priority = 2, groups = "regresion", invocationCount = 1)
	public void editLead() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Leads>>editLead>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Leads>>editLead>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis=new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("leads").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setLeadsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setEditLink();

			EditLeadPage e=new EditLeadPage(driver);

			e.setLeadStatusDropDown();
			Select s=new Select(e.getLeadStatusDropDown());
			FileLib f=new FileLib();
			s.selectByValue(f.getExcelData("leads", i, 3));

			e.setSaveBtn();

			LeadDetailsPage l=new LeadDetailsPage(driver);
			
			SoftAssert s1=new SoftAssert();
			s1.assertEquals(l.getActualLeadStatus().getText(), f.getExcelData("leads", i, 3));
			
			s1.assertAll();
		}
	}
	

	@Test (priority = 3, groups = {"smoke", "regression"}, invocationCount = 1)
	public void deleteLead()
	{
		Reporter.log("Leads>>deleteLead>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Leads>>deleteLead>>Thread ID "+Thread.currentThread().getId());
		HomePage h=new HomePage(driver);
		h.setLeadsTab();

		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
		d.setDeleteLink();

		Alert al = driver.switchTo().alert();
		al.accept();

	}


}
