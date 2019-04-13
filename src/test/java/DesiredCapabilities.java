import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities {

	public static void main(String[] args) {

		// DesiredCapabilities cap = new DesiredCapabilities();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		// WebDriverManager.iedriver().setup();
		// WebDriver driver = new InternetExplorerDriver();

		driver.get("http://google.com");
		// driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Поиск в Google']"))
				.sendKeys(Keys.RETURN);

		driver.close();
	}

}
