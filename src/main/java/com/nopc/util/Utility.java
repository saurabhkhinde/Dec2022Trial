package com.nopc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Utility   // excel, screenshot code
{
	static Workbook wbf;
	static FileInputStream file;
	static String filepath;
	public static String excelStringdata(String SheetName,int rownumber,int cellnumber) throws IOException 
	
	{    filepath = System.getProperty("user.dir")+"\\TestData\\TEST2.xlsx";
	    file= new FileInputStream(filepath);
		wbf= WorkbookFactory.create(file);
	    String data = wbf.getSheet(SheetName).getRow(rownumber-1).getCell(cellnumber-1).getStringCellValue();
        return data;
	}	
		
	
	public static boolean excelbooleandata(String SheetName,int rownumber,int cellnumber) throws EncryptedDocumentException, IOException	
	{
		filepath = System.getProperty("user.dir")+"\\TestData\\TEST2.xlsx";
	    file= new FileInputStream(filepath);
		wbf= WorkbookFactory.create(file);
	    boolean data = wbf.getSheet(SheetName).getRow(rownumber-1).getCell(cellnumber-1).getBooleanCellValue();
        return data;
	
			
		
	}	
		
//	public static double excelNumericdata(String SheetName,int rownumber,int cellnumber) throws EncryptedDocumentException, IOException	
//	{
//		  
//		FileInputStream file= new FileInputStream("C:\\eclipsefile\\SeleniumAugust2022\\TestData\\TEST2.xlsx");
//		wbf= WorkbookFactory.create(file);
//	    double data = wbf.getSheet(SheetName).getRow(rownumber-1).getCell(cellnumber-1).getNumericCellValue();
//        return data;
	
			
		
		
		
	public static void screenshot(WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;//typecast
		File source = ts.getScreenshotAs(OutputType.FILE);

		Date d= new Date();
		    
		String timestamp = d.toString().replace(":", "_").replace(" ", "_");
			
		//File destination= new File("C:\\eclipsefile\\SeleniumAugust2022\\ScreenShots\\"+timestamp+".jpg");
		
		File destination= new File(System.getProperty("user.dir")+"\\ScreenShots\\"+timestamp+".jpg");
	
		FileHandler.copy(source,destination);
	}
		
	public static String readpropertyfile(String key) throws IOException
	{
//		 filepath = System.getProperty("user.dir")+"\\TestData\\TEST2.xlsx";
		Properties props=new Properties();
		   FileInputStream propertyfile = new FileInputStream(System.getProperty("user.dir")+"\\config.properties\\");
		   props.load(propertyfile);
		   String value = props.getProperty(key);
		  return value;
	}
	
}
