package week5.day2;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SalesForcewithStaticParameters extends ProjectSpecificMethod1 {
	@Test
	@Parameters({ "username", "password" })
	public void salesForceStaticInput(String uname, String pswd) throws InterruptedException {

		// enter the Username: dilip@testleaf.com
		driver.findElement(By.id("username")).sendKeys(uname);

		// enter the Password: testleaf@2024
		driver.findElement(By.id("password")).sendKeys(pswd);
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

		// Click on New Legal Entity
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();	
		driver.findElement(By.xpath("//div[text()='New']")).click();

//
//		Set<String> windows = driver.getWindowHandles();
//		List<String> windowList=new ArrayList<String>(windows);
//		driver.switchTo().window(windowList.get(1));

		// Enter the Company name as 'TestLeaf'.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");

		// Enter Description as 'Salesforces'.
		WebElement desField = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		desField.sendKeys("Salesforces");

		// Select Status as 'Active'
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement status = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		jse.executeScript("arguments[0].scrollIntoView();", status);

//		driver.findElement(By.xpath("//button[@aria-label='Status']")).click();
//		driver.findElement(By.xpath("//span[@class='slds-media__body']//span[@title='Active']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// Verify the Alert message (Complete this field) displayed for Name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))).getText();
		String expectedMsg = "TestLeaf";

		if (actualMsg.contains(expectedMsg)) {
			System.out.println("The alert message is verified");
		} else {
			System.out.println("The alert message is not verified");
		}

	}
}
