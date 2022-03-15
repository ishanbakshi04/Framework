package com.LearnAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	WebDriver driver;
	 

	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	//@FindBy(xpath="//span[normalize-space()='Log In']") WebElement loginButton;
	//@FindBy(xpath="//a[normalize-space()='Login']") WebElement loginButton;
	@FindBy(xpath="//li[@class='active']") WebElement loginButton;
	
	@FindBy(xpath="//input[@name='email']") WebElement uname;
	
	//@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//input[@name='password']") WebElement pass;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginButton1;
	
	
	
	public void logintoCRM(String usernameApplication, String passwordApplication)
	{
		
		
		loginButton.click();
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		
		loginButton1.click();
		
		try 
		{
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
	}
	
}

