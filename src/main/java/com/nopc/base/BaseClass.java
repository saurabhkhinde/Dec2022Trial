package com.nopc.base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nopc.util.Utility;

public class BaseClass 
{	
	protected static WebDriver driver;
   
	public static void browserlaunch() throws InterruptedException, EncryptedDocumentException, IOException 
	{
	    String key="webdriver.chrome.driver";
	    String value=System.getProperty("user.dir")+"\\Softwares\\chromedriver.exe";
		System.setProperty(key,value );
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Utility.readpropertyfile("url"));
	                                                                                             
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
