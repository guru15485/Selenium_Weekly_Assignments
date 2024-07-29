package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter the username and password.
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();
	
		// Click on the CRM/SFA link.
		driver.findElement(By.partialLinkText("SFA")).click();
		
		// Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		// Click on Merge Contacts.
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
		// Click on the widget of the "From Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		System.out.println(driver.getTitle());
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(allWindows);
		driver.switchTo().window(windows.get(1));
		
		
		// Click on the first resulting contact.
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			
		// Click on the widget of the "To Contact".
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
//		Thread.sleep(3000);	
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		// Click on the second resulting contact.
//		Thread.sleep(3000);
		Set<String> activeWindows = driver.getWindowHandles();
		List<String> windows1=new ArrayList<String>(activeWindows);
		driver.switchTo().window(windows1.get(1));			
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		
		
		// Click on the Merge button.
		driver.switchTo().window(windows1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Accept the alert.
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Verify the title of the page.
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String actualTitle="View Contact | opentaps CRM";
		
		if (pageTitle.equals(actualTitle)) 
		{
		System.out.println("The page tilte is verified");	
		}
		else
		{
			System.out.println("The page tilte is not verified");
		}
		driver.close();
		

	}

}
