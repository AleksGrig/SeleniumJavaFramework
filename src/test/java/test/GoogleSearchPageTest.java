package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//goto google.com
		driver.get("http://google.com");
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Big brother watches you...");
		GoogleSearchPage.textbox_search(driver).sendKeys("Big brother watches you...");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		//driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Поиск в Google']")).click();
		GoogleSearchPage.button_search(driver).click();
		System.out.println("Test completed successfully");

	}
}
