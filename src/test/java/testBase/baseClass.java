package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {
	
public WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"}) 
	
	//public void setup() throws IOException
	public void setup(String os,String br) throws IOException    // run tests on desired browser
	
	{ 
		//Loading config properties file
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);   // capture the date from file
		
	    logger=LogManager.getLogger(this.getClass());  //log4j2
	    
	    
	    // selenium grid
	    
	    if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	    	
	    {
	    	DesiredCapabilities cap= new DesiredCapabilities();
	    	// for grid os
           if(os.equalsIgnoreCase("windows"))	
        	   
           {
        	   cap.setPlatform(Platform.WIN11);
           }
           else if(os.equalsIgnoreCase("mac"))
        	   
        	{
        	   cap.setPlatform(Platform.WIN11);
           }
           else
           {
        	   System.out.println("No matching browser");
        	   return;
           }
           
           switch(br.toLowerCase())
           {
           case "chrome": cap.setBrowserName("chrome"); break;
           case "edge": cap.setBrowserName("MicrosoftEdge"); break;
           default:System.out.println("No matching browser");return;
           }
           
           driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
           
	    }
	    if(p.getProperty("execution_env").equalsIgnoreCase("local"))

	    {
	    
		switch(br.toLowerCase())                          
		{
		case "chrome" :  driver=new ChromeDriver();break;    //// run tests on desired browser
		case "firefox" : driver=new FirefoxDriver();break;
		case "edge"  : driver=new EdgeDriver();break;
		default :System.out.println("Invalid browser"); return;   // if browser is invalid other method will not execute
		}
	 }
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("url"));       //reading url from properties file
		driver.manage().window().maximize();
		
		}
	
	@AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
	public String randomString()
	   {
		   String generatedString=RandomStringUtils.randomAlphabetic(5);
		   return generatedString;
		   
	   }

	   public String randomNumeric()
	   {
		   String generatedNumber=RandomStringUtils.randomAlphabetic(10);
		   return generatedNumber;
		   
	   }
	   public String randomAlphaNumeric()
	   {
		   String generatedString=RandomStringUtils.randomAlphabetic(5);
		   String generatedNumber=RandomStringUtils.randomAlphabetic(3);
		   return generatedString+"@"+generatedNumber;

		 }
	   public String TakeScreenshot(String tname) throws IOException
	   {
		       String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());	
                
		        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		        String targetFilePath=System.getProperty("user.dir")+"\\screenShot\\"+ tname + " "+  timestamp  ;
		        File targetFile=new File(targetFilePath);
		        
		        screenshotFile.renameTo(targetFile);
		            
				return targetFilePath;}
}
