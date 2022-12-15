package com.nopc.extent;

import java.util.Map;
import java.util.List;
import java.io.File;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportsNG implements IReporter

{
	private ExtentReports extent;

	public void generateReport(List <XmlSuite> xmlSuites,List <ISuite>suites,
			String outputDirectory)
	{
		extent = new ExtentReports(outputDirectory + File.separator + "extent.html", true);
		
		for(ISuite suite:suites) 
		{
			Map<String, ISuiteResult> result = suite.getResults();
			
			for(ISuiteResult r: result.values()) 
			{
			ITestContext  context = r.getTestContext();
			
			buildTestNodes(context.getPassedTests(),LogStatus.PASS);
			buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
			buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
			}
		
		}
		extent.flush();
		extent.close();
		
	}
	private void buildTestNodes(IResultMap tests, LogStatus skip) 
	{
	 ExtentTest test;
		
	}
}