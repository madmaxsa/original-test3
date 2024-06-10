package sdet_interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_jquery_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		//String page=driver.getPageSource();
		//System.out.println(page);
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(1000);
//selectvalue(driver, "all");
		selectvalue(driver, "choice 1");
		Thread.sleep(1000);

		driver.quit();
	}
	public static void selectvalue(WebDriver driver,String...value)
	{
		List<WebElement> allch = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if(!(value[0].equalsIgnoreCase("all")))
		{
			for(WebElement al:allch)
			{
				String text=al.getText();
				for(String val:value)
				{
					if(text.equalsIgnoreCase(val))
					{
						al.click();
						break;
					}
				}
			}
		}

		else
		{
			try
			{
				Thread.sleep(1000);
				for(WebElement all:allch)
				{
					Thread.sleep(1000);
                     all.click();
				}
			}
			catch(Exception e)
			{

			}
		}
	}
}
