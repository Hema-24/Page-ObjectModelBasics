package com.avh.TestUtilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.avh.Base.PageBase;

//it is same like Testutil class
public class Utilities extends PageBase{
	
public static String screenshotPath;
public static String screenshotName;

public static void captureScreenshot() throws IOException	{

	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Date d=new Date();
	d.toString();
	//screenshotName="error.jpg";
	screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/target/surefire-reports/html/"+screenshotName));
	
	
}

     @DataProvider(name="dp")
     public Object[][]getData(Method m){
	
	
	  String sheetName=m.getName();
    int rows= excel.getRowCount(sheetName);
    int cols= excel.getColumnCount(sheetName);

   // Object[][] data = new Object[rows-1][cols];
    //for paramterization(Hashtable, for each row we r creating a hashtable), changing the cols to 1
    Object[][] data = new Object[rows-1][1];
    Hashtable<String,String>table = null;
    
    for (int rowNum =2; rowNum<=rows;rowNum++){
    	table = new Hashtable< String,String >() ;
	
   for(int colNum =0;colNum<cols;colNum++) {
   //data[][]	
    // data[rowNum-2][colNum]= excel.getCellData(sheetName,colNum,rowNum);
     table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
     data[rowNum-2][0]= table;
	}

}
return data;


}
     public static boolean isTestRunnable(String testname, ExcelReader excel) {
    	 
		String sheetName="test_suite";
    	int rows = excel.getRowCount("sheetName");
    	
    	for (int rNum=2; rNum<=rows; rNum++) {
    	
    	excel.getCellData(sheetName, "TCID", rNum);
    	
    	
    	 String testcase = excel.getCellData(sheetName, "TCID", rNum);
    	 
    	 if(testcase.equalsIgnoreCase(testname)) {
    		 
    	 }
    		 excel.getCellData(sheetName, "Runmode", rNum);
    		 String runmode = excel.getCellData(sheetName, "Runmode", rNum);
    		 
    		 if (runmode.equalsIgnoreCase("Y")) 
    			 return true;
    			 
    		 else
    			 return false;
    	 }
		return false;
    	 
    	 }

}

