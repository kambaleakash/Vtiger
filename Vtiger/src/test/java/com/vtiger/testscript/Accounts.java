package com.vtiger.testscript;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.FileLib;
import com.vtiger.pom.AccountDetailsPage;
import com.vtiger.pom.CreateAccountPage;
import com.vtiger.pom.DisplayingCustomViewDetailsPage;
import com.vtiger.pom.EditAccountPage;
import com.vtiger.pom.HomePage;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class Accounts extends BaseClass
{
	@Test (groups = "smoke", invocationCount = 1)
	public void createAccount() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Accounts>>createAccount>>Thread ID "+Thread.currentThread().getId(), true);
	//	System.out.println("Accounts>>createAccount>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("accounts").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setAccountsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setNewAccountBtn();

			CreateAccountPage c=new CreateAccountPage(driver);
			FileLib f=new FileLib();
			c.setAccountName(f.getExcelData("accounts", i, 0));
			c.setSaveBtn();

			AccountDetailsPage a=new AccountDetailsPage(driver);
			String expTitle="Zoho CRM - Account Details";

			//	Assert.assertEquals(a.getActualAccName().getText(), f.getExcelData("accounts", i, 0));
			
			SoftAssert s=new SoftAssert();
			s.assertEquals(driver.getTitle().contains(expTitle), true);
			
			s.assertAll();

		}
	}

	@Test (groups = "regression", invocationCount = 1)
	public void editAccount() throws EncryptedDocumentException, IOException, AWTException
	{
		Reporter.log("Accounts>>editAccount>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Accounts>>editAccount>>Thread ID "+Thread.currentThread().getId());
		FileInputStream fis=new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		for(int i=1; i<wb.getSheet("accounts").getLastRowNum(); i++)
		{
			HomePage h=new HomePage(driver);
			h.setAccountsTab();

			DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
			d.setEditLink();

			EditAccountPage e=new EditAccountPage(driver);
			FileLib f=new FileLib();
			e.setAccountNumber(f.getExcelData("accounts", i, 1));

			e.setSaveBtn();

			AccountDetailsPage a=new AccountDetailsPage(driver);
			
			SoftAssert s=new SoftAssert();
			s.assertEquals(a.getActAccNum().getText(), f.getExcelData("accounts", i, 1));
			
			s.assertAll();

		}

	}

	@Test (groups = {"smoke", "regression"}, invocationCount = 1)
	public void deleteAccount()
	{
		Reporter.log("Accounts>>deleteAccount>>Thread ID "+Thread.currentThread().getId());
		System.out.println("Accounts>>deleteAccount>>Thread ID "+Thread.currentThread().getId());
		HomePage h=new HomePage(driver);
		h.setAccountsTab();

		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
		d.setDeleteLink();

		Alert al = driver.switchTo().alert();
		al.accept();


	}


}
