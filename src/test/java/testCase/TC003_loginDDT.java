  package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccount;
import pageObject.loginPage;
import testBase.baseClass;
import utilities.DataProviders;

                                                                      // getting data provider from different class
@Test(dataProvider="Logindata", dataProviderClass=DataProviders.class) // Login data is data provider which is present inside the DataProviders classin utility

public class TC003_loginDDT extends baseClass 
{
	
	public void verify_LoginDDT (String email,String pwd, String exp)
	
	{
		try 
		{
		
		logger.info("*** Starting TC003 Login test***");
	
	HomePage hp= new HomePage(driver);
	
	hp.myaccount(); 
	hp.login();
	
	// login
	loginPage lp = new loginPage(driver);
	
	lp.setemail(email);
	lp.setpassword(pwd);
	lp.setlogin();
	
	//MyAccount
	
	MyAccount mcc= new MyAccount(driver);		
	boolean targetPage=mcc.isMyAccountExist();   
	
	if (exp.equalsIgnoreCase("Valid"))// data is valid
		
	{
		if(targetPage==true)          //login is successful
		{
			mcc.logout();

			Assert.assertTrue(true); //data valid and login successful then test is pass
		}
		else 
		{
			Assert.assertTrue(false);   //data valid but login unsuccessful then test is fail
				
		}
		if (exp.equalsIgnoreCase("Invalid"))   
			
		{
			if(targetPage==true)                //data invalid but login successful then test is fail
			{ 
				mcc.logout();
            Assert.assertTrue(false);
			}
            else
            {
                Assert.assertTrue(true);         //data invalid but login unsuccessful then test is pass 

            }
				
		}
		
	
	}}
		
	catch(Exception e) 
		
		{
		Assert.fail();
		}
		logger.info("*** TC003 Logintest complete***");

	}
		
	
		
	}
	

