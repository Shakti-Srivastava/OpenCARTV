package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.baseClass;

public class tc01_AccountRegistrationPage extends baseClass {
	 
	
	
	@Test
	public void verify_account_registration() 
	  {
		
		
		 logger.info("****Starting the signup****");
		  try { 
			  
		  
		  HomePage hp=new HomePage(driver);
		  
		  hp.myaccount();
		  hp.Register();
		  
		  AccountRegistrationPage regpage =new AccountRegistrationPage(driver); 
		  
		 logger.info("**providing customer details**");
		  
		  regpage.SetFirstName(randomString().toUpperCase());
		  regpage.SetLastName(randomString().toUpperCase());
		  regpage.SetUserEmail(randomString()+"@gmail.com");
		  regpage.Settelephn(randomNumeric());
		  
		  String pswrd= randomAlphaNumeric();   // it will always change if we have confirm pswrd then it will get failes
				  
		  regpage.SetPassword(pswrd);                    
		  regpage.conPassword(pswrd);
		  regpage.checkpolicy();
		  regpage.continuebutton();

          logger.info("**validating excepted result**");
          String confirmmsg=regpage.getconfirmation();                            
          
          Assert.assertEquals(confirmmsg,"Your Account Has Been Created!"); 
		   
		  
		}
	  catch (Exception e) 
		  {
		  
		  logger.error("Test failded");
		  logger.debug("debug logs");
		  Assert.fail();
		  
	  }
	   
}}
