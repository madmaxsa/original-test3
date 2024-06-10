package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_inner_iframe {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Thread.sleep(2000);
driver.get("https://demo.automationtesting.in/Frames.html");
driver.findElement(By.linkText("Iframe with in an Iframe")).click();
WebElement frame1 =driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
driver.switchTo().frame(frame1);
WebElement frame2 = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
driver.switchTo().frame(0);//or we can pass frame1
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");
	}

}
