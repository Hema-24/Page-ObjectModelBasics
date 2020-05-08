package com.avh.Pages.crm;

import com.avh.Base.PageBase;
import com.avh.Pages.crm.accounts.AccountsPage;

public class CRMHomePage extends PageBase{
	
	
	public void verifyTextCRMHome() {
		
		
	}
	
	public AccountsPage goToAccounts() {
		//driver.findElement(By.linkText("Accounts")).click();
		click("goToAccounts_XPATH");
		//PageBase.menu.gotoAccounts()
		
		return new AccountsPage();
		
		
		
	}
	
}

