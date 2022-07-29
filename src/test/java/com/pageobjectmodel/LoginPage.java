package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.actiondriver.ActionClass;

public class LoginPage {
	
	ActionClass action = new ActionClass();
	
	WebDriver driver;
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(id = "btnLogin")
	private WebElement btn;
	
	@FindBy(partialLinkText = "welcome ")
	private WebElement nextPageWelcomeMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
	WebElement forGetPassword;
	
	@FindBy(id="securityAuthentication_userName")
	WebElement forgetTextbox;
	
	@FindBy(id = "btnSearchValues")
	WebElement clickForgetButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void login(String getUsername, String getPassword) 
	{	
		action.type(username, getUsername);
		action.type(password, getPassword);
		action.click(btn);
		action.checkAssertStatus(driver.getCurrentUrl().contains("dashboard"));		
	}
	
	public void forget_password()
	{
		action.click(forGetPassword);
		action.checkAssertStatus(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	}
	
	public void validatePasswordFeild(String str)
	{
		action.type(forgetTextbox, str);
		action.click(clickForgetButton);
	}
}







