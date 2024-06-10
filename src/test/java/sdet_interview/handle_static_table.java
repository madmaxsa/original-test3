package sdet_interview;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_static_table {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("add company name");
//		String cname=sc.nextLine();
//		String s = null;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
//		WebElement element = driver.findElement(By.xpath("//span[.='Demo Webtable 1 (Static Table)']"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
//		List<WebElement> text = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
//		for(WebElement t:text)
//		{
//			String name = t.getText();
//			if(name.contains(cname))
//			{
//				String cath[]=name.split(" ");
//				int length=cath[0].length();
//				name=name.substring(length);
//				
//				System.out.println(cname+"==>"+name);
//
//			}
//		}
		int count=0;
		for(int i=2;i<=7;i++)
		{
			for(int j=1;j<=3;j++)
			{
				String alltext = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(alltext);
				count++;
			}
		}
		System.out.println(count);

	}

}
//following-sibling::td