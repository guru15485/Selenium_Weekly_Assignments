package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsInterationBigbasket {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Initialize the Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// login to the Salesforce website
		driver.get("https://www.bigbasket.com/");

		// maximize the browser
		driver.manage().window().maximize();

		// declare wait time to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on "Shop by Category".
		driver.findElement(By.xpath(
				"(//div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none'])[2]"))
				.click();

		// Mouse over "Foodgrains, Oil & Masala".
		WebElement categoryFood = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(categoryFood).click().perform();

		// Mouse over "Rice & Rice Products".
		driver.findElement(By.xpath(
				"//button[@class='Button-sc-1dr2sn8-0 FilterByCategory___StyledButton-sc-c0pkxv-5 kYQsWi bDIesH']"))
				.click();
		WebElement categoryRice = driver.findElement(By.xpath("//a[contains(text(),'Rice')]"));
		Thread.sleep(3000);
		act.moveToElement(categoryRice).click().perform();

		// Click on "Boiled & Steam Rice".
		driver.findElement(By.xpath("//a[contains(text(),'Boiled')]")).click();

		// Filter the results by selecting the brand "bb Royal".
		WebElement brandBBroyal = driver.findElement(By.xpath("//input[@id='i-BBRoyal']"));
		Thread.sleep(3000);
		act.moveToElement(brandBBroyal).click().perform();

		// Click on "Tamil Ponni Boiled Rice".
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[contains(text(),'Tamil')]")).click();

		// Select the 5 Kg bag.
		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windows);
		driver.switchTo().window(window.get(1));

		Thread.sleep(3000);
		WebElement fiveKGbag = driver.findElement(By.xpath("//span[text()='5 kg']"));
		Thread.sleep(3000);
		act.moveToElement(fiveKGbag).click().perform();

		// Check and note the price of the rice.
		String price = driver.findElement(By.xpath("//span[text()='375']")).getText();
		System.out.println("The price of the Rice is - " + price);

		// Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();

		// Verify the success message that confirms the item was added to your cart.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mx-4 flex-1']")));
		String addedToCartMsg = successMsg.getText();
		System.out.println(addedToCartMsg);

		String actualMsg = "An item has been added to your basket successfully";

		if (addedToCartMsg.equals(actualMsg)) {
			System.out.println("Cart added messaage verified succesful");

		} else {
			System.out.println("Cart added messaage not verified");
		}

		// Take a snapshot of the current page
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dect = new File("./snap/img_ActionsInterationBigbasket.png");
		FileUtils.copyFile(screenshotAs, dect);

		// Close the current window.
		driver.close();

		// Close the main window.
		System.out.println("The Child window closed");
		driver.switchTo().window(window.get(0));
		driver.close();
		System.out.println("The Parent window closed");

	}

}
