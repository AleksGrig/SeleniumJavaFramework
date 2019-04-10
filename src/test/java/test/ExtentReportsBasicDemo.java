package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1 = extent.createTest("Google Search Test One",
				"this is a test to validate google search functionality");

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("http://google.com");
		test1.pass("Navigated to google.com");

		GoogleSearchPageObjects google = new GoogleSearchPageObjects(driver);

		google.setTextInSearchBox("Big brother watches you...");
		test1.pass("Entered text in searchbox");

		google.clickSearchButton();
		test1.pass("Clicked submit button");

		driver.close();
		driver.quit();
		test1.pass("Closed browser");

		test1.info("Test Completed");

		// calling flush writes everything in the log file
		extent.flush();
	}

}
