package facebookMobile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FacebookMobileHome {

	
WebDriver driver;
Logger log = Logger.getLogger("devpinoyLogger");

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email or Phone']")
	public WebElement userMobileEmail;
	
	@FindBy(xpath="//android.widget.EditText[@index='2']")
	public WebElement userMobilePassword;
	
	@FindBy(xpath="//android.widget.Button[@text='LOG IN']")
	public WebElement logInMobile;
	
	
	
 public FacebookMobileHome(AppiumDriver<WebElement> driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);	    
 }
 
 
public void login(String userName, String password) 
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	log.debug("Enter user name");
	userMobileEmail.sendKeys(userName);
	log.debug("Enter password");
	userMobilePassword.sendKeys(password);
	log.debug("Click on login button");
	logInMobile.click();

}
	 
}
