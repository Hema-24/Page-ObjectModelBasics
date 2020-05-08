package com.avh.Base;


import com.avh.Pages.crm.accounts.AccountsPage;



public class TopMenu extends PageBase{
	
	/*
	 * Home Page Has a TopMenu
	 * Accounts page has a Top Menu
	 * 
	 * 
	 */
	
	public void gotoHome() {
		
	}
    public void gotoFeeds() {
		
	}
    public void gotoLeads() {
		
	}
    public AccountsPage gotoAccounts() {
    	
    	click("goToAccounts_XPATH");
		return new AccountsPage() ;
		
    
		}
    
	public void gotoContacts() {
		
	}
    public void gotoDeals() {
		
	}
    public void gotoActivities() {
		
	}
    public void gotoMarketplace() {
		
	}



    
 




}
