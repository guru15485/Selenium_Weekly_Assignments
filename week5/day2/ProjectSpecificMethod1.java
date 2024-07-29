package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod1 
{
	public ChromeDriver driver;
	@BeforeMethod
	@Parameters({"url","username","password"})
	public void perConditions(String url,String uname, String pswd)
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
		
		//enter the Username: dilip@testleaf.com
				driver.findElement(By.id("username")).sendKeys(uname);
				
				//enter the Password: testleaf@2024
				driver.findElement(By.id("password")).sendKeys(pswd);
	}
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}
	
	
  	
}
