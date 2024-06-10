package sdet_interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handle_bootstrap {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.findElement(By.xpath("//a[.='Select Product Type']")).click();
		List<WebElement> allop = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
Thread.sleep(1000);
		SelectbootstrapDropdown(allop,"accounts");
		driver.findElement(By.xpath("//a[.='Select Product']")).click();
		Thread.sleep(1000);
		List<WebElement> ops = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		SelectbootstrapDropdown(ops,"current accounts");
	}
	public static void SelectbootstrapDropdown(List<WebElement> options ,String value)
	{
		for(WebElement all:options)
		{
			if(all.getText().equalsIgnoreCase(value))
			{
				all.click();
				break;
			}
		}
	}

}
