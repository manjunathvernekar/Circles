package pages.circles.life;

import org.testng.annotations.Test;

import Generic.ExcelData;

import circle.pages.CircleHome;
import circle.pages.Userdetail;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class CirclesTestCaller {
	
	public static WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeClass
	  public void Setup() throws IOException 
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","D:\\Circles\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		
		log.debug("opening webiste");
		driver.get("https://pages.circles.life/");
		
		} 
	
	
 @Test
  public void login() throws Exception{
	 //Get data from excel
	 ExcelData data = new ExcelData("D:\\Circles\\DataSheet\\ExcelData.xlsx");
	 String usrname = data.getCellData("Circles", "UserName", 2);	
	 String pass = data.getCellData("Circles", "Password", 2);	
	 
	 log.debug("Calling circle login");
	 CircleHome cl = new CircleHome(driver);
	 cl.login(usrname, pass);
	
 }
 
 @Test(dependsOnMethods = { "login" })
 public void verifyEmail() throws Exception{
	 //Get data from excel
	 ExcelData data = new ExcelData("\\Circles\\DataSheet\\ExcelData.xlsx");
	 String usrname = data.getCellData("Circles", "UserName", 2);
	 
	 log.debug("Verify user email call");
	 Userdetail ud = new Userdetail(driver);
	 ud.verifyUserEmail(usrname);
}
 
  @AfterClass
  public void afterClass() {
	  log.debug("Close browser");
	  driver.close();
  }

}
