package sdet_interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_authentication_pop_up {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
//https://the-internet.herokuapp.com/