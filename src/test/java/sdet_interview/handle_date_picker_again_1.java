package sdet_interview;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_date_picker_again_1 {


	public static Month convertmonth(String month)
	{
		HashMap<String,Month>months=new HashMap<String, Month>();
		months.put("January", Month.JANUARY);
		months.put("February", Month.FEBRUARY);
		months.put("March", Month.MARCH);
		months.put("April", Month.APRIL);
		months.put("May", Month.MAY);
		months.put("June", Month.JUNE);
		months.put("July", Month.JULY);
		months.put("August", Month.AUGUST);
		months.put("September", Month.SEPTEMBER);
		months.put("October", Month.OCTOBER);
		months.put("November", Month.NOVEMBER);
		months.put("December", Month.DECEMBER);

		Month allmonth = months.get(month);
		if(allmonth==null)
		{
			System.out.println("invalid month");
		}
		return allmonth;
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		String expectedmonth="December";
		String date="17";
		String year="2025";
		WebElement element = driver.findElement(By.xpath("//h2[text()='Pagination Table']"));
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		driver.switchTo().frame("frame-one796456169");

		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		WebElement web=driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select s=new Select(web);
		s.selectByVisibleText(year);
//		List<WebElement> year = s.getOptions();
//		for(WebElement yr:year)
//		{
//			if(yr.getText().contains("2029"))
//			{
//				yr.click();
//			}
//		}
		while(true)
		{
		String actualmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		System.out.println(actualmonth);
			Month expectmonth = convertmonth(expectedmonth);
			Month currentmonth = convertmonth(actualmonth);
			Thread.sleep(1000);
			int result = expectmonth.compareTo(currentmonth);
			Thread.sleep(1000);
			if(result<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			 else if(result>0)
			{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			}
			 else
			 {
				 break;
			 }
		}
		List<WebElement> alldate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement all:alldate)
		{
			if(all.getText().equals(date))
			{
				all.click();
			}
		}
	}

}
