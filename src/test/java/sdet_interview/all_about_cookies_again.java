package sdet_interview;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class all_about_cookies_again {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.ebay.com/");
driver.manage().window().maximize();
Set<Cookie> all = driver.manage().getCookies();
System.out.println(all.size());
//for(Cookie a:all)
//{
//System.out.println("cookies names are :"+a.getName()+"==>"+"cookies values are"+a.getValue());
//}
//Cookie cookie=new Cookie("sagar", "swagat1");
//driver.manage().addCookie(cookie);
//Set<Cookie> alls = driver.manage().getCookies();
//System.out.println(alls.size());
//driver.manage().deleteCookieNamed("sagar");
//Set<Cookie> allss = driver.manage().getCookies();
//System.out.println(allss.size());
Iterator<Cookie> i = all.iterator();
while(i.hasNext())
{
	Cookie cookie = i.next();
	System.out.println(cookie.getDomain());
	System.out.println(cookie.getName());
	System.out.println(cookie.getValue());
	System.out.println(cookie.getPath());
	System.out.println(cookie.getExpiry());
	System.out.println("***********************");
}
driver.quit();
	}

}
