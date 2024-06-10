package sdet_interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggesion {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bing.com/?toWww=1&redig=E1B0A0BAF06B419D9B615B053C678E18");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//div[@role='button'])[6]")).click();
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		List<WebElement> allsug = driver.findElements(By.xpath("//li[@stype='LS']"));
		try
		{
			for(WebElement all:allsug)
			{
				String al=all.getText();
				Thread.sleep(4000);
				System.out.println(al);
				if(al.equalsIgnoreCase("selenium python"))
				{
					all.click();
				}
			}

		}
		catch(Exception e)
		{
		
		}

	}
}
