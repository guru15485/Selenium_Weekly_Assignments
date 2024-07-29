package week4.day2;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsInterationSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Initialize the Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// login to the Salesforce website
		driver.get("https://www.snapdeal.com/");

		// maximize the browser
		driver.manage().window().maximize();

		// declare wait time to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Go to "Men's Fashion".
		WebElement menFashion = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		Actions act = new Actions(driver);
		act.moveToElement(menFashion).click().perform();

		// Go to "Sports Shoes".
		WebElement sportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		act.moveToElement(sportsShoes).click().perform();

		// Get the count of sports shoes.
		String shoesCount = driver.findElement(By.xpath("//div[@class='sub-cat-count ']")).getText();
		System.out.println("The sports shoes count - " + shoesCount);

		// Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// Sort the products by "Low to High".
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();

		// Check if the displayed items are sorted correctly.
		String shoePrice1 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]"))
				.getAttribute("display-price");
		String shoePrice2 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]"))
				.getAttribute("display-price");
		int price1 = Integer.parseInt(shoePrice1);
		System.out.println(price1);
		int price2 = Integer.parseInt(shoePrice2);
		System.out.println(price2);
		if (price1 < price2) {
			System.out.println("The displayed items are sorted correctly with price Low to High order");
		} else {
			System.out.println("The displayed items are not sorted correctly with price Low to High order");
		}

		// Select any price range ex:(500-700).
		WebElement fromRange = driver.findElement(By.xpath("//input[@name='fromVal']"));
		Thread.sleep(3000);
		act.moveToElement(fromRange).click().perform();
		fromRange.clear();
		fromRange.sendKeys("500");
		Thread.sleep(3000);
		WebElement toRange = driver.findElement(By.xpath("//input[@name='toVal']"));

		Thread.sleep(3000);
		act.moveToElement(toRange).click().perform();
		toRange.clear();
		toRange.sendKeys("700");

		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

		// Filter by any colour.
		Thread.sleep(3000);
		WebElement shoeColor = driver.findElement(By.xpath("//label[@for='Color_s-Black']"));
		Thread.sleep(3000);
		act.moveToElement(shoeColor).click().perform();

		// Verify all the applied filters.
		System.out.println("The filters applied - ");
		List<WebElement> appliedFilters = driver.findElements(By.xpath("//div[@class='filters']"));
		for (int i = 1; i <= appliedFilters.size(); i++) {

			String filter = driver.findElement(By.xpath("//div[@class='filters']//div[" + i + "]")).getText();
			System.out.println(filter);
		}

		// Mouse hover on the first resulting "Training Shoes".
		Thread.sleep(3000);
		WebElement firstProduct = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Thread.sleep(3000);
		act.moveToElement(firstProduct).perform();

		// Click the "Quick View" button.
		Thread.sleep(3000);
		WebElement quickViewbtn = driver.findElement(By.xpath("//div[contains(text(),'Quick')]	"));
		Thread.sleep(3000);
		act.moveToElement(quickViewbtn).click().perform();

		// Print the cost and the discount percentage.
		WebElement shoePrice = driver.findElement(By.xpath("//span[@class='payBlkBig']"));

		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("The filtered shoe price - " + shoePrice.getText());
		System.out.println("The filtered shoe discount - " + discount.getText());

		// Take a snapshot of the shoes.
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File desct = new File("./snap/img_ActionsInterationSnapdeal.png");

		FileUtils.copyFile(screenshotAs, desct);

		// Close the current window.
		driver.close();

	}

}
