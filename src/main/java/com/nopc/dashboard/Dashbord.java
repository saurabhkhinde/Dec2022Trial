package com.nopc.dashboard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopc.util.Utility;

public class Dashbord {

	@FindBy(xpath="(//img[@alt='logo.png'])[2]") private  WebElement logo;
	
	
	public Dashbord(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LogoVerify(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		boolean explogoresult=Utility.excelbooleandata("Sheet1",2,5);
		boolean ActLogoResult = logo.isDisplayed();
	Assert.assertEquals(ActLogoResult, explogoresult,"Logo is Displayed");
	
	Utility.screenshot(driver);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
