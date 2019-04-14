package datensammler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowEverythingBetweenBrackets {
	
	/**
	 * Pattern Matcher Beispiel aus Java ist eine Insel erweiterte Edition http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_04_007.htm
	 * @param pattern
	 * @param s
	 * @return
	 */
	static Iterable<MatchResult> findMatches( String pattern, CharSequence s )
	{
	  List<MatchResult> results = new ArrayList<MatchResult>();

	  for ( Matcher m = Pattern.compile(pattern).matcher(s); m.find(); )

	    results.add( m.toMatchResult() );

	  return results;
	}

	public static void main(String[] args) {
		
String url = "https://kachelmannwetter.com/de/wetter/2825297-stuttgart";
		
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		
		System.out.println("test");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		

		/*
		 * Website aufrufen und warten bis die Website aufgebaut ist
		 */
		new WebDriverWait(driver, 10)
		 .until(d -> d.getTitle().toLowerCase().startsWith("wetter")); //konvertiert den Titel zu lowercase und sucht dann nach "Wetter im Titel"
		System.out.println("Title: " + driver.getTitle());
		
		String pageSource = driver.getPageSource();

		
		//////// Kachel2 CODE STARTS HERE ////////////
		
		System.out.println("****************NEUER VERSUCH ERGEBNIS **************");
		String pattern = "(?sm)\\[.*?\\]";
		String s = pageSource;
		
		int patternZaehler = 0;
		for ( MatchResult r : findMatches( pattern, s ) ) {
			System.out.println("\n\n\n" + patternZaehler +". " + r.group() + "\n von " + r.start() + " bis " + r.end() +  "(dies war Nummer " + patternZaehler +")"+ "\n\n\n" );
			patternZaehler += 1;
		}
		
		
		
		driver.quit();
		
		
		

	}

}
