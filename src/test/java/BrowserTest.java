import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.operadriver().setup();
		//WebDriverManager.phantomjs().setup();
		//WebDriverManager.edgedriver().setup();
		// WebDriverManager.iedriver().setup();
		
		//String projectPath = System.getProperty("user.dir");
		
		//System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");
		// WebDriver driver = new InternetExplorerDriver();
	
		driver.get("http://google.com");
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
		textBox.sendKeys("ALEX IS HERE!!!");
		List<WebElement> list = driver.findElements(By.xpath("//input"));
		System.out.println(list.size());
	}
}
