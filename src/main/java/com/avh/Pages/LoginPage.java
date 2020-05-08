package com.avh.Pages;

import com.avh.Base.PageBase;

public class LoginPage extends PageBase{
	//WebDriver driver;
	//public LoginPage(WebDriver driver)
	//{
	//this.driver = driver;
	//}
	
	public ZohoAppPage doLogin(String username,String password) throws InterruptedException {
		
		//driver.switchTo().frame("zohoiam");
		
	//driver.findElement(By.cssSelector("#1id")).sendKeys("username");
	//driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(username);
	 type("email__XPATH",username);
   //driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).submit();
     click("emailnextbtn__XPATH");
	//driver.findElement(By.cssSelector("#pwd")).click();
	//driver.findElement(By.cssSelector("#password")).sendKeys("password");
     Thread.sleep(5000);
	//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	type("password__XPATH",password);
	//driver.findElement(By.cssSelector("#submit_but")).click();
	//driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
	click("signbtn__XPATH");
	return new ZohoAppPage();
	}

   public void goToSalesAndMarketing() {
	
        }
  // public void() {
	   
  // }

}
