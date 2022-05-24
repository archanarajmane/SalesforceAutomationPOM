package com.salesforcePOM.base;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFbasePagePOM {
	
	protected static WebDriver driver;
	 protected static WebDriverWait wait;
	
	 
	public  SFbasePagePOM(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public static void enterText(WebElement element,String text,String objName) {
		if(element.isDisplayed()) {
			clearElement(element,objName);
			element.sendKeys(text);
			//report.logTestInfo("text entered in "+objName +"field");
		}
		else {
			System.out.println("fail: "+objName+" element not displayed");
		}
	}
	public static void clickElement(WebElement element,String objName) {
		if(element.isDisplayed()) {
			element.click();
			//report.logTestInfo("pass:"+objName+" element clicked");
		}
		else {
			//report.logTestInfo("fail:"+objName+"  element not displayed");
			
		}
	}
	
	public static void clearElement(WebElement element,String objName) {
		if(element.isDisplayed()) {
			element.clear();
		//	report.logTestInfo("pass:"+objName+"  element cleared");
			
		}
		else {
		//	report.logTestInfo("fail:"+objName+" element not displayed");
		}
	}
	
	public static String readText(WebElement element,String objectName) {
		waitUntilVisible(element, objectName);
		String text=element.getText();
		return text;
	}
	
	public static void waitUntilVisible(WebElement element,String objName) {
		System.out.println("in the wait function with string and element");
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	
	

