package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	
	{
		super(driver);
	}
  
	
	@FindBy(xpath="//*[@title='My Account']")
	  WebElement myaccount;
	
  @FindBy(xpath="//*[text()='Register']")
  WebElement lnkRegister;
   
  @FindBy(xpath="//*[text()='Login']")
  WebElement login;

	public void myaccount() 
	
	{
		myaccount.click();
	}
  
	public void Register() 
	
	{
		lnkRegister.click();
	}
   public void login() 
	
	{
		login.click();
	}
	
}
