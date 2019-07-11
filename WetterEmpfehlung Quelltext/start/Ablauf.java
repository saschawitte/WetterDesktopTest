package start;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import de.wetterempfehlung.services.Dateiverwalter;
import de.wetterempfehlung.services.Empfehler;
import de.wetterempfehlung.services.Internet;
import de.wetterempfehlung.services.OrtInput;
import de.wetterempfehlung.services.internet.Tmin;
import de.wetterempfehlung.teilnehmer.Orte;
/**
 * Programm Ablauf.
 * Anhand von Wetterdaten die von kachelmannwetter
 * heruntetgeladen werden, wird eine Kleidungs-
 * empfehlung erstellt.
 * @author Sascha
 *
 */
public class Ablauf {

	public static void main(String[] args) {
		// Folgende Attribute dürfen per Hand verändert werden (Powerusers only):
				String websiteURL = "https://kachelmannwetter.com/de/wetter/2825297-stuttgart"; //falls die Usereingabe aktiviert ist, wird dieser String überschrieben.
				String dateiName = "SourceViaMainMethode"; 
				Boolean turnOffChrome = false; //überspringt das herunterladen des Quelltexts aus dem Internet
				Boolean turnOffUserInput = false; //überspringt den Userinput
				
				
				//Objektaufruf
				Internet chrome = new Internet();
				Dateiverwalter datei = new Dateiverwalter();
				Tmin tmini = new Tmin();
				Empfehler empfehli = new Empfehler();
				
				//Auswahl der Stadt
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~ Willkommen bei der Wetterempfehlung von Sascha ~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				if(turnOffUserInput == false) {
					System.out.println("Es gibt " + (1+Orte.listGetLastIndex()) + " zur Auswahl");
					for(int i =0;i < Orte.values().length;i++) {
						
						System.out.print((i+1) + " ");
						System.out.println(Orte.getStadt(i).getName());
					}
					
					OrtInput input = new OrtInput();
					Integer auswahl = input.userEingabe();
					
					System.out.println("Auswahl Auswertung: ");
					System.out.println("Als ENUM: "+Orte.getStadt(auswahl-1));
					
					System.out.println("getName= " + (Orte.getStadt(auswahl-1)).getName());
					
					System.out.print("GET URL= ");
					System.out.println((Orte.getStadt(auswahl-1)).getURL());
					websiteURL = (Orte.getStadt(auswahl-1)).getURL();
				}
				
				
				
				//Dieser Teil kann ein und ausgeschaltet werden mit hilfe von "turnOffChrome"
				
				if(turnOffChrome == false) {
					chrome.setPageURL(websiteURL);
					datei.saveStringToTxt(chrome.getPageSource(), dateiName);
				}
				

				//Programm Schnellstart (Userinput und Chrome Websiteaufruf werden übersprungen (zu Test- und Präsentationszwecken)
				
				float[] tminArrayFloat = tmini.getFloatArray();

				String[] empfehlungsArray;
				empfehlungsArray = empfehli.empfehlung(tminArrayFloat);
				LocalDate heuteTag=LocalDate.now();
				for(int i =0; i<tminArrayFloat.length; i++) {
					LocalDate datumJavaTimeAktuell = heuteTag.plusDays(1+i);
					System.out.println(datumJavaTimeAktuell.format(DateTimeFormatter.ofPattern("EEEE", Locale.GERMAN)) +" ("+tminArrayFloat[i] + "°C)");
					System.out.println(empfehlungsArray[i] + "["+tminArrayFloat[i]+"]\n");
				}
				
				
				

	}

}
