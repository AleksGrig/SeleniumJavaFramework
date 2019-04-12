package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver;

	@BeforeSuite
	// @BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeSuite
	public void setUpTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("Google Search Test One",
				"this is a test to validate google search functionality");
		driver.get("http://google.com");
		test.pass("Navigated to google.com");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() throws IOException {
		ExtentTest test = extent.createTest("Google Search Test One",
				"this is a test to validate google search functionality");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterSuite
	public void tearDownTest() {
		driver.close();
		// driver.quit();
	}

	@AfterSuite
	// @AfterTest
	public void tearDown() {
		extent.flush();
	}
}
