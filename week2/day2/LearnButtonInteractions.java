package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnButtonInteractions {
	/*
	 * This program is to learn about the buttons interactions
	 */

	public static void main(String[] args) {
		// initialize the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://leafground.com/button.xhtml");

		// maximize the browser
		driver.manage().window().maximize();

		// declare the wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		Click on the button with the text ‘Click and Confirm title.’		
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		

		// Verify that the title of the page is ‘dashboard.’
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Dashboard")) {
			System.out.println("Page Title verified");
		}

		// Check if the button with the text ‘Confirm if the button is disabled’ is
		// disabled.
		driver.navigate().back();
		boolean buttonDisabled = driver.findElement(By.xpath("//button[@disabled='disabled']")).isDisplayed();
		if (buttonDisabled == true) {
			System.out.println("This - 'Confirm if the button is disabled.' button is disabled");
		}

		// Find and print the position of the button with the text ‘Submit.’
		Point position = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
		System.out.println(position);

		// Find and print the background color of the button with the text ‘Find the
		// Save button color.’
		String buttonColor = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("color");
		System.out.println(buttonColor);

		// Find and print the height and width of the button with the text ‘Find the
		// height and width of this button.’
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.println("The size of the button ‘Find the height and width of this button.’ is -" + size);
		// Close the browser window
		driver.close();

	}

}
