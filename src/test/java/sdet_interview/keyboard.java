package sdet_interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboard {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		WebElement box1=driver.findElement(By.xpath("//textarea[@name='text1']"));
		box1.sendKeys("welcome hero");
		box1.sendKeys(Keys.CONTROL+"a+c");
		box1.sendKeys(Keys.TAB);
		WebElement box2=driver.findElement(By.xpath("//textarea[@name='text2']"));
		box2.sendKeys(Keys.CONTROL+"v");
//		Actions a=new Actions(driver);
//		a.keyDown(Keys.CONTROL);
//		a.sendKeys("a");
//		a.sendKeys("c");
//		a.keyUp(Keys.CONTROL);
//		a.perform();
//
//		a.sendKeys(Keys.TAB);
//		a.keyDown(Keys.CONTROL);
//		a.sendKeys("v");
//		a.keyUp(Keys.CONTROL);
//		a.perform();
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_A);
//		r.keyPress(KeyEvent.VK_C);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_CONTROL);
	}

}
//textarea[@name='text2']