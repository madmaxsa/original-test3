package sdet_interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileupload_again {

	public static void main(String[] args) throws AWTException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://omayo.blogspot.com/");
WebElement element = driver.findElement(By.id("uploadfile"));
Actions a=new Actions(driver);
a.scrollToElement(element).perform();
a.moveToElement(element).click().perform();
Robot r=new Robot();
r.delay(2000);
 StringSelection selection=new StringSelection("C:\\Users\\sagar\\Downloads\\Sagar 3.5Year_Automation_.pdf");
 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
 
 
 r.keyPress(KeyEvent.VK_CONTROL);
 r.keyPress(KeyEvent.VK_V);
 r.keyRelease(KeyEvent.VK_V);
 r.keyRelease(KeyEvent.VK_CONTROL);
 r.keyPress(KeyEvent.VK_ENTER);
 r.keyRelease(KeyEvent.VK_ENTER);
	}

}
