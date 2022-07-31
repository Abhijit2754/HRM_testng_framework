package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;

public class AdminPage {
	
	WebDriver driver;
	ActionClass action = new ActionClass(); 
	
	@FindBy(xpath="//b[normalize-space()='Admin']")
	private WebElement adminElement;
	
	@FindBy(id="btnAdd")
	private WebElement addUser;
	
	@FindBy(id="systemUser_userType")
	private WebElement selectUser;
	
	@FindBy(xpath="//select[@id='systemUser_userType']")
	private WebElement selectUserRole;
	
	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']")
	private WebElement employeerName;
	
	@FindBy(id="systemUser_userName")
	private WebElement addusername;
	
	@FindBy(xpath="//select[@id='systemUser_status']")
	private WebElement addUserStatus;
	
	@FindBy(xpath="//input[@id='systemUser_password']")
	private WebElement mpassword;
	
	@FindBy(xpath="//input[@id='systemUser_confirmPassword']")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement saveButton;
	
	// System User
	
	@FindBy(id="searchSystemUser_userName")
	private WebElement searchSystemUser;
	
	@FindBy(xpath="//input[@id=\"searchBtn\"]")
	private WebElement searchbtn;
	
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void addUser() throws InterruptedException
	{
		action.click(adminElement);
		action.click(addUser);		
		action.selectValue(selectUserRole,"ESS");
		action.type(employeerName, "Pankaj Kalyanrao Shiral");
		action.type(addusername,"Pankajpatil");
		action.selectValue(addUserStatus, "Enabled");
		action.type(mpassword, "Promote123*");
		action.type(confirmpassword, "Promote123*");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();		
	}
	
	public void addUserCanclebtn() throws InterruptedException
	{
		action.click(adminElement);
		action.click(addUser);		
		action.selectValue(selectUserRole,"ESS");
		action.type(employeerName, "Pankaj Kalyanrao Shiral");
		action.type(addusername,"Pankajpatil");
		action.selectValue(addUserStatus, "Enabled");
		action.type(mpassword, "Promote123*");
		action.type(confirmpassword, "Promote123*");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btnCancel']")).click();		
	}	
	
	public void check_system_user()
	{
		action.click(adminElement);
		action.type(searchSystemUser, "Pankajpatil");
		action.click(searchbtn);		
	}
}
