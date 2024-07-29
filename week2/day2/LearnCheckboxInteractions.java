package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnCheckboxInteractions {
	/*
	 * This program is to learn to automate checkbox interactions using Selenium
	 * WebDriver and perform verifications on web elements.
	 */

	public static void main(String[] args) {

		// initialize the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://leafground.com/checkbox.xhtml");

		// maximize the browser
		driver.manage().window().maximize();

		// declare the wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on the "Basic Checkbox.”
		driver.findElement(By.xpath(
				"//span[text()='Basic']//preceding::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"))
				.click();

		// Click on the "Notification Checkbox."
		driver.findElement(By.xpath(
				"//h5[text()='Notification']/following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"))
				.click();

		// Verify that the expected message is displayed.
		String actMsg = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		String expMsg = "Checked";

		if (actMsg.equals(expMsg)) {
			System.out.println("The expected message - " + expMsg + " is verified");

		} else {
			System.out.println("The expected message - " + expMsg + " is not verified");
		}

		// Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath(
				"//h5[text()='Choose your favorite language(s)']/following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"))
				.click();

		// Click on the "Tri-State Checkbox."
		driver.findElement(By.xpath(
				"//h5[text()='Tri State Checkbox']/following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"))
				.click();

		// Verify which tri-state option has been chosen.
		String actualMsg = driver.findElement(By.xpath("//p[text()='State = 1']")).getText();
		String expectledMsg = "State = 1";

		if (actualMsg.equals(expectledMsg)) {
			System.out.println("The expected message - " + expectledMsg + " is Choosen");

		} else {
			System.out.println("The expected message - " + expectledMsg + " is not Choosen");
		}
		// Click on the "Toggle Switch."
		driver.findElement(By.className("ui-toggleswitch-slider")).click();

		// Verify that the expected message is displayed.
		String actMsg1 = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		String expMsg1 = "Checked";
		System.out.println(actMsg1);

		if (actMsg1.equals(expMsg1)) {
			System.out.println("The expected message - " + expMsg1 + " is verified");

		} else {
			System.out.println("The expected message - " + expMsg1 + " is not verified");
		}

		// Verify if the Checkbox is disabled.
		boolean enabled = driver.findElement(By.xpath(
				"//h5[text()='Verify if check box is disabled']/following::span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']"))
				.isDisplayed();
		System.out.println(enabled);
		if (enabled == true) {
			System.out.println("The checkbox is enabled");

		}

		else {
			System.out.println("The checkbox is disabled");
		}
		// Select multiple options on the page (details may be needed).
		driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-trigger ui-state-default ui-corner-right']"))
				.click();
		driver.findElement(
				By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']/following::label[text()='Miami']"))
				.click();
		driver.findElement(
				By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']/following::label[text()='Paris']"))
				.click();
		driver.findElement(
				By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']/following::label[text()='Rome']"))
				.click();
		// Perform any additional actions or verifications required.
		// Close the web browser when done.
		driver.close();

	}

}
