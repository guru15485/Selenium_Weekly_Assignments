package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForcewithDynamicParameters {
	@Test(dataProvider="sendData")

	public void salesForceStaticInput(String entityName) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

//		 Initialize the Chrome driver
		 ChromeDriver  driver=new ChromeDriver(option);

		// login to the Salesforce website
		driver.get("https://login.salesforce.com/");

		// maximize the browser 
		driver.manage().window().maximize();

		// declare wait time to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter the Username: dilip@testleaf.com
		driver.findElement(By.id("username")).sendKeys("guru@seleniumjava.com");

		// enter the Password: testleaf@2024
		driver.findElement(By.id("password")).sendKeys("June#062024");
		driver.findElement(By.id("Login")).click();

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

//		Set<String> windows = driver.getWindowHandles();
//		List<String> windowList=new ArrayList<String>(windows);
//		driver.switchTo().window(windowList.get(1));
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		WebElement legalEnt = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		act.moveToElement(legalEnt).click().perform();

		// Click on the Dropdown icon in the legal Entities tab
//		driver.findElement(By.xpath("//a[@title='Legal Entities']/following::div")).click();

		// Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();	
//		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left_none slds-p-right_x-small']")).click();
		
		//Click on New Legal Entity
//		Thread.sleep(3000);
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		WebElement newLegalEntity = driver.findElement(By.xpath("(//span[@class='slds-truncate'])[10]"));
//		jse.executeScript("arguments[0].scrollIntoview;", newLegalEntity);
		driver.findElement(By.xpath("//span[@class='slds-truncate']//span")).click();
		
		//Enter the Legal entity name
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(entityName);
		
		//Click Save button
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		// verify Legal Entity Name
		String actualMsg = driver.findElement(By.xpath("//span[@class='test-id__field-label' and text()='Legal Entity Name']/following::span[1]")).getText();
		String expectedMsg = "Salesforce Automation by Guru";

		if (actualMsg.contains(expectedMsg)) {
			System.out.println("The Legal Entity Name is verified");
		} else {
			System.out.println("The Legal Entity Name is not verified");
		}
		driver.close();
	}
		
		@DataProvider
		public String[][] sendData()
		{
			String [][] data=new String[2][1];
			data[0][0]="T1_Salesforce Automation by Guru";
			
			data[1][0]="T2_Salesforce Automation by Guru";			
			return data;
		}

	}
