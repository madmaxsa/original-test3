package sdet_interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_differentframe {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
driver.switchTo().frame("iframeResult");
driver.switchTo().frame(0);
String text = driver.findElement(By.xpath("//h1[.='This page is displayed in an iframe']")).getText();
System.out.println(text);
driver.switchTo().parentFrame();
String text1 = driver.findElement(By.xpath("//p[.='You can use the height and width attributes to specify the size of the iframe:']")).getText();
System.out.println(text1);
	}

}
