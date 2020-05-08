package com.avh.Testcases;

import org.testng.annotations.AfterSuite;

import com.avh.Base.PageBase;

public class BaseTest {
	
	@AfterSuite
	public void tearDown() {
		PageBase.quit();
	}

}
