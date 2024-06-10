package sdet_interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class all_about_links {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
List<WebElement> allinks = driver.findElements(By.xpath("//a"));
for( WebElement links:allinks)
{
	System.out.println(links.getText());
	System.out.println(links.getAttribute("href"));
}
	}

}
