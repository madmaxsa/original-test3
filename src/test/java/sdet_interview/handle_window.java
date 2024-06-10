package sdet_interview;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle_window {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("add name to close that perticular browser");
		String s=sc.nextLine();
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://secure.indeed.com/auth?hl=en&continue=%2Fsettings%2Faccount");
String parent=driver.getWindowHandle();
System.out.println(parent);
driver.findElement(By.id("login-google-button")).click();
driver.findElement(By.id("apple-signin-button")).click();

Set<String> allwindow = driver.getWindowHandles();
for(String all:allwindow)
{
	
	driver.switchTo().window(all);
	String title = driver.getTitle();
	//System.out.println(all);
	System.out.println(title);
	if(!all.equals(parent))
	{
	driver.close();
	}
}
	}

}
