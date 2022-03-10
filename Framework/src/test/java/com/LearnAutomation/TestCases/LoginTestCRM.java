package com.LearnAutomation.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.LearnAutomation.Pages.BaseClass;
import com.LearnAutomation.Pages.LoginPage;
import com.LearnAutomation.Utility.ExcelDataProvider;
import com.LearnAutomation.Utility.Helper;

public class LoginTestCRM extends BaseClass{
 
	
	
	
	@Test
	public void loginAPP()
	{
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.logintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Success");
		
	} 
	
}
