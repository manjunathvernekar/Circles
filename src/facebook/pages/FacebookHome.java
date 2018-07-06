package facebook.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHome {
	
WebDriver driver;
Logger log = Logger.getLogger("devpinoyLogger");

	@FindBy(id="email")
	public WebElement userEmail;
	
	@FindBy(id="pass")
	public WebElement userPassword;
	
	@FindBy(xpath="//input[@data-testid='royal_login_button']")
	public WebElement logIn;
	
	
	
 public FacebookHome(WebDriver driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);	    
 }
 
 
public void login(String userName, String password) 
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	log.debug("Enter username");
	userEmail.sendKeys(userName);
	log.debug("Enter password");
	userPassword.sendKeys(password);
	log.debug("Click on login");
	logIn.click();

}
	 

}
