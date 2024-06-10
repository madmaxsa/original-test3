package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webtable1 {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("http://seleniumpractise.blogspot.com/2021/08/");
Thread.sleep(2000);
//for(int i=2;i<=7;i++)
//{
//	for(int j=1;j<=4;j++)
//	{
//		if(j==3||j==4)
//		{
//		 String data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
//		 System.out.println(data);
//		}
//	}
//}
//driver.findElement(By.xpath("//td[.='FlipKart']//preceding::td/input")).click();
for(int i=1;i<2;i++)
{
	for(int j=1;j<=26;j++)
	{
	if(j==1||j==6||j==11||j==16||j==21||j==26)
	{
	Thread.sleep(1000);
		driver.findElement(By.xpath("//th[.='Action']//following::td["+j+"]/input")).click();
	}
	
	}
}









//List<WebElement> head = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]"));
//boolean status=false;
//for(WebElement all:head)
//{
//	String header = all.getText();
//	System.out.println(header);
//	Thread.sleep(1000);
//	if(header.equalsIgnoreCase("country"))
//	{
//		Thread.sleep(1000);
//		status=true;
//		break;
//	}
//}
//Assert.assertTrue(status);

driver.quit();
	}

}
