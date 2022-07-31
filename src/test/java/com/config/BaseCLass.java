package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCLass {
	public WebDriver driver;
	public static Properties prop;	 
	
	public void initilization() throws IOException
	{
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		prop = new Properties();
				
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		
		prop.load(file);
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
}
