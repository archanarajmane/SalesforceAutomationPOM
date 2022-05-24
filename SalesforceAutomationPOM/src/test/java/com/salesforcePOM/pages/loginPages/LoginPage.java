package com.salesforcePOM.pages.loginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforcePOM.base.SFbasePagePOM;
import com.salesforcePOM.base.SFbaseTestPOM;

import java.lang.reflect.Method;

public class LoginPage extends SFbasePagePOM {

WebDriver driver;
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//input[@id='Login']") WebElement loginButton;
	@FindBy(xpath="//*[@id=\"error\"]") WebElement errormsg;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement remember_me_btn;
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement user_name_lable;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement log_out;
	@FindBy(xpath="//*[@id=\"idcard-identity\"]") WebElement user_name_validation;
	@FindBy(xpath="//a[@id='forgot_password_link']") WebElement forgot_pwd;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]") WebElement forgot_user_name;
	@FindBy(xpath="//input[@id='continue']") WebElement continue_btn;
	@FindBy(xpath="//*[@id=\"header\"]") WebElement check_email;
	@FindBy(id="error") WebElement wrong_pwd_error;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String username) {
		waitUntilVisible(userName,"user name field");
		clearElement(userName,"user name field");
		enterText(userName, username, "user name field");
		
	}
	
	public void enterPassword(String passWord) {
		
		enterText(password, passWord, "password field");
		
		
	}
	
	public void clearPassword(String passWord)
	{
		clearElement(password,passWord);
	}
	
	public void clickLoginButton() {
		clickElement(loginButton,"login button");
		
	}
	
	public void login(String usrname,String passWrd) {
		enterUsername(usrname);
		if (SFbaseTestPOM.method_name=="TC01")
		{
		clearPassword(passWrd);	
		}
		else
		{
		enterPassword(passWrd);
		}
		
		if (SFbaseTestPOM.method_name=="TC03")
		{
			clickElement(remember_me_btn,"remember button");
			clickLoginButton();
			clickElement(user_name_lable, "user name lable");
			clickElement(log_out, "log out");
			
		}
		else
		{
		clickLoginButton();
		}
		if (SFbaseTestPOM.method_name=="TC04B")
		{
			enterUsername("123");
			enterPassword("22131");
			clickLoginButton();
		}
	}

	public String check_error()
	{	
		String text1=null;
		if(SFbaseTestPOM.method_name=="TC03")
		{
		 text1=readText(user_name_validation,"user name validation");
		 //return text1;
		}
		else
		{
		text1=readText(errormsg, "login error msg");
		}
		if(SFbaseTestPOM.method_name=="TC04B")
		{
			text1=readText(wrong_pwd_error,"wrong user details");
		}
		return text1;
	}
	
	public String forgotPassword(String user_nm)
	{
		clickElement(forgot_pwd, "forgot password link");
		enterText(forgot_user_name,user_nm,"usernm");
		clickElement(continue_btn,"continue button");
		return check_email.getText();
	}
}
