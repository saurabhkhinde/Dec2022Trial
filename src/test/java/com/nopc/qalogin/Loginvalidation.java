package com.nopc.qalogin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopc.base.BaseClass;
import com.nopc.dashboard.Dashbord;
import com.nopc.login.Loging_web_page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Loginvalidation extends BaseClass 
{
	Loging_web_page lp;
	Dashbord d;
	
    
	@BeforeClass
	public void BrowserOpen() throws IOException, EncryptedDocumentException, InterruptedException
	{
           browserlaunch();
           lp= new Loging_web_page( driver);
           d= new Dashbord(driver);
           
	}	
	
	@Test(priority=1)
	public void TitleValidation() throws EncryptedDocumentException, IOException
	{ 
		String acttitle = driver.getTitle();
		String ExpTitle = lp.TitleVerify();
	    Assert.assertEquals(acttitle, ExpTitle," Title is Different");
		
	}
	
	@Test(priority=2)
	public void CheckBoxValidation() throws EncryptedDocumentException, IOException
	{
		lp.CheckBoxVerify();
	}
	
	@Test(priority=3)
	public void LoginValidation() throws IOException
	{
		lp.enterUN();
		lp.enterpassword();
		lp.signin();
	}
		
	
	@Test(dependsOnMethods="LoginValidation")
	public void logoValidation() throws EncryptedDocumentException, IOException
	
	{
		d.LogoVerify(driver);
	}
	
	@AfterClass
	public void BrowserClose()
	{
	driver.close();
	}
			
	}

