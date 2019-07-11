package de.wetterempfehlung.services;

import java.util.InputMismatchException;
import java.util.Scanner;


import de.wetterempfehlung.exceptions.ZuGrossException;
import de.wetterempfehlung.exceptions.ZuKleinException;
import de.wetterempfehlung.teilnehmer.Orte;

/**
 * Enthält die userEingabe Methode. Nimmt die Zahl für die jew.
 * Stadt des Users entgegen. Überprüft auch ob die Zahl im Rahmen
 * der möglichen Städte ist.
 * @author Sascha
 *
 */
public class OrtInput{
	// Meine Attribute
	private int zahlenEingabe;
	private int fehlerCounter = 0;
	private boolean endeTryErreicht = false;
	
	
	public OrtInput() {
		
		
	}
	
	/**
	 * Fordert den Nutzer auf einen Int einzugeben.
	 * Es wird kontrolliert, dass keine zu große oder zu kleine Zalh eingegeben wird.
	 * Eingabe muss im ENUM Orte enthalten sein
	 * @return eingebene Zahl ( als Int
	 */
	public Integer userEingabe() {

		for (int i = 0; i < 3; i++) {
			if (fehlerCounter < 3) {

				try { 
					System.out.println("Bitte Zahl Eingeben (Verbleibende Versuche: " + (3-fehlerCounter) + ")");
					Scanner leser = new Scanner(System.in);
					zahlenEingabe = leser.nextInt();
					if(zahlenEingabe >=(2+Orte.listGetLastIndex())) {
						throw new ZuGrossException();
					}
					if(zahlenEingabe <=0) {
						throw new ZuKleinException();
					}
					System.out.println("**\nDanke für das korrekte Auswählen einer Stadt\n***\n");
					endeTryErreicht = true;
					break;
				} catch (InputMismatchException np) {
					System.out.println("Folgendes ist schief gelaufen: " + np);
					fehlerCounter++;
					System.out.println("Verbleibende Versuche es richtig zu machen: " + (3 - fehlerCounter));
				} catch (ZuGrossException e) {
					fehlerCounter++;
					e.printStackTrace();
				} catch (ZuKleinException e) {
					fehlerCounter++;
					e.printStackTrace();
				} 
			} else if (fehlerCounter > 2) {
				System.out.println("test");
				throw new ArithmeticException(); // throw: Eine Ausnahme wird ASUGELÖST
				

			}
		}
		
		

		
		
		return zahlenEingabe;
	}

}
