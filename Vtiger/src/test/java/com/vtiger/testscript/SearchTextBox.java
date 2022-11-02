package com.vtiger.testscript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.pom.DisplayingCustomViewDetailsPage;

public class SearchTextBox extends BaseClass
{
	@DataProvider
	public Object[] getSearchTxtBx()
	{
		Object[] obj=new Object[5];
		
		obj[0]="Hii";
		obj[1]="akash";
		obj[2]="Hello";
		obj[3]="How";
		obj[4]="123";
		
		return obj;
		
	}
	
	@Test (dataProvider = "getSearchTxtBx")
	public void testSearchTxtBx(String value)
	{
		DisplayingCustomViewDetailsPage d=new DisplayingCustomViewDetailsPage(driver);
		d.setSearchTxtBx(value);
		d.setGoButton();
		
		SoftAssert s=new SoftAssert();
		s.assertEquals(d.getActMatchingText().getText().contains("Matching"), true);
		s.assertEquals(d.getActNonMatchingText().getText().contains("Note :"), true );
		
		s.assertAll();
	}
}
