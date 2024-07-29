package week3.day2.LearnList;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCountofBagsAjio {

	public static void main(String[] args) throws InterruptedException {
		// initialize the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");

		// maximize the browser
		driver.manage().window().maximize();

		// declare the wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);

		// To the left of the screen under "Gender" click on "Men"
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();

		// Under "Category" click "Fashion Bags"
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Fashion')]")).click();
//				driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']")).click();
		// Print the count of the items found.
		Thread.sleep(500);
		String count = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(count);

		String itemsFound = count.replaceAll("[^0-9]", "");	
		System.out.println(itemsFound);

		// Get the list of brand of the products displayed in the page and print the
		// list.
		List<WebElement> brandsName = driver.findElements(By.className("brand"));

		int size = brandsName.size();
		System.out.println("List of Brand Names - ");

		for (int i = 0; i < size; i++) {
			System.out.println(brandsName.get(i).getText());

		}
		// Get the list of names of the bags and print it

		List<WebElement> bagNames = driver.findElements(By.className("nameCls"));

		int size1 = bagNames.size();
		System.out.println("List of Bag Names - ");
		for (int i = 0; i < size1; i++) {
			System.out.println(bagNames.get(i).getText());
		}
		driver.close();

	}
}
