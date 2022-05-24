package com.salesforcePOM.pages.homePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforcePOM.base.SFbasePagePOM;

public class HomePage extends SFbasePagePOM {
WebDriver driver;
	
	@FindBy(xpath ="//h1[text()='Home Page ~ Salesforce - Developer Edition']") WebElement salesforceHomePage;
	//@FindBy(xpath="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[1]/h1[1]/a[1]") WebElement salesforceHomePage;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public String GetTextFromSalesforceHomePageTitle(){
		System.out.println("this is a before retriving text ");

		String text=readText(salesforceHomePage, "title field");
		System.out.println("this is a textt "+text);
		return text;
	}
	
}
