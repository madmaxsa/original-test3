package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_autocomplete_makemy_trip {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.makemytrip.com/flights/");
try
{
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='commonModal__close']"))).click();

}
catch(Exception e)
{
	
}
driver.findElement(By.xpath("//span[.='From']")).click();
WebElement form = driver.findElement(By.xpath("//input[@placeholder='From']"));
form.sendKeys("benga");
String text;
try
{
do
{
	form.sendKeys(Keys.ARROW_DOWN);
	text=form.getAttribute("value");
	if(text.equalsIgnoreCase("bengaluru"))
	{
		form.sendKeys(Keys.RETURN);
	}
	
}while(!text.isEmpty());
}
catch(Exception e)
{
	
}
driver.findElement(By.xpath("//label[@for='toCity']")).click();
WebElement to=driver.findElement(By.xpath("//input[@placeholder='To']"));
to.sendKeys("bhubane");
String text1;
try
{
do
{
	to.sendKeys(Keys.ARROW_DOWN);
	text1=to.getAttribute("value");
	if(text1.equalsIgnoreCase("bhubaneswar"))
	{
		to.sendKeys(Keys.RETURN);
	}
	
}while(!text1.isEmpty());
}
catch(Exception e)
{
	
}
	}

}
