package com.actiondriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.config.BaseCLass;

import graphql.Assert;
import net.bytebuddy.asm.Advice.Enter;

public class ActionClass extends BaseCLass
{
	public void type(WebElement ele, String str)
	{
		boolean flag = false;
		try
		{
			ele.isDisplayed();			
			ele.clear();
			ele.sendKeys(str);
			flag = true;
		}
		catch(Exception e)
		{
			System.out.println("Location is not found");
			flag = false;
		}
		finally
		{
			if(flag)
				System.out.println("Value Enterd Successfully");			
			else
				System.out.println("The unable to type value");
		}
	}
	
	public void click(WebElement ele)
	{
		boolean flag = false;
		try
		{
			ele.isDisplayed();
			ele.click();
			flag = true;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
				System.out.println("Button is clicked");
			else
				System.out.println("Button is not Clicked");
		}
	}
	
	public void submit(WebElement ele)
	{
		boolean flag = false;
		try
		{
			ele.isDisplayed();
			ele.submit();
			flag = true;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
				System.out.println("Button is clicked");
			else
				System.out.println("Button is not Clicked");
		}
	}
	
	public void checkAssertStatus(boolean status)
	{
		if(status)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public void selectValue(WebElement ele, String value)
	{
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
}



