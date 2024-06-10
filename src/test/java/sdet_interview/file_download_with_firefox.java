package sdet_interview;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class file_download_with_firefox {

	public static void main(String[] args) throws InterruptedException {
		String path=System.getProperty("user.dir")+"\\cv\\test\\";
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", path);
		FirefoxOptions  option=new FirefoxOptions();
		option.setProfile(profile);
		
WebDriverManager.firefoxdriver().setup();
WebDriver driver=new FirefoxDriver(option);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
driver.manage().window().maximize();
//driver.findElement(By.xpath("//img[@id='close_button_svg']")).click();
//WebElement scroll = driver.findElement(By.xpath("//label[text()='Search:']"));
WebElement element = driver.findElement(By.xpath("(//table[@id='table-files']/tbody/tr/td[5]/a[1])[1]"));
//JavascriptExecutor js=(JavascriptExecutor)driver;
//js.executeScript("arguments[0].scrollIntoView(true);", element);
element.click();
Thread.sleep(1000);
WebElement element1 = element=driver.findElement(By.xpath("id=\"dismiss-button\""));
Actions a=new Actions(driver);
a.moveToElement(element1).click();

	}

}
