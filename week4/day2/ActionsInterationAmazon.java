package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsInterationAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Initialize the Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// login to the Salesforce website
		driver.get("https://www.amazon.in/");

		// maximize the browser
		driver.manage().window().maximize();

		// declare wait time to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Search for "oneplus 9 pro".
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);

		// Get the price of the first product.
		String priceOfFirst = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		String firstProPrice = priceOfFirst.replace(",", "");
		System.out.println("The price of the fisrt product is - " + firstProPrice);
//		int firstAmt = Integer.parseInt(priceOfFirst);
//		System.out.println(firstAmt);

		// Print the number of customer ratings for the first displayed product.
		WebElement noOfCusRating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
		System.out.println("The number of customers rated are - " + noOfCusRating.getText());

		// Click the first text link of the first image.
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

		// Take a screenshot of the product displayed.
		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windows);
		driver.switchTo().window(window.get(1));

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File desct = new File("./snap/img_ActionsInterationAmazon.png");

		FileUtils.copyFile(screenshotAs, desct);

		// Click the 'Add to Cart' button.

		WebElement addToCart = driver.findElement(
				By.xpath("//span[contains(text(),'Protection Plan')]/following::span[text()='Add to Cart']"));
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(addToCart).click().perform();
		// Get the cart subtotal and verify if it is correct.
		String cartSubtotal = driver
				.findElement(
						By.xpath("//b[text()='Cart subtotal']/following::span[@id='attach-accessory-cart-subtotal']"))
				.getText();
//		System.out.println(cartSubtotal);
		String csT = cartSubtotal.replace(".00", "");
//		String subTotal="";
//		for (int i = 0; i < csT.length-1; i++) {
//			subTotal=subTotal+csT[i];
//			System.out.println(csT);
//		}
//		System.out.println(subTotal);
//		int csTotal = Integer.parseInt(cartSubtotal);
//		System.out.println(csTotal);
		String subTotal = csT.replaceAll("[^0-9]", "");
		System.out.println("The cart sub total amount is - " + subTotal);
		if (subTotal.equals(firstProPrice)) {
			System.out.println("The cart sub total is verified");
		} else {
			System.out.println("The cart sub total is not verified");
		}
		// Close the browser
		driver.quit();

	}

}
