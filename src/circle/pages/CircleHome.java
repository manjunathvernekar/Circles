package circle.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CircleHome {
	
	Logger log = Logger.getLogger("devpinoyLogger");
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Get a new number')]")
	public WebElement signIn;
	
	@FindBy(xpath="//input[@type='text'][@name='email']")
	public WebElement emailId;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement pass;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	public WebElement signInButton;
	
	@FindBy(xpath="//div[contains(text(),'MY ACCOUNT')]/..")
	public WebElement myAccount;
	
	
	
 public CircleHome(WebDriver driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);	    
 }
 
 
public void login(String userName, String password) 
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	log.debug("Clicking on sign in button");
	signIn.click();
	log.debug("Sending user name");
	emailId.sendKeys(userName);
	log.debug("Sending password");
	pass.sendKeys(password);
	log.debug("Click on proceed button");
	signInButton.click();

}
	 
	 
}
