package com.avh.Pages;

import org.openqa.selenium.By;
import com.avh.Base.PageBase;
import com.avh.Pages.crm.CRMHomePage;

public class ZohoAppPage extends PageBase{
	//WebDriver driver;
	//public ZohoAppPage(WebDriver driver) {
		//this .driver = driver;
	//}
	
	public void goToCliq() {
		driver.findElement(By.cssSelector(".zicon-apps-chat.zicon-apps-96")).click();
	}	
	public CRMHomePage goToCrm() {
		//driver.findElement(By.cssSelector(".zicon-apps-crm.zicon-apps-96")).click();
	//driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[6]/div[1]/a[1]/span[1]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'CRM')]")).click();
		click("goTOCrm__XPATH");
		return new CRMHomePage();
	}
    public void goToSales() {
    	driver.findElement(By.cssSelector(".zicon-apps-salesiq.zicon-apps-96")).click();
    }
    
    
}
