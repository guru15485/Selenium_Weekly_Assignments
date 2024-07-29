package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAutomation {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("iframeResult");
				
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert confirmAlert = driver.switchTo().alert();
		
		
		confirmAlert.sendKeys("Guruthilak");
		confirmAlert.accept();
		
		String ConfirmText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		
		System.out.println(ConfirmText);
		String name="Guruthilak";
		
		if (ConfirmText.contains(name)) {
			System.out.println("The alert confirmation text is verified");
			
		}
		
		else
		{
			System.out.println("The alert confirmation text is not verified");
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		
		driver.close();

	}

}
