package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//goto google.com
		driver.get("http://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Big brother watches you...");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Поиск в Google']")).click();
		
		System.out.println("Test completed successfully");
	}
}
