package com.salesforcePOM.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforcePOM.utility.SFCommonUtilitiesPOM;
import com.salesforcePOM.utility.SFConstantsPOM;
import com.salesforcePOM.utility.SFGenerateReportsPOM;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SFbaseTestPOM {

	
	protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	 public static SFGenerateReportsPOM report;
	 public static String method_name;
	 
	@BeforeTest
	 public static void initialTestSetup() {
		report= SFGenerateReportsPOM.getInstance();
		report.startExtentReport();
	 }
	 
	@BeforeMethod
	 public static void setUp(Method method) {
		
		report.startSingleTestReport(method.getName());
		 System.out.println("before method started");
		 System.out.println(method.getName());
		 method_name=method.getName();
		 String url=SFCommonUtilitiesPOM.getApplicationProperty("url");
			
		 getDriver();
		 gotoUrl(url);
		}
	
	
	 @AfterMethod
	 public static void tearDown() {
		 System.out.println("after method started");
		 
		 closeAllDriver();
	 }
	 
	@AfterTest
	 public static void finalTestTearDown() {
		 report.endReport();
	 }
	 
	 
	 
	public static void getDriver() {
			WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   report.logTestInfo("driver instance created");
		 

	}
	public static void gotoUrl(String url) {
		driver.get(url);
		report.logTestInfo("url entered is "+url);
	}
	
	
	public static void closeDriver() {
		driver.close();
	}
	
	public static void closeAllDriver() {
		driver.quit();
	}

	
public static String takescreenshot() {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		report.logTestInfo("screeen shot captured");
		String filePath=SFConstantsPOM.SCREENSHOT_PATH+"salesforcePOM.jpg";
		File DestFile=new File(filePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;

	}
	
}
