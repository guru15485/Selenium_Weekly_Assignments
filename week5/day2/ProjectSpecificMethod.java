package week5.day2;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod 
{
	public ChromeDriver driver;
	@BeforeMethod
	@Parameters({"url"})
	public void perConditions(String url)
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		//Initialize the Chrome driver
	  	driver=new ChromeDriver(option);
	  	
		//login to the Salesforce website 
	  	driver.get(url);
	  	
	  	//maximize the browser
		driver.manage().window().maximize();
		
		//declare wait time to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}
	
	
  	
}
