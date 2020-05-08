package com.avh.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.avh.Base.PageBase;

public class HomePage extends PageBase{
	//If u don't want to extend pagebase then u hv to write like this
	//WebDriver driver;
	//public HomePage (WebDriver driver) {
	//this.driver= driver;
	//}
	public void goToSupport() {
		
		driver.findElement(By.cssSelector(".signing>a:nth-child(2)")).click();
		
	}
    public void goToSignUp() {
    	
    	driver.findElement(By.cssSelector(".signup")).click();
	
	}
	public LoginPage goToLogin() {
		
		//driver.findElement(By.cssSelector(".signin")).click();
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
		click("loginlink__XPATH");
		
		return new LoginPage();
	}
	public void goToZohoEdu() {
		
	}
	public void goToLearnMore() {
		
	}
	public void validateFooterLinks() {
		
	}
	
	
	
	

}
