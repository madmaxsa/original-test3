package sdet_interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pdf_download_with_firefox {

	public static void main(String[] args) {
		String path=System.getProperty("user.dir")+"\\cv\\pdf\\";
FirefoxProfile profile=new FirefoxProfile();
profile.setPreference("pdfjs.disabled", true);
profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
profile.setPreference("browser.download.folderList", 2);
profile.setPreference("browser.download.dir", path);
FirefoxOptions option=new FirefoxOptions();
option.setProfile(profile);
WebDriverManager.firefoxdriver().setup();
WebDriver driver=new FirefoxDriver(option);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
driver.manage().window().maximize();
WebElement element = driver.findElement(By.id("table-files_filter"));
Actions a=new Actions(driver);
a.moveToElement(element).perform();
driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr/td[5]/a)[1]")).click();


	}

}
