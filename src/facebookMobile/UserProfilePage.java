package facebookMobile;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UserProfilePage {
	
	
WebDriver driver;
Logger log = Logger.getLogger("devpinoyLogger");

	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.facebook.katana:id/feed_story_message' and @index='6']")
	public WebElement postedMessage;
	
public String message;
	
 public UserProfilePage(AppiumDriver<WebElement> driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);	    
 }
 
 
public void verifyPost(String posttext) 
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	message = postedMessage.getAttribute("content-desc").toString();
	log.debug("Verifu the message posted");
	assertEquals(message, posttext, "comment not posted");

}

}
