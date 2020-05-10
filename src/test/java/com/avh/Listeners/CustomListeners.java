package com.avh.Listeners;

 
import java.io.IOException;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.avh.Base.PageBase;
import com.avh.TestUtilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

//to capture and add screenshot for failed testcase,we will add listeners customlisteners(itestlisteners)
//to capture and add screenshot for failed testcase,we will add listeners customlisteners(itestlisteners)


public class CustomListeners extends PageBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		//this is for extent reports,we have extended testbase for extent reports
		test= rep.startTest(result.getName().toUpperCase());
		//runmodes =Y
		//if(!TestUtil.isTestRunnable(result.getName(), excel)) {
		//	throw new SkipException("Skipping the test" + result.getName().toUpperCase()+" as the runmode is No");
		//}
		//
	}

	public void onTestSuccess(ITestResult result) {
		
		//TestBase.test.log(LogStatus.PASS,result.getName().toUpperCase()+ "PASS");
		//this for extent reports,we have extendsed testbase for extent reports
		test.log(LogStatus.PASS,result.getName().toUpperCase()+ "PASS");
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		
		// TODO Auto-generated method stub
		
       System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		// TODO Auto-generated method stub
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//for extent reports 
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+"Failed with exception:"+ result.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
		rep.endTest(test);
		rep.flush();
		
		Reporter.log("Capturing screenshot");
		//Reporter.log("<a href=\"abcd.jpg\">Screenshot</a>");
		//to see it reporter links in html view
		
		Reporter.log("Click to see Screenshot");
		//to open link in a new tab
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		
		//for adding thumbnail of screenshots
		//Reporter.log("<a target =\"_blank\" href=\"abcd.jpg\"><img src ="path of image"></img></a>");
		//for adding thumbnail of screenshots
		Reporter.log("<a target =\"_blank\" href="+Utilities.screenshotName+"><img src ="+Utilities.screenshotName+" height=200 width = 200> </img></a>");
		
		//to capture and add screenshot for failed testcase,we will add listeners customlisteners(itestlisteners)
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+ "Skipped the test as the run mode is No");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
	//	MonitoringMail mail = new MonitoringMail();
		//try {
			//messageBody = "http://"+ InetAddress.getLocalHost().getHostAddress()+ ";8080/job/PageObjectModelBasics/Extent_Report/";
		//address in jenkins address bar
		//}catch (UnknownHostException e) {
		//	e.printStackTrace();
		//}
		
		
		
	
		
	}
	
	

}
//System.setProperty("org.uncommons.reportng.escape-output", "false");
//TestUtil.captureScreenshot();
//Reporter.log("Capturing screenshot");
//Reporter.log("Click to see Screenshot");
//Reporter.log("<a target =\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
//Reporter.log("<br>");
//Reporter.log("<br>");
//Reporter.log("<a target =\"_blank\" href="+TestUtil.screenshotName+"><img src ="+TestUtil.screenshotName+"> </img></a>");




