package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.baseClass;

public class ExtentReportManager implements ITestListener

{
  public ExtentSparkReporter sparkReporter;
  public ExtentReports extent;
  public ExtentTest test;
  
   String repName;
   
   
   public void OnStart(ITestContext testcontex) // it will execute only once before starting all the test
   
    
   {
	   // time stamp
	   
	   String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); 
	   //every time run the testcase new report will generated so we can maintain the history of report
	   
	   repName= "Test-Report-" +timeStamp+ ".html";
	   
	   sparkReporter= new ExtentSparkReporter("\\.reports"+repName); // Specify location of the report and .\\ represent the current project location 
	   
	   sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // title of the report
       sparkReporter.config().setReportName("Pet Store User API");  //name of the report
       sparkReporter.config().setTheme(Theme.DARK);
	   
       
       extent = new ExtentReports();
       extent.attachReporter(sparkReporter);
       extent.setSystemInfo("Applicatio", "Pet Store User API");
       extent.setSystemInfo("Operation System",System.getProperty("os.name"));
       extent.setSystemInfo("User Name", System.getProperty("user.name"));
       extent.setSystemInfo("Environment", "QA");
       extent.setSystemInfo("user", "Shakti");
   }
   
   public void OnTestSuccess(ITestResult result)
       
   {
	   test=extent.createTest(result.getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.createNode(result.getName());
	   test.log(Status.PASS, "Test Passed");
			   
}
  public void OnTestFailure(ITestResult result)  
  
  {
	  test=extent.createTest(result.getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.FAIL, "Test Failed");
	   test.log(Status.FAIL, result.getThrowable().getMessage());
	   
	   try {
		   
		   String imgPath= new baseClass().TakeScreenshot(result.getName());
		   test.addScreenCaptureFromPath(imgPath);
	   }
	   catch(IOException e1)
	   
	   {
		  e1.printStackTrace(); // show exception message
	   }}
  
  public void OnTestSkipped(ITestResult result)
  {
	  test=extent.createTest(result.getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.SKIP, "Test Skip");
	   test.log(Status.SKIP, result.getThrowable().getMessage());
	  }
	   
  public void OnFinish(ITestContext testContext)
  
  {
	  extent.flush(); 
	  
  }
	   
	   
   }
	
	

