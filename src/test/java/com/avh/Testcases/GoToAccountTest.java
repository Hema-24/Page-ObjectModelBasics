package com.avh.Testcases;

import org.testng.annotations.Test;


import com.avh.Pages.ZohoAppPage;
import com.avh.Pages.crm.CRMHomePage;
import com.avh.Pages.crm.accounts.AccountsPage;




public class GoToAccountTest {
	
	//@Test(dataProviderClass = Utilities.class , dataProvider = "dp")
	//public void goToAccountTest(Hashtable<String,String>data) {
		
	 @Test
	 public void goToAccountTest()  {
		
		ZohoAppPage zp = new ZohoAppPage();
		CRMHomePage crm   =  zp.goToCrm();
		AccountsPage account = crm.goToAccounts();
		account.goToEdit();

		
		//CRMHomePage crm = new CRMHomePage ();
		//AccountsPage account =  new AccountsPage();
		//crm.goToAccounts();
		//menu.gotoAccounts();
	
		//AccountsPage account = new AccountsPage();
		//account.goToEdit();
		
		}
	

}
