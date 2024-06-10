package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handle_dynamic_table {

	public static void main(String[] args) throws InterruptedException {

		//String s="sagar.swagat96 @gmail.com";
		//
		//int i=Integer.parseInt(s.substring(s.indexOf("t")+1,s.indexOf("@")-1 ));
		//System.out.println(i);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//h2[text()='Pagination Table']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		int size=driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
		for(int i=1;i<=size;i++) 
		{
			if(i>1)
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
				Thread.sleep(1000);
			}
			int rowno=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
			for(int j=1;j<=rowno;j++)
			{
				Thread.sleep(1000);
				for(int c=1;c<=rowno;c++)

				{
					Thread.sleep(1000);
					if(c==2||c==3)
					{
						Thread.sleep(1000);
						
						String text = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td["+c+"]")).getText();
						System.out.println(text);
					}
					if(c==4)
					{
						driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td["+c+"]//input[@type='checkbox']")).click();
					}
				}
			}

		}
	}
}






