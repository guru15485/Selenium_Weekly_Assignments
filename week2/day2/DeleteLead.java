package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		System.out.println("TestLeaf URL launched in Chrome browser successfully");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.partialLinkText("SFA")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Leads")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(60);
		String leadIDNum = driver.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]")).getText();
		System.out.println(leadIDNum);
		
		Thread.sleep(60);
		
			
		driver.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]")).click();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(240);
		
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadIDNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String mesVerify=driver.findElement(By.xpath("//div[contains(text(),'No')]")).getText();
		if(mesVerify.equals("No records to display"))
		{
			System.out.println("The Lead record -"+leadIDNum+" successfully deleted");
		}
		driver.close();

	}

}
