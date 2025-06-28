package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	 
	@FindBy(xpath="//input[@id='input-firstname']")
			WebElement txtFirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@name='telephone']")
	WebElement txttelephn;
	
	
	@FindBy(xpath="//input[@id='input-password']")  
	WebElement txtPswrd;
	
	@FindBy(xpath="//input[@id='input-confirm']")  
	WebElement conPswrd;
	
	
	@FindBy(xpath="//input[@name='agree']")  
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")  
	WebElement continuebttn;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")  
    WebElement msgconfirmation;
	
	
   public void SetFirstName(String fname)
	
	{
		txtFirstName.sendKeys(fname);
	}
   public void SetLastName(String lname)
	
	{
		txtLastName.sendKeys(lname);
	}
   public void SetUserEmail(String usereamil)
	
	{
		txtEmail.sendKeys(usereamil);
	}
   
   public void Settelephn(String userphn)
	
	{
		txttelephn.sendKeys(userphn);
	}
  
   public void SetPassword(String psword)
	
	{
		txtPswrd.sendKeys(psword);
	}
   
   public void conPassword(String psword)
	
	{
		conPswrd.sendKeys(psword);
	}
   
   public void checkpolicy()

   {
	   chkpolicy.click();   
	   
   }
   
   public void continuebutton()

   {
	   continuebttn.click();   
	   
   }
  
   
   public String getconfirmation() 
   {
	
	try {
	    return (msgconfirmation.getText()); 
	    }
	
	catch (Exception e) 
	
	   {
		return (e.getMessage());
	    }
		
	}

}


