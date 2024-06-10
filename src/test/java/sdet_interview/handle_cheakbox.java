package sdet_interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_cheakbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement element = driver.findElement(By.xpath("//label[.='Days:']"));
		//Actions a=new Actions(driver);
		//a.scrollToElement(element);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		//checkbox(driver,"monday","sunday","friday");
		//checkbox(driver,"all");
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));

		int count=checkbox.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			if(i<2)
			{
			checkbox.get(i).click();
			}
		}
//		for(int i=count-2;i<count;i++)
//		{
//			checkbox.get(i).click();
//		}
		
		
		
		
		
	}
	public static void checkbox(WebDriver driver ,String...value)
	{
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		if(!(value[0].equalsIgnoreCase("all")))
		{
			for(WebElement all:checkbox)
			{
				String s=all.getAttribute("value");
				for(String val:value)
				{
					if(val.equals(s))
					{
						all.click();
					}
				}
			}
		}
		else
		{
			for(WebElement ch:checkbox)
			{
				ch.click();
			}
		}
	}
	}
