package sdet_interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class borkenlinks_part2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		//		ChromeOptions opt=new ChromeOptions();
		//		opt.addArguments("--headless");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		int brokenlinks=0;
		int validlinks=0;
		List<WebElement> allinks = driver.findElements(By.xpath("//a"));
		for(WebElement links:allinks)
		{
			String value=links.getAttribute("href");
			if(value==null||value.isEmpty())
			{
				System.out.println("link is empty");
				continue;
			}
			try
			{
			URL u=new URL(value);
			HttpURLConnection http=(HttpURLConnection) u.openConnection();
			http.connect();
			if(http.getResponseCode()>=400)
			{
				System.out.println(http.getResponseCode()+"==>"+value+"==>"+"broken links");
				brokenlinks++;
			}
			else
			{
				System.out.println(http.getResponseCode()+"==>"+value+"==>"+"valid links");
				validlinks++;
			}
			}
			catch(Exception e)
			{
				
			}
		}
System.out.println(validlinks);
System.out.println(brokenlinks);
	}

}
