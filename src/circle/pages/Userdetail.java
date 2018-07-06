package circle.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Userdetail {

	Logger log = Logger.getLogger("devpinoyLogger");
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'MY ACCOUNT')]/..")
	public WebElement myAccount;
	
	@FindBy(xpath="//label[contains(text(),'Email')]/../div/input")
	public WebElement userEmail;
	
	String mail;
	
	
 public Userdetail(WebDriver driver){
		 	this.driver = driver;
		 	PageFactory.initElements(driver, this);
	    
	 }
 
public void verifyUserEmail(String userName) 
{	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	log.debug("Click on My Account");
	myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'MY ACCOUNT')]/..")));
	myAccount.click();
	mail = userEmail.getAttribute("value").toString();
	log.debug("Verify user email");
	assertEquals(mail, userName,"email address do not match");
	
	
}
	
}
