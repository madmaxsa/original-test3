package practice;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class date_picker {
	public static Month converter(String month)
	{
		HashMap<String, Month>convert=new HashMap<String, Month>();
		convert.put("January", Month.JANUARY);
		convert.put("February", Month.FEBRUARY);
		convert.put("March", Month.MARCH);
		convert.put("April", Month.APRIL);
		convert.put("May", Month.MAY);
		convert.put("June", Month.JUNE);
		convert.put("July", Month.JULY);
		convert.put("August", Month.AUGUST);
		convert.put("September", Month.SEPTEMBER);
		convert.put("October", Month.OCTOBER);
		convert.put("November", Month.NOVEMBER);
		convert.put("December", Month.DECEMBER);

		Month convertm = convert.get(month);
		if(convertm==null)
		{
			System.out.println("invalid month");
		}
		return convertm;
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		String year="2025";
		String expectedmonth="January";
		String date="17";
		driver.switchTo().frame("frame-one796456169");
		WebElement element=driver.findElement(By.xpath("//span[text()='Gender:']"));
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		WebElement select=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select s=new Select(select);
		s.selectByVisibleText(year);
		while(true)
		{
			String displaymonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month expectmonth = converter(expectedmonth);
			Month currentmonth=converter(displaymonth);
			int res=expectmonth.compareTo(currentmonth);
			if(res<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else if(res>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			else
			{
				break;
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement dt:dates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
			}
		}
	}

}
