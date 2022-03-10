package com.LearnAutomation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.LearnAutomation.Utility.BrowserFactory;
import com.LearnAutomation.Utility.ConfigDataProvider;
import com.LearnAutomation.Utility.ExcelDataProvider;
import com.LearnAutomation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up the Reports and Test Started", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
		Reporter.log("Setting Done - Test can be Started", true);
	}

	@BeforeClass
	public void setup() {
		
		Reporter.log("Trying to start Browser and Getting application ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingURL());
		
		Reporter.log("Browser and Application is up and running", true);
	}

	@AfterClass 
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
				logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} 
		
		
		report.flush();
		
		Reporter.log("Test Completed >>> reports generated", true);
	}
}
