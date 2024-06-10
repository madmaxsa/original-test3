package sdet_interview;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class download_with_chrome {

	public static void main(String[] args) {

String path=System.getProperty("user.dir")+"\\cv\\test\\";
HashMap<String,Object> set=new HashMap();
set.put("profile.default_content_settings.popups", 0);
set.put("download.default_directory",path);
ChromeOptions optn=new ChromeOptions();
optn.setExperimentalOption("prefs", set);
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver(optn);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
driver.manage().window().maximize();
try
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement btn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='close_button_svg']")));
	btn1.click();
}
catch(Exception e)
{
	
}
WebElement scroll = driver.findElement(By.xpath("//label[text()='Search:']"));
WebElement element = driver.findElement(By.xpath("//table[@id='table-files']/tbody/tr/td[5]/a[1]"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true);", scroll);
//Actions a=new Actions(driver);
//a.scrollToElement(scroll).perform();
element.click();
try
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dismiss-button']"))).click();
}
catch(Exception e)
{
	
}
try
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement btn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Close')]")));
	   WebElement clickable = driver.findElement(By.id("clickable"));
       new Actions(driver)
               .clickAndHold(clickable)
               .perform();
}
catch(Exception e)
{
	
}
try
{}
catch (Exception e) {
	// TODO: handle exception
}

	}

}
