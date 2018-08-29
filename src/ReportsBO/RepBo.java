package ReportsBO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class RepBo {
	
	WebDriver driver;
	@FindBy(xpath="//a//span[contains(@id, 'gvCategoryWise_lblAreaCatCode')]")
	public WebElement row;
	
	
	public void ClickRow() 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row.click();


	}	


}
