package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class TestNGDemo {

	private WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	@Test
	public void googleSearchTest() {
		driver.get("http://google.com");

		GoogleSearchPageObjects google = new GoogleSearchPageObjects(driver);
		google.setTextInSearchBox("Big brother watches you...");
		google.clickSearchButton();
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Test Completed successfully.");
		// driver.quit();
	}
}
