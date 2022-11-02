package com.vtiger.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtiger.pom.HomePage;
import com.vtiger.pom.SignInPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners (com.vtiger.generic.ListenerImplementation.class)
public class BaseClass
{
	static
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}

	public WebDriver driver;
	FileLib f=new FileLib();

	@Parameters ("browser")
	@BeforeClass (groups = {"smoke", "regression"})
	public void openBrowser(@Optional ("chrome") String browser) throws IOException
	{
		String url=f.getPropertyData("url");
		
		if(browser.equals("chrome"))
		{
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		}
		
		else if(browser.equals("firefox"))
		{
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		}
	}

	@BeforeMethod (groups = {"smoke", "regression"})
	public void login() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		SignInPage s=new SignInPage(driver);
		s.setLogin_Name(f.getPropertyData("un"));
		s.setPassword(f.getPropertyData("pwd"));
		s.setSignIn();
	}

	@AfterMethod (enabled = true, groups = {"smoke", "regression"})
	public void logout()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		HomePage h=new HomePage(driver);
		h.setLogout();
	}

	@AfterClass (enabled = true, groups = {"smoke", "regression"})
	public void closeBrowser()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.close();
	}

}
