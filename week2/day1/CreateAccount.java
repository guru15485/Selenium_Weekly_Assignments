package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {
	/*
	 * this program is to interact with web elements like input fields and buttons
	 * using Selenium WebDriver
	 */
	public static void main(String[] args) {

		// initialize Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// maximize the brower
		driver.manage().window().maximize();

		// find the Username label elements text box field and enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		// find the passsword label elements text box field and enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// click the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// click on the hyperlink CRM/SFA
		driver.findElement(By.partialLinkText("CRM")).click();

		// click on the Account tab
		driver.findElement(By.linkText("Accounts")).click();

		// Click on the "Create Account" button.
		driver.findElement(By.linkText("Create Account")).click();

		// Enter an account name.
		driver.findElement(By.id("accountName")).sendKeys("Selenium2");

		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		// Enter a Number Of Employees.
		driver.findElement(By.id("numberEmployees")).sendKeys("100");

		// Enter a Site Name as “LeafTaps”
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");

		// Click the "Create Account" button.
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Verify that the Title is displayed correctly.
		String actualPageTitle = "Account Details | opentaps CRM";

		String pageTitle = driver.getTitle();

		System.out.println(pageTitle);

		if (pageTitle.equals(actualPageTitle)) {
			System.out.println("The page tiltle is correct");

		} else
			System.out.println("The page tilte is incorrect");

		// Close the browser window.
		driver.close();

	}

}
