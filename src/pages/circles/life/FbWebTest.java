package pages.circles.life;

import org.testng.annotations.Test;

import Generic.ExcelData;
import facebook.pages.FacebookHome;
import facebook.pages.UserHomePage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class FbWebTest {
	
	public static WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeClass
	  public void Setup() throws IOException 
	
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","\\Circles\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		
		driver.get("https://www.facebook.com/");
		
		} 
	
	
@Test
public void login() throws Exception{
	//Get data from excel
		 ExcelData data = new ExcelData("\\Circles\\DataSheet\\ExcelData.xlsx");
		 String usrname = data.getCellData("Facebook", "UserName", 2);	
		 String pass = data.getCellData("Facebook", "Password", 2);	
		 
	log.debug("FB Web login");	 
	 FacebookHome f1 = new FacebookHome(driver);
	 f1.login(usrname, pass);
	
}

@Test(dependsOnMethods = { "login" })
public void postComment() throws Exception{
	//Get data from excel
	 ExcelData data = new ExcelData("\\Circles\\DataSheet\\ExcelData.xlsx");
	 String comment = data.getCellData("Facebook", "Comment", 2);	
	
	 log.debug("FB post comment");	
	UserHomePage uh1 = new UserHomePage(driver);
	uh1.postTestComment(comment);
	
}

  @AfterClass
  public void afterClass() {
	  log.debug("Close browser");
	  driver.close();
  }

}
