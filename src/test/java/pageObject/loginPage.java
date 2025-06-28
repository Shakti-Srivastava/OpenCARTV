package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


  @FindBy(xpath="//input[@id='input-email']")
  WebElement txtEmail;

 @FindBy(xpath="//input[@id='input-password']")  
 WebElement txtPswrd;

 @FindBy(xpath="//input[@value='Login']")  
 WebElement txtlogin;


 public void setemail(String email){
 txtEmail.sendKeys(email);
 }

 public void setpassword(String pswrd){

 txtPswrd.sendKeys(pswrd);
 }
 
 public void setlogin(){
 txtlogin.click();
 
 }
}