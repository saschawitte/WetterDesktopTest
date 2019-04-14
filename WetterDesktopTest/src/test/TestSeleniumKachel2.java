package test;

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

public class TestSeleniumKachel2 {
	
	/**
	 * Pattern Matcher Beispiel aus Java ist eine Insel erweiterte Edition http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_04_007.htm
	 * @param pattern
	 * @param s
	 * @return
	 */
	private static Iterable<MatchResult> findMatches( String pattern, CharSequence s )
	{
	  List<MatchResult> results = new ArrayList<MatchResult>();

	  for ( Matcher m = Pattern.compile(pattern).matcher(s); m.find(); )

	    results.add( m.toMatchResult() );

	  return results;
	}
	
	/**
	 * Removes the last character from given String
	 * example: println(letztenCharEntfernen(meinSting));
	 * @param str
	 * @return
	 */
	
	private static String letztenCharEntfernen(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
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
		
		
		////////////////////////////////
		//// STRING CLEANER 1 //////////
		////////////////////////////////
		System.out.println("****************NEUER VERSUCH ERGEBNIS **************");
		String pattern = "(?sm)name:\\s\\'Tmax\\'.*?\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\sdata:\\s\\[.*?\\]";
		String s = pageSource;
		String[] results = null;
		results = new String[120];
		
		int patternZaehler = 0;
		for ( MatchResult r : findMatches( pattern, s ) ) {
			System.out.println("\n\n\n" + patternZaehler +". " + r.group() + "\n von " + r.start() + " bis " + r.end() +  " (dies war Treffer #" + patternZaehler +")"+ "\n\n\n" );
			results[patternZaehler] = r.group();
			patternZaehler += 1;
		}
		
		
		
		
		String TmaxPageSource = null;
		TmaxPageSource = results[0];
		System.out.println("Tmax als Variable= " + TmaxPageSource);
		
		
		
		////////////////////////////////
		//// STRING CLEANER 2 //////////
		////////////////////////////////
		
		patternZaehler = 0;
		for(int i=0; i<results.length;i++) { //empty results before new regex matcher query
			results[i] = " ";
		}
		
		for ( MatchResult r : findMatches( "(?sm)\\[.*?\\]", TmaxPageSource ) ) {
			System.out.println("\n\n\n" + patternZaehler +". " + r.group() + "\n von " + r.start() + " bis " + r.end() +  " (dies war Treffer #" + patternZaehler +")"+ "\n\n\n" );
			results[patternZaehler] = r.group();
			patternZaehler += 1;
		}
		String TmaxClean = null;
		TmaxClean = results[0];
		System.out.println("Tmax clean als string= " + TmaxClean);
		
		
		
		////////////////////////////////
		//// STRING CLEANER 3 //////////
		////////////////////////////////
		
		patternZaehler = 0;
		for(int i=0; i<results.length;i++) { //empty results before new regex matcher query
			results[i] = " ";
		}
		for ( MatchResult r : findMatches( "(?:\\[).*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?", TmaxClean ) ) {
			System.out.println("\n\n\n" + patternZaehler +". " + r.group() + "\n von " + r.start() + " bis " + r.end() +  " (dies war Treffer #" + patternZaehler +")"+ "\n\n\n" );
			results[patternZaehler] = r.group();
			patternZaehler += 1;
		}
		
		String TmaxClean2 = null;
		TmaxClean2 = results[0];
		System.out.println("Tmax clean 222 als string= " + TmaxClean2);
		
		////////////////////////////////
		//// STRING CLEANER 4 //////////
		////////////////////////////////		
		
		
		System.out.println("Tmax Clean 3 wird gleich zu= " + TmaxClean2.substring(1));
		// 		System.out.println("Tmax Clean 3 wird gleich zu= " + TmaxClean2.substring(1, TmaxClean2.length()-1)); // Orginal hinten und vorne entfernt
		String TmaxClean3 = null;
		TmaxClean3 = (TmaxClean2.substring(1, TmaxClean2.length()-1));
		System.out.println("Tmax clean 3 ist= " + TmaxClean3);
		
		String[] tmaxArrayComma = null;
		tmaxArrayComma = new String[32];
		
		
		System.out.println("********** STRING CLEANER 4 RESULTS START *************");
		patternZaehler = 0;
		for ( MatchResult r : findMatches( "(.*?),", TmaxClean3 ) ) {
			System.out.println("\n\n\n" + patternZaehler +". " + r.group() + "\n von " + r.start() + " bis " + r.end() +  " (dies war Treffer #" + patternZaehler +")"+ "\n\n\n" );
			tmaxArrayComma[patternZaehler] = r.group(); // TODO saved for later: .substring(r.group().length()-1);
			patternZaehler += 1;
		}
		
		System.out.println("********** STRING CLEANER 4 RESULTS END *************");
		
		System.out.println("tmaxArray 0 ist= " + tmaxArrayComma[0]);
		System.out.println("tmaxArray 5 ist= " + tmaxArrayComma[5]);
		
		System.out.println("tmaxArray 8 ist= " + tmaxArrayComma[8]);
		
		System.out.println("tmaxArray 12 ist= " + tmaxArrayComma[12]);
		
		String[] tmaxArray = null;
		tmaxArray = new String[32];
		
//		for(int i=0; i<tmaxArrayComma.length; i++) {
//			tmaxArray[i] = tmaxArrayComma[i].substring(0, tmaxArrayComma[i].length()-1);
//		}
		
		System.out.println("tmaxArray 0 ist= " + tmaxArray[0]);
		System.out.println("tmaxArray 5 ist= " + tmaxArray[5]);
		
		System.out.println("tmaxArray 8 ist= " + tmaxArray[8]);
		
		System.out.println("tmaxArray 12 ist= " + tmaxArray[12]);
		
		// TODO: Ich will alle commas aus meinem StringArray raus haben
		
		System.out.println(letztenCharEntfernen(tmaxArrayComma[2]));
	
		
		
		driver.quit();
		
		
		

	}

}
