package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageObjectTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		GoogleSearchPageObjects google = new GoogleSearchPageObjects(driver);
		google.setTextInSearchBox("Big brother watches you...");
		google.clickSearchButton();
	}
}
