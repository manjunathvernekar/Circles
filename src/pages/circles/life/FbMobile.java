package pages.circles.life;

import org.testng.annotations.Test;

import Generic.ExcelData;
import facebookMobile.FacebookMobileHome;
import facebookMobile.UserProfilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class FbMobile {
	 
	//Create Instance for appium driver 
		AppiumDriver<WebElement> driver;
		Logger log = Logger.getLogger("devpinoyLogger");
		
	@BeforeClass
	  public void Setup() throws MalformedURLException{
		  DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.facebook.katana");	
		 cap.setCapability(MobileCapabilityType.APP, "D:\\FB.apk");
		  cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus");
		cap.setCapability("appWaitActivity", "com.facebook.katana.LoginActivity");	
		  cap.setCapability("deviceName", "Android emulator");
		  
	
		  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  }
	  	
  @Test
  public void loginMobile() throws Exception {	  
	//Get data from excel
		 ExcelData data = new ExcelData("\\Circles\\DataSheet\\ExcelData.xlsx");
		 String usrname = data.getCellData("Facebook", "UserName", 2);	
		 String pass = data.getCellData("Facebook", "Password", 2);	
		
	log.debug("Login in Fb mobile app ");
	  FacebookMobileHome fm1 = new FacebookMobileHome(driver);
	  fm1.login(usrname, pass);
  }
  
  @Test(dependsOnMethods = { "loginMobile" })
  public void verifyComment() throws Exception {	  
	//Get data from excel
		 ExcelData data = new ExcelData("\\Circles\\DataSheet\\ExcelData.xlsx");
		 String comment = data.getCellData("Facebook", "Comment", 2);	
		 log.debug("Verify posted comment");	 
	  UserProfilePage up1 = new UserProfilePage(driver);
	  up1.verifyPost(comment);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
