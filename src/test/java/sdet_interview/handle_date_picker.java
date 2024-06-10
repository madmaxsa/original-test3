package sdet_interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_date_picker {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
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

		while(true)
		{
			WebElement mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			WebElement yea=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			Thread.sleep(1000);
			if(mon.getText().equalsIgnoreCase(month)&&yea.getText().equalsIgnoreCase(year))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement dt:dates)
		{
			if(dt.getText().equalsIgnoreCase(date))
			{
				dt.click();
			}
		}
	}

}
