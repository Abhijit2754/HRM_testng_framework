package com.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.config.BaseCLass;
import com.pageobjectmodel.LoginPage;

public class LoginPageTest extends BaseCLass{
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("report.html"); 
	
	@BeforeMethod
	public void init() throws IOException
	{
		extent.attachReporter(spark);
		initilization();
	}	
	
	@Test(groups = {"smoke","sanity"}, priority = 1)
	public void test_login() throws InterruptedException
	{		
		ExtentTest test = extent.createTest("Add the text in Google search1").assignAuthor("Abhijit");
		test.info("Object Created");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Parameter pass to the object function");
		loginPage.login("Admin", "admin123");
		test.pass("Pass this test");
	}
	
	@Test(priority = 2)
	public void test_forget_password()
	{
		ExtentTest test = extent.createTest("Add the text in Google search2").assignAuthor("Abhijit");
		test.info("Object Created");
		LoginPage loginPage = new LoginPage(driver);
		test.info("Started Forget password function execution");
		loginPage.forget_password();
		test.info("parameter send to the text field for user validation ");
		loginPage.validatePasswordFeild("Admin");
		test.pass("Complited test case");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		extent.flush();
		Thread.sleep(2000);
		driver.close();	
	}
}
