package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSilenium0 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		
		// TODO Auto-generated method stub
		System.out.println("test");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("terminator\n");
		new WebDriverWait(driver, 10)
		 .until(d -> d.getTitle().toLowerCase().startsWith("terminator"));
		System.out.println("Title: " + driver.getTitle());
		driver.quit();

		
		
	}

}
