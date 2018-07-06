package facebook.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
WebDriver driver;
Logger log = Logger.getLogger("devpinoyLogger");

	@FindBy(xpath="//a[@href='https://www.facebook.com/?ref=logo']")
	public WebElement fbLogo;
	
	@FindBy(xpath="//div[@role='textbox']")
	public WebElement postTextField;
	
	@FindBy(xpath="//a[@data-attachment-type='STATUS']")
	public WebElement composePost;
	
	@FindBy(xpath="//button[@data-testid='react-composer-post-button']")
	public WebElement postButton;
	
	
	
 public UserHomePage(WebDriver driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);	    
 }
 
 
public void postTestComment(String posttext) throws InterruptedException 
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	log.debug("Click on FB logo");
	fbLogo.click();
	log.debug("compose post");
	composePost.click();
	postTextField.sendKeys(posttext);
	log.debug("click on post button");
	postButton.click();

}
}
