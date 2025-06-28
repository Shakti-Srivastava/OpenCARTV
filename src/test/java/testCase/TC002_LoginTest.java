package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccount;
import pageObject.loginPage;
import testBase.baseClass;


@Test
public class TC002_LoginTest extends baseClass {
   
	public void verify_login()
	
	{
		logger.info("****Staring TC002 Login Test****");
		 
		try
		{
		HomePage hp= new HomePage(driver);
		
		hp.myaccount();
		hp.login();
		
		// login
		loginPage lp = new loginPage(driver);
		
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.setlogin();
		
		//MyAccount
		
		MyAccount mcc= new MyAccount(driver);		
		boolean targetPage=mcc.isMyAccountExist();
		
		 
		//Assert.assertEquals(targetPage, true,"login filed");
		Assert.assertTrue(targetPage);
	}
	
	catch (Exception e)
	{
		Assert.fail();
	}
		logger.info("****Finished TC002 Login Test****");

		
	}
	
}