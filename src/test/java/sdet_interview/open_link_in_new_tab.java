package sdet_interview;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class open_link_in_new_tab {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://demo.nopcommerce.com/");
String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
driver.findElement(By.linkText("Register")).sendKeys(tab);

	}

}
