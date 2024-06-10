package sdet_interview;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class all_about_cookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+"==:"+cookie.getValue());
		}
		Cookie k=new Cookie("sagar", "12345");
		driver.manage().addCookie(k);
		Set<Cookie> cookies1 = driver.manage().getCookies();
		System.out.println(cookies1.size());
		driver.manage().deleteCookie(k);
		driver.manage().deleteCookieNamed("sagar");
	}

}
