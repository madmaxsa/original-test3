package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class use_of_generic_explicitwait {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
By locator=By.xpath("(//div[@class='YBLJE4'])[2]");
clickelement(driver, locator, 10).click();
	}
	public static WebElement clickelement(WebDriver driver,By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return driver.findElement(locator);
	}

}
