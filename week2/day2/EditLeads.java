	package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLeads {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on the Login Button.
		driver.findElement(By.className("decorativeSubmit")).click();

		System.out.println("TestLeaf URL launched in Chrome browser successfully");
		System.out.println(driver.getTitle());
		
		// Click on the CRM/SFA Link.
		driver.findElement(By.partialLinkText("SFA")).click();
		System.out.println(driver.getTitle());
		
		// Click on the Leads Button.
		driver.findElement(By.linkText("Leads")).click();
		System.out.println(driver.getTitle());
		
		// Click on Create Lead.
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println(driver.getTitle());
		
		// Enter the CompanyName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Selenium Automation Tester");
		
		// Enter the FirstName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Guruthilak");
		
		// Enter the LastName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Ganesan");
		
		// Enter the FirstName (Local) Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Guru");
		
		// Enter the Department Field Using any Locator of Your Choice.
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Automation Testing");
		
		// Enter the Description Field Using any Locator of your choice.
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("TestLeaf-Automation Testing");
		
		// Enter your email in the E//mail address Field using the locator of your choice.
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("ganesan.guruthilak@gmail.com");
		
		// Select State/Province as NewYork Using Visible Text.
		WebElement stateFilter = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDDV = new Select(stateFilter);
		stateDDV.selectByVisibleText("New York");
		
		// Click on the Create Button.
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		// Click on the edit button.
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		// Clear the Description Field.
		
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		
		// Fill the Important Note Field with Any text.
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Notes updated in the Edit mode");
		
		// Click on the update button.
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		// Get the Title of the Result
		System.out.println(driver.getTitle());	

	}

}
