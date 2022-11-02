package com.vtiger.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseClass implements ITestListener
{
//	TakesScreenshot t=(TakesScreenshot) driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
//		String name=result.getName();
//		TakesScreenshot t=(TakesScreenshot) driver;
//		File src = t.getScreenshotAs(OutputType.FILE);
//		File dst=new File("./screenshot/"+name+".png");
//		try 
//		{
//			FileUtils.copyFile(src, dst);
//		}
//		
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
	}

	public void onTestFailure(ITestResult result) 
	{
		String name=result.getName();
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+name+".png");
		try 
		{
			FileUtils.copyFile(src, dst);
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
