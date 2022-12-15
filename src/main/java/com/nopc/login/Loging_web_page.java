package com.nopc.login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopc.util.Utility;

public class Loging_web_page 
{
	
	@FindBy(xpath="//input[@type='checkbox']")private WebElement chkbox;
	@FindBy(xpath="//input[@id='Email']") private WebElement username;
	@FindBy(xpath="//input[@id='Password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;

	public Loging_web_page(	WebDriver driver)
	{
	    PageFactory.initElements(driver, this);	
	}
	
	public String TitleVerify() throws IOException
   {                                                                                                                                                 
		String ExpTitle=Utility.excelStringdata("Sheet1",2,1 );
		return ExpTitle;
       
	}	

	public void CheckBoxVerify() throws EncryptedDocumentException, IOException
	
	{
			
		boolean expchkresult=Utility.excelbooleandata("Sheet1", 2,2);
		boolean ActResult = chkbox.isSelected();
		Assert.assertEquals(ActResult, expchkresult,"CheckBox is Already selected");
	}
	
	public void enterUN() throws IOException
	{
	
		username.clear();
		username.sendKeys(Utility.excelStringdata("Sheet1",2,3));
	
	}
	public void enterpassword() throws IOException
	{
		password.clear();
		password.sendKeys(Utility.excelStringdata("Sheet1",2,4));
	
	   
	}
	
	public void signin() 
	
	{
		
	    login.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
