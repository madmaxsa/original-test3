package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_date_picker_again {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		String month="january";
		String year="2025";
		String date="17";
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).click();
		int count=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
		while(true)
		{
			WebElement mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			WebElement yea=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			System.out.println(mon.getText());
			System.out.println(yea.getText());
			for(int i=1;i<=count;i++)
			{
				for(int j=1;j<=7;j++)
				{
					if(j==1||j==7)
					{
					 String text = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]")).getText();
					 System.out.println(text);
					}
				}
			}
			if(mon.getText().equalsIgnoreCase(month)&& yea.getText().equalsIgnoreCase(year))
			{
				Thread.sleep(1000);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			
		}
	}

}
