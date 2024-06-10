package sdet_interview;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pdf_download_with_chrome {

	public static void main(String[] args) {
		String path=System.getProperty("user.dir")+"\\cv\\test\\";
		HashMap<String, Object>set=new HashMap<String, Object>();
		set.put("plugins.always_open_pdf_externally", true);
		set.put("profile.default_content_settings.popups", 0);
		
		set.put("download.default_directory", path);
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("prefs", set);
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver(option);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
driver.manage().window().maximize();
WebElement element = driver.findElement(By.id("table-files_filter"));
Actions a=new Actions(driver);
a.moveToElement(element).perform();
driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr/td[5]/a)[1]")).click();
	}

}
