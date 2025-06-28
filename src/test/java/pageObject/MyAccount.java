package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement txtaccount;
	
	@FindBy(xpath = "//*[@class='list-group-item'][13]")
	WebElement txtlogout;
	
	public boolean isMyAccountExist()
	
	{ 
		try
		{
			return (txtaccount.isDisplayed());
		}
		
			catch (Exception e)
			{
				return false;
			}
		}
	public void logout()
	{
		txtlogout.click();
	}
	}
	 

	
	
