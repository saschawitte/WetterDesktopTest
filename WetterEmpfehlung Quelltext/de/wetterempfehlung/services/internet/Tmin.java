package de.wetterempfehlung.services.internet;


import de.wetterempfehlung.services.AusnahmenErkenner;
import de.wetterempfehlung.services.Dateiverwalter;
import de.wetterempfehlung.services.Datenreiniger;

/**
 * Enthält die Methode Tmin-getFloatArray() um aus dem Quelltext
 * in der text-Datei SourceViaMainMethode.txt die Temperaturwerte
 * in °C für die nöchsten 8-9 Tage auszulesen und als Floatarray
 * auszugeben.
 *
 * @author Sascha
 *
 */
public class Tmin {
	public Tmin() {
		
	}
	
	/**
	 * Tmin getFloatArray. Gibt die minimum Temperatur aus einem Quelltext (kachelmannwetter) als Float Array zurück
	 * Benutzt wird der Quelltext in der Datei SourceViaMainMethode.txt
	 * 
	 * @return float Array der minimal Temperatur am jeweiligen Tag für die nächsten 8-9 Tage
	 */
	public float[] getFloatArray() {
		//Objektaufruf
				Dateiverwalter datei = new Dateiverwalter();
				Datenreiniger reiner = new Datenreiniger();
				AusnahmenErkenner ausnahmi = new AusnahmenErkenner();
				
				
				//Attribute werden weiter an die Klassen gegeben

				String pageSource = datei.textFileToString("SourceViaMainMethode.txt");

				//Zwischenergebnisse
				String results1;
				String results2;
				String results3;
				String results4;
				
				results1 = (reiner.applyRegEx(pageSource, "(?sm)name:\\s\\'Tmin\\'.*?\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\s\\sdata:\\s\\[.*?\\]"));
				results2 = (reiner.applyRegEx(results1, "(?sm)\\[\\s.*?\\]"));
				results3 = (reiner.applyRegEx(results2, "(?:\\[\\s).*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?,.*?"));
				results4 = (reiner.letztenCharEntfernen(results3));
				

				
				
				String[] tempArraySplit = results4.split(",");


				
				
				float[] tempArrayFloat = ausnahmi.stringArrayToFloatArray(tempArraySplit);
				

				
		return tempArrayFloat;
	}

}
