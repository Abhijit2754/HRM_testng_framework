package com.testCases;

import java.io.IOException;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.config.BaseCLass;
import com.pageobjectmodel.AdminPage;
import com.pageobjectmodel.LoginPage;

public class AdminPageTest extends BaseCLass 
{	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("report1.html"); 
	
	
	@BeforeMethod
	public void AdminPageTest() throws IOException
	{
		extent.attachReporter(spark);
		initilization();
		LoginPage login = new LoginPage(driver);
		login.login("Admin", "admin123");
	}
	
	// Adding the user
	@Test
	public void addUser() throws InterruptedException
	{	
		ExtentTest test = extent.createTest("Add the text in Google search3").assignAuthor("Abhijit");
		test.info("Object Created for AdminPage ");
		AdminPage admin = new AdminPage(driver);
		test.info("User is added");
		admin.addUser();
		test.pass("User added completed");
	}
	
	@Test
	public void cancleButtonWorking() throws InterruptedException
	{
		ExtentTest test = extent.createTest("Add the text in Google search4").assignAuthor("Abhijit");
		test.info("Object Created for AdminPage ");
		AdminPage admin = new AdminPage(driver);
		test.info("started checking cancel button is working or not");
		admin.addUserCanclebtn();
		test.pass("passed cancel button");
	}
	
	@Test
	public void check_test_user()
	{
		ExtentTest test = extent.createTest("Add the text in Google search5").assignAuthor("Abhijit");
		test.info("Object Created for AdminPage ");
		AdminPage admin = new AdminPage(driver);
		test.info("Check System user Exist or not");
		admin.check_system_user();
		test.pass("User is exist");
	}
		
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		extent.flush();
		Thread.sleep(10000);
		driver.close();
	}
}
