package sdet_interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		int brokenlinks=0;
		int valid=0;
		List<WebElement> alldeadlinks = driver.findElements(By.xpath("//a"));
		for(WebElement links:alldeadlinks)
		{
			String url = links.getAttribute("href");
			if(url==null||url.isEmpty())
			{
				System.out.println("url is empty");
				continue;
			}
			try
			{
			URL u=new URL(url);
			HttpURLConnection http=(HttpURLConnection) u.openConnection();
			http.connect();
			if(http.getResponseCode()>=400)
			{
				System.out.println(http.getResponseCode()+"==>"+url+"==>"+"brokenlinks");
				brokenlinks++;
			}
			else
			{
				System.out.println(http.getResponseCode()+"==>"+url+"==>"+"valid links");
				valid++;
			}
			}
			catch(Exception e)
			{
				
			}
		}
		System.out.println(brokenlinks);
		System.out.println(valid);
	}

}
