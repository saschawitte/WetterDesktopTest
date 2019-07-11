package de.wetterempfehlung.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Dateiverwalter {
	public String pageSource = "";
	public String textFileName = "";

	/**
	 * Speichert einen String in einer Text Datei zwischen 
	 * (diese Methode erlaubt den String auch nach erneutem Starten wieder aufzurufen)
	 * Die Methode dient als Hilfsmittel um nicht jedesmal den Quelltext neu herunterzuladen
	 * und dadurch zu riskieren von kachelmannwetter einen IP-Ban zuerhalten
	 * @param pageSource der String (Quelltext) der in der TextDatei gespeichert werden soll
	 * @param textFileName name der neu zu erstellenden Datei (OHNE .txt)
	 */
	public void saveStringToTxt(String pageSource, String textFileName) {
		this.textFileName = textFileName;
		this.pageSource = pageSource;

		// Textfile generator (copied from)
		// sourcURL=http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_17_001.htm#mj87f7ea8c7b8051417049399df2c5782a
		Writer fw = null;

		try {
			fw = new FileWriter(textFileName + ".txt");
//		  fw.write( "Hier könnte ihr Source code stehen \n zweite zeile \n\n\n 5te zeile" );
			fw.write(pageSource);
			fw.append(System.getProperty("line.separator"));
		} catch (IOException e) {
			System.err.println("Datei konnte nicht erstellt werden");
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	
	/**
	 * Braucht Liest eine Text Datei Zeile für Zeile ein und gibt als return einen String aus
	 * Wird benutzt um den Quelltext aus einer Textdatei einzulesen
	 * @param textFileName den String der Text Datei die gelesen werden soll im Format (MIT .txt)
	 * @return String aus der gesamten TextDatei (String PageSourceFromTxT)
	 */
	public String textFileToString(String textFileName) {
		String PageSourceFromTxt = "";
		
		BufferedReader reader = null;
		try
		{
		  reader = new BufferedReader(new FileReader( textFileName ));
		  String gelesen = reader.readLine();
		  while ( gelesen != null  ) {
			PageSourceFromTxt = PageSourceFromTxt + gelesen +"\n" ;
		  	gelesen = reader.readLine();
		  }
		  	
		}
		catch ( IOException e ) {
		  System.err.println( "Datei konnte nicht gelesen werden (IOException)" );
		}
		finally {
		  try { reader.close(); } catch ( Exception e ) { }
		}
	
		return PageSourceFromTxt;
	}

}
