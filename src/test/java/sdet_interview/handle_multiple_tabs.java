package sdet_interview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_multiple_tabs {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
driver.findElement(By.xpath("//a[.='OrangeHRM, Inc']")).click();
//driver.findElement(By.xpath("//span[.='privacy policy']")).click();
Set<String> alltab = driver.getWindowHandles();
List<String> al=new ArrayList<String>(alltab);
System.out.println(al.size());
String parent = al.get(0);
String child = al.get(1);
for(String all:alltab)
{
	driver.switchTo().window(all);
	Thread.sleep(3000);
	driver.getTitle();
	driver.close();
}
//Iterator<String>i=alltab.iterator();
//while(i.hasNext())
//{
//	String tab = i.next();
//	System.out.println(tab);
//	for(String a:alltab)
//	{
//		driver.switchTo().window(a);
//		Thread.sleep(3000);
//			driver.quit();
//		
//	}
//}
	}

}
