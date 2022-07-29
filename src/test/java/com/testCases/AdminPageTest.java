package com.testCases;

import java.io.IOException;

import org.testng.annotations.*;

import com.config.BaseCLass;
import com.pageobjectmodel.AdminPage;
import com.pageobjectmodel.LoginPage;

public class AdminPageTest extends BaseCLass 
{	
	
	
	@BeforeMethod
	public void AdminPageTest() throws IOException
	{
		initilization();
		LoginPage login = new LoginPage(driver);
		login.login("Admin", "admin123");
	}
	
	// Adding the user
	@Test
	public void addUser() throws InterruptedException
	{	
		AdminPage admin = new AdminPage(driver);
		admin.addUser();
	}
	
	@Test
	public void cancleButtonWorking() throws InterruptedException
	{
		AdminPage admin = new AdminPage(driver);
		admin.addUserCanclebtn();
	}
	
	@Test
	public void check_test_user()
	{
		AdminPage admin = new AdminPage(driver);
		admin.check_system_user();
	}
		
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.close();
	}
}
