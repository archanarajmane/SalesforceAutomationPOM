package page.salesforcePOM.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforcePOM.base.SFbaseTestPOM;
import com.salesforcePOM.pages.homePages.HomePage;
import com.salesforcePOM.pages.loginPages.LoginPage;
import com.salesforcePOM.utility.SFCommonUtilitiesPOM;

public class SFautomationScriptPOM extends SFbaseTestPOM{
	@Test
	
	public static void TC01(){
		String expected="Please enter your password.";
		LoginPage login=new LoginPage(driver);
		String userName=SFCommonUtilitiesPOM.getApplicationProperty("username"); 
		String passwrd=SFCommonUtilitiesPOM.getApplicationProperty("password");
		login.login(userName, passwrd);
		String errormsg=login.check_error();
		Assert.assertEquals(errormsg,expected);
	}

	@Test
	
	public static void TC02(){
		LoginPage login=new LoginPage(driver);
		String userName=SFCommonUtilitiesPOM.getApplicationProperty("username"); 
		String passwrd=SFCommonUtilitiesPOM.getApplicationProperty("password");
		login.login(userName, passwrd);
	}
	
	@Test
	public static void TC03(){
		String expected=SFCommonUtilitiesPOM.getApplicationProperty("username");
		LoginPage login=new LoginPage(driver);
		String userName=SFCommonUtilitiesPOM.getApplicationProperty("username"); 
		String passwrd=SFCommonUtilitiesPOM.getApplicationProperty("password");
		login.login(userName, passwrd);
		String uname=login.check_error();
		Assert.assertEquals(uname,expected);
	}
	
	@Test

	public static void TC04A()
	{
		String expected="Check Your Email";
		String userName=SFCommonUtilitiesPOM.getApplicationProperty("username");
		LoginPage login=new LoginPage(driver);
		String emailText=login.forgotPassword(userName);
		Assert.assertEquals(emailText,expected);
		
	}
	@Test

	public static void TC04B()
	{
		String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		LoginPage login=new LoginPage(driver);
		login.login("","");
		String userdetails=login.check_error();
		Assert.assertEquals(userdetails,expected);
	}
}	
	
