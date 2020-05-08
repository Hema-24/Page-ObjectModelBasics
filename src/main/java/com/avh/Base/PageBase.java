package com.avh.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.avh.TestUtilities.ExcelReader;
import com.avh.TestUtilities.ExtentManager;
import com.avh.TestUtilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/* WebDriver       -done
 * Properties      -done
 * Logs            -log4j.jar(maven dependency)
 *                 -Two log files(application log and selenium logs)
 *                 -log4j.properties file(standard file provided by apache that contains log4j appenders,copy and paste it in your test source folder.it contains the path of your application and selenium log files,just change the path ,give the files path)
 *                 -Logger class(public static Logger log = Logger.getLogger("devpinoyLogger")in your base class
 * Assertions      -create assert(isElementPresent() and use it in testcases) method and all other methods in base class so that we will be able to access those methods in child classes as well.         
	
 * Excel           -Excelreader file in utilities,in testbase(public static ExcelReader excel = new ExcelReader("User.dir"+"/src/test/resources/excel/TestData.xlsx"),dataproviders in testcase
 * ReportNG        -add dependency in pom.xml(reportNG,google guice),add listeners in testNG.xml;
 * Reporter.log    -test method in testNG to log messages,links and screenshots
 * TestNG ITestListeners -For failed testcase,we use listeners for screenshots etc.
 * DB
 * ExtentReports ---create ExtentManager class in testUtilities,then in base class create object of extentreports-->public ExtentReports rep = ExtentManager.getInstance();
 * set up of runmode for test suites--so that we can run the testcase we want to run--not done yet
 * Hashtable set up for dataproviders so that we dont have to write string parameters in "DP"--not done yet
 * Mail
 * integrating it with execution from Jenkins for scheduling our test
 * for jenkins ,first download it-new item-give job name-in the build give pom.xml add-save-click on build to start
 * for jenkins report(if we want to see it in jenkins tool we hv to download htmlpublisher pligin for extentreports)
 * for jenkins html reports in windows - java -Dhundson.model.Directorysupport.csp="" -jar jenkins.war,in the terminal
 * For common dataprovider-- so that u dont hav to write the code again and agian we make a method in Test util class
 * For runmodes -- create a method in testutil class and add it to custom listeners or directly to the testcase 
 * For parameterization--we do hashtable(in Testutil class) so that we dont hv to write parameters in DP again and again
 */


public class PageBase {
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/excel/TestData_POMBasics.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
     public static TopMenu menu;
     
	
    
    
    
    public PageBase() {
    	
    	  
    if(driver==null) {
    	
    	//For taking properties form property and confi files
    	try {
    		
    		fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
    	
    		} catch(FileNotFoundException e) {
    			e.printStackTrace();
    		}
    		try {
    			config.load(fis);
    			log.debug("config file loaded !!!");
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    		
    		 try {
    			fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
    		 
    		try {
    			OR.load(fis);
    			
    			log.debug("OR file loaded !!!!");
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    		
    		//for jenkins  browser filter configuration enviorment 
    		if(System.getenv("browser")!=null && ! System.getenv("browser").isEmpty()) {
    			browser= System.getenv("browser");
    		}else {
    			browser= config.getProperty("browser");

    		}
    		config.setProperty("browser", browser);
    		
    		
    		if(config.getProperty("browser").equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Executables/geckodriver");
    		driver=new FirefoxDriver();
    		}
    		
    		else if(config.getProperty("browser").equals("chrome")) {
    		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Executables/chromedriver");
    			driver=new ChromeDriver();
    			log.debug("chrome Launched !!!");
    			
    		}
    		driver.get(config.getProperty("testsiteurl"));
    		log.debug("Navigated to :"+config.getProperty("testsiteurl"));
    		//driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
    		wait = new WebDriverWait(driver,5);
    		menu = new TopMenu();
    		}
    
         //driver = new FirefoxDriver();
    //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver");
  //  driver = new ChromeDriver();
   // driver.get("http://zoho.com");
   //driver.manage().window().maximize();
   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // wait =new WebDriverWait(driver,10);
   // menu = new TopMenu();
    	  }
    
    public static void quit() {
    	driver.quit();
    }
    
    
 // keyword click method
 	public static void click(String locator) {
 		if(locator.endsWith("_CSS")) {
 		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
 		}
 		else  if(locator.endsWith("_XPATH")) {
 	driver.findElement(By.xpath(OR.getProperty(locator))).click();
 	}
 		else if(locator.endsWith("_ID")) {
 		driver.findElement(By.id(OR.getProperty(locator))).click();
 		}
 	test.log(LogStatus.INFO, "Clicking on : "+locator);
 		}
 	
 	
 	  // keyword - type method
 	public void type(String locator,String value) {
 		
 		if(locator.endsWith("_CSS")) {
 			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
 		test.log(LogStatus.INFO, "typing in :"+ locator+"entered value as"+ value);
 		}else  if(locator.endsWith("_XPATH")) {
 			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
 		}else if(locator.endsWith("_ID")) {	
 			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
 		}
 		}
 	  //keyword - method dropdown
 		static WebElement dropdown;
		
 		
 		public void select(String locator,String value) {
 			
 			if(locator.endsWith("_CSS")) {
 				dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
 			}else  if(locator.endsWith("_XPATH")) {
 				dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
 			}else if(locator.endsWith("_ID")) {	
 				dropdown = driver.findElement(By.id(OR.getProperty(locator)));
 			
 			
 			Select select = new Select(dropdown);
 			select.selectByVisibleText(value);
 			}
 			
 			//test.log(LogStatus.INFO, "typing in :"+ locator+"entered value as"+ value);
 			test.log(LogStatus.INFO, "selecting from dropdown :"+ locator+"entered value as"+ value);
 			
 				
 		}
 		
 	
 	
 	
 		//iselementpresent method
 		
 		public boolean isElementPresent(By by) {
 		try {
 		driver.findElement(by);	
 			return true;
 		}catch(NoSuchElementException e) {
 			return false;
 		}
 	}
 	
 	//instead of writing try and catch bock for every testcase,we can create a method for failed testcase in testbase to generate report in extent reports
 	// for failed teeestcases we hv itestlisteners in testng but for extent reports, wwe are creating a method so that we dont hv to write soft assertions each time.
 	//Adding multiple failures to the test
 	
 	public static void verifyEquals(String expected,String actual) throws IOException {
 		try {
 		Assert.assertEquals(actual, expected);
 	   }catch(Throwable T) {
 		Utilities.captureScreenshot();
 		
 		//for reporting in reportNG
 		Reporter.log( "<br>"+ "Verification failure : "+ "t.getMessage():"+ "<br>");
 		Reporter.log("<a target =\"_blank\" href="+Utilities.screenshotName+"><img src ="+Utilities.screenshotName+" height=200 width = 200> </img></a>");
 		Reporter.log( "<br>");
 		Reporter.log( "<br>");
 		
 		//For reporting in Extent Reports
 		test.log(LogStatus.FAIL,"Verification failed with exceptionresult :"+ "t.getMessage()");
 		test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
 		
 		
 		
 	}
 	
 	}
 	
    
      }
    	  
    	  

