package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;





//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TestSileniumKachel1 {
	
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
		//pageSource = ("Dies ist ein Test mit Pausen!"); TODO: Delete this line
		//System.out.println(pageSource); //zuviel!
		System.out.println("***********without spacbar***********");
		
		String pageSourceLeertaste = pageSource.replaceAll("\\s","");
		
		//System.out.println(pageSourceLeertaste); //zuviel!
		

		String TMaxRX = ("(?sm).*name:\\s\\'Tmax\\'.*data:\\s\\[.*\\].*");
		String TMaxExtrahiert = (pageSource.replaceAll(TMaxRX, " "));
		System.out.println("Der String TmaxExtrahiert lautet = " + TMaxExtrahiert);
		
		
//		Pattern patt = Pattern.compile(TMaxRX);
//		Matcher treffer = patt.matcher(pageSource);
//		
//		String ergebnisString1 = null;
//		String ergebnisString2 = null;
//		String ergebnisString3 = null;
//		
//		if (treffer.matches()) {
//			ergebnisString1 = treffer.group(1);
//			ergebnisString2 = treffer.group(2);
//			ergebnisString3 = treffer.group(3);
//		}
//		
//		System.out.println("*****");
//		System.out.println(ergebnisString1);
//		System.out.println("*****");
//		System.out.println(ergebnisString2);
//		System.out.println("*****");
//		System.out.println(ergebnisString3);
//		
		
		///////////////////
		///////////////////
		///////////////////
		
//		String[] results;
//		results = new results[3];
		
		
		
//		results[]  = pageSource.split("Tmax(.*?)data:(.*?)\\[(.*?)\\]");
		

		
		
//		if(pageSource.find())  {
//			//String 
//		}

//		File file = new File("C:/Users/User/eclipse-workspace/WetterDesktopTest/results.txt");
//		FileInputStream fileInputStream = null;
//		try{
//			fileInputStream = new FileInputStream(file);
//			while (fileInputStream.read()!=-1){
//				System.out.println(fileInputStream.read());
//			}
//		}catch (FileNotFoundException e){
//			e.printStackTrace();
//		}catch (IOException e){
//			e.printStackTrace();
//		}finally{
//			try{
//				fileInputStream.close();
//			}catch (IOException e){
//				e.printStackTrace();
//			}
//		}
//		File f = new File("results.txt");
//		System.out.println("Current Directory is: " + f.getAbsolutePath());
//        URL resource = TestSileniumKachel1.class.getResource("/results.txt");
//		PrintWriter resultTxt = new PrintWriter(file);
//    //    File file = new File(resource.toURI());
//    //    String s = FileUtils.readFileToString(file);
//        System.out.println("results.txt");
//		resultTxt.println(pageSource);
		
//		StringSelection selection = new StringSelection(theString);
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//		clipboard.setContents(selection, selection);
//
		
		
		//System.out.println(pageSource); //zuviel!
		
//		if(pageSource.matches(".*TMax.*"))
//			System.out.println("true");
//		else
//			System.out.println(false);
		
		
		//*[@id="weather-overview-14daystrend"]/script/text()
		
		
		String jsXpath =  "//div[@class='panel-heading']";
		
		
//		driver.findElement(By.xpath("//tspan[contains(.,'18°')]"));
		
//		Element(WebElement) jsXpathElement = jsXpath;
		
//		String pageSourceJS = ((WebElement) driver.findElements(By.xpath(jsXpath))).getText();
		
//		String pageSourceJS = driver.findElements(By.xpath(jsXpath));
		
//		WebElement pageSourceJS = driver.findElement(By.xpath(jsXpath));
//		
//		System.out.println(pageSourceJS);
		
		System.out.println("Page Source by Xpath Web Element Get Text =");
		WebElement pageSourceJS2 = driver.findElement(By.xpath(jsXpath));
		String test123 = "Hund";
		System.out.println(test123);
		
		test123 = pageSourceJS2.getText();
		
		System.out.println("text davor" + test123 + "text danach");
		
//		String innerText = driver.findElement(By.cssSelector("div.success")).getAttribute("innerHTML");
//		String text = innerText.replaceFirst(".+?</button>([^>]+).*", "$1").trim();
//		
		
		List<WebElement> tagList = driver.findElements(By.xpath("//script[@type='text/javascript']"));
		for(int i=0; i<tagList.size();i++) {
			System.out.println(i+". "+tagList.get(i).getAttribute("innerHTML"));
		}
		
		for(int i=0; i<tagList.size();i++) {
			
			if (tagList.get(i).getAttribute("innerHTML").matches("(?sm).*name:\\s\\'Tmax\\'.*data:\\s\\[.*\\].*"))
				System.out.println(i+". true");
			else
				System.out.println(i+". false");
		}
		
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
