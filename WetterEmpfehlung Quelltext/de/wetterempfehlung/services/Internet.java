package de.wetterempfehlung.services;

//Import der Selenium packages (spezielle packages für Chrome und Wait-Funktion)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Selenium WebDriver Klasse. Enthält wichtige Methoden wie z.B. getPageSource.
 * Zunächst muss die URL mit Hilfe von setURL gesetzt werden. Beispiel URL für
 * Stuttgart: https://kachelmannwetter.com/de/wetter/2825297-stuttgart
 * 
 * @author Alfa
 *
 */
public class Internet {
	public static String pageURL;


	/**
	 * setPageURL
	 * Adresse der Website von der später die Wetterdaten entnommen werden
	 * 
	 * @param websiteAdresse Website Adresse z.B. http://www.google.de/
	 */
	public void setPageURL(String websiteAdresse) {
		pageURL = websiteAdresse;
	}
	
	/*
	 * getPageSource
	 * Methode stellt den Quelltext der Website bereit 
	 * (kann später für downstream methoden verwendet werden)
	 */
	public String getPageSource() {
		String url = pageURL;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);

		/*
		 * 
		 * Website aufrufen und warten bis die Website aufgebaut ist
		 * 
		 */
		new WebDriverWait(driver, 10)

				.until(d -> d.getTitle().toLowerCase().startsWith("wetter")); // konvertiert den Titel zu lowercase und
																				// sucht dann nach "Wetter im Titel"

		System.out.println("Title: " + driver.getTitle());

		String pageSource = driver.getPageSource();
		
		driver.quit();

		return pageSource;
	}

}
