package com.avh.Testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.avh.Pages.HomePage;
import com.avh.Pages.LoginPage;
import com.avh.TestUtilities.Utilities;


public class LoginTest extends BaseTest{
	
	
	
	@Test (dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String>data ) throws InterruptedException  {
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		//ZohoAppPage zp = lp.doLogin("vponline123@icloud.com", "Testing@12345");
		//if using hashtable
		lp.doLogin(data.get("username"), data.get("password"));
		
		
		
		
		
		
		
	}
	
	

}
