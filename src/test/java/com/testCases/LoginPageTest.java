package com.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.config.BaseCLass;
import com.pageobjectmodel.LoginPage;

public class LoginPageTest extends BaseCLass{
	
	
	@BeforeMethod
	public void init() throws IOException
	{
		initilization();
	}	
	
	@Test(groups = {"smoke","sanity"}, priority = 1)
	public void test_login() throws InterruptedException
	{		
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.login("Admin", "admin123");
	}
	
	@Test(priority = 2)
	public void test_forget_password()
	{
		LoginPage loginPage = new LoginPage(driver);	
		loginPage.forget_password();
		loginPage.validatePasswordFeild("Admin");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();	
	}
}
