package com.vtiger.testscript;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.FileLib;
import com.vtiger.pom.AccountNameLookupPage;
import com.vtiger.pom.CreateContactPage;
import com.vtiger.pom.DisplayingCustomViewDetailsPage;
import com.vtiger.pom.EditContactPage;
import com.vtiger.pom.HomePage;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class Contacts extends BaseClass
{
	@Test (groups = "smoke", invocationCount = 1)
	public void createContact() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Contacts>>createContact>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Contacts>>createContact>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("contacts").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setContactsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setNewContactBtn();

			String pwh = driver.getWindowHandle();

			CreateContactPage c=new CreateContactPage(driver);
			c.setAccountNameLookUp();

			Set<String> awh = driver.getWindowHandles();
			for(String wh : awh)
			{
				driver.switchTo().window(wh);

				if(driver.getTitle().contains("Zoho CRM - Account Name Lookup"))
				{
					AccountNameLookupPage a=new AccountNameLookupPage(driver);
					a.setAccount();
				}
			}

			driver.switchTo().window(pwh);
			FileLib f=new FileLib();
			c.setLastName(f.getExcelData("contacts", i, 1));
			c.setSaveBtn();
		}
	}

	@Test (groups = "regression", invocationCount = 1)
	public void editContact() throws EncryptedDocumentException, IOException, AWTException
	{
		Reporter.log("Contacts>>editContact>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Contacts>>editContact>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis=new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("contacts").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setContactsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setEditLink();

			EditContactPage e=new EditContactPage(driver);
			FileLib f=new FileLib();
			e.setMobile(f.getExcelData("contacts", i, 2));
			e.setSaveBtn();



		}
	}

	@Test (groups = {"smoke", "regression"}, invocationCount = 1)
	public void deleteContact()
	{
		Reporter.log("Contacts>>deleteContact>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Contacts>>deleteContact>>Thread ID "+Thread.currentThread().getId());
		HomePage h=new HomePage(driver);
		h.setContactsTab();

		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
		d.setDeleteLink();

		Alert al = driver.switchTo().alert();
		al.accept();
		
	//	Assert.fail();


	}

}
