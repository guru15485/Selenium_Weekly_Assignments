package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithWebelementsAndDropDowns {
	/*
	 * This program is to interact with web elements like input fields, dropdowns
	 * and buttons using Selenium WebDriver.
	 */

	public static void main(String[] args) {
		// initialize Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// load the URL
		driver.get("http://leaftaps.com/opentaps/.");

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
		driver.findElement(By.id("accountName")).sendKeys("Selenium10");
		String actualAccountName = driver.findElement(By.id("accountName")).getAttribute("value");
		System.out.println(actualAccountName);

		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		// Select "ComputerSoftware" as the industry.
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select indDropdown = new Select(industry);
		indDropdown.selectByVisibleText("Computer Software");

		// Select "S-Corporation" as ownership using SelectByVisibleText.
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select ownDrodown = new Select(ownership);
		ownDrodown.selectByVisibleText("S-Corporation");

		// Select "Employee" as the source using SelectByValue.
		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select SourceDropdown = new Select(source);
		SourceDropdown.selectByValue("LEAD_EMPLOYEE");

		// Select "eCommerce Site Internal Campaign" as the marketing campaign using
		// SelectByIndex.
		WebElement marketCamp = driver.findElement(By.id("marketingCampaignId"));
		Select marketDropdown = new Select(marketCamp);
		marketDropdown.selectByValue("9000");

		// Select "Texas" as the state/province using SelectByValue
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText("Texas");

		// Click the "Create Account" button.
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String accName = driver.findElement(By.xpath("//span[contains(text(),'Selenium10')]")).getText();
		System.out.println(accName);

		if (accName.contains(actualAccountName)) {
			System.out.println("The Account Name is verified");
		} else
			System.out.println("The Account Name is not correct");

		// Close the browser window.
		driver.close();

	}

}
