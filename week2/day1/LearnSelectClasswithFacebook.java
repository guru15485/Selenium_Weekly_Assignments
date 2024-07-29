package week2.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnSelectClasswithFacebook {
	/*
	 * this program is to implement the concept of Selenium WebDriver’s Select class to automate and optimize 
		interactions with the Facebook registration page, thereby understanding the handling of 
		dropdown.
	 */

	public static void main(String[] args) {
		//initialize Chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Guru");
		driver.findElement(By.name("lastname")).sendKeys("Ganesan");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234543210");
		driver.findElement(By.id("password_step_input")).sendKeys("Pass@123");
		
		WebElement dobDay = driver.findElement(By.id("day"));
		Select dayDropdown=new Select(dobDay);
		dayDropdown.selectByValue("15");

		WebElement dobMonth = driver.findElement(By.id("month"));
		Select monthDropdown=new Select(dobMonth);
		monthDropdown.selectByVisibleText("Apr");
		
		WebElement dobYear = driver.findElement(By.id("year"));
		Select yearDropdown=new Select(dobYear);
		yearDropdown.selectByValue("1985");
		
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		
	}
	
}
