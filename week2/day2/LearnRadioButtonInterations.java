package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnRadioButtonInterations {

	public static void main(String[] args) throws InterruptedException {

		// initialize the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://www.leafground.com/radio.xhtml");

		// maximize the browser
		driver.manage().window().maximize();

		// declare the wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Select 'Your most favourite browser' from the radio buttons
		driver.findElement(By.xpath(
				"(//label[text()='Chrome'])[1]/preceding::span[@class='ui-radiobutton-icon ui-icon ui-icon-blank ui-c'][1]"))
				.click();

		// Click on a radio button, then click on the same radio button again to verify
		// that it becomes ‘unselected’.
		WebElement browserRadioBtn = driver.findElement(By.xpath("	"));
		browserRadioBtn.click();
		Thread.sleep(120);
		if (browserRadioBtn.isSelected()) {
			System.out.println(browserRadioBtn.isSelected());
			System.out.println("The button is  selected");
		} else {
			System.out.println("The button is not selected");
		}
		WebElement browserBtnUncheck = driver.findElement(By.xpath("//label[text()='Chennai']/preceding::span[1]"));
		Thread.sleep(3000);
		browserBtnUncheck.click();
		boolean s = browserBtnUncheck.isSelected();
		System.out.println(s);
		if (s) {
			System.out.println("The button is  selected");
		} else {
			System.out.println("The button is not selected");
		}

		// Identify the radio button that is initially selected by default.
		WebElement defaultBtn = driver.findElement(By.xpath("(//label[text()='Safari'])[2]/preceding::span[1]"));
		boolean isSelDefault = defaultBtn.isEnabled();
		System.out.println(isSelDefault);
		if (isSelDefault) {
			System.out.println("The button Safari is selected");
		} else {
			System.out.println("The button Safari is not selected");
		}
		// Check and select the age group (21//40 Years) if not already selected.
		boolean ageButton = driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding::span[1]"))
				.isEnabled();
		System.out.println(ageButton);
		if (ageButton) {
			System.out.println("The age group (21//40 Years) button is selected as Default value");
		} else {
			System.out.println("The age group (21//40 Years) button is not selected");
		}

	}

}
