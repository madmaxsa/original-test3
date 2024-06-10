package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class double_click {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement box1 = driver.findElement(By.id("field1"));
		WebElement box2 =driver.findElement(By.id("field2"));
		WebElement button =driver.findElement(By.xpath("//button[text()='Copy Text']"));
		box1.clear();
		box1.sendKeys("hero");
		Actions a=new Actions(driver);
		a.doubleClick(button).perform();
		String b1=box1.getAttribute("value");
		String b2=box2.getAttribute("value");
		System.out.println(b2);
		if(b1.equals(b2))
		{
			System.out.println("same value is present in b2");
		}
		else
		{
			System.out.println("same value is not present in b2"); 
		}
	}

}
