package com.avh.Rough;


import com.avh.Base.PageBase;
import com.avh.Pages.HomePage;
import com.avh.Pages.LoginPage;

import com.avh.Pages.ZohoAppPage;

public class LoginTest extends PageBase{

	public static void main(String[] args) throws InterruptedException {
		//this is a rough package
	//because we are declaring this in pagebase class
	//WebDriver driver = new FirefoxDriver();
    //System.setProperty("webdriver.chrome.driver",System.getProperty(("user.dir")+"/src/test/resources/executables/chromedriver"));
    //WebDriver driver = new ChromeDriver();
    //driver.get("http://zoho.com");
    
    //driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    HomePage home = new HomePage();
    //if u dont want to extend PageBase,then u hv to write this by giving driver reference
	//HomePage home = new HomePage(driver);
	home.goToLogin();
	
	LoginPage lp = new LoginPage();
	//login.doLogin("trainer@way2automation.com","Selenium@123");
	//lp.doLogin("vponline123@icloud.com","Testing@12345");
	lp.doLogin("username","password");
	
	ZohoAppPage zp = new ZohoAppPage();
	zp.goToCrm();
	PageBase.menu.gotoAccounts();
	//AccountsPage account = PageBase.menu.gotoAccounts();
	//CreateAccountPage cap = account.goToCreateAccounts();
	//cap.createAccount("hema");
	
	
	
	
}

}
