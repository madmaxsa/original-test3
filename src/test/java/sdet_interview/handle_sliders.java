package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_sliders {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
WebElement element=driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
WebElement size=driver.findElement(By.xpath("//div[@id='slider']"));
WebElement slider = driver.findElement(By.xpath("//span[contains(@tabindex,'0')]"));
System.out.println("location"+size.getLocation().x);
System.out.println("size"+size.getSize());
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true);", element);
Actions a=new Actions(driver);
a.dragAndDropBy(slider,300,0).build().perform();
System.out.println("location"+size.getSize());
	}

}
