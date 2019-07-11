package de.wetterempfehlung.exceptions;

/**
 * Exception die Auftritt, wenn der Benutzter beim auswählen einr Stadt
 * einen zu kleinen Wert eingibt (also 0 oder kleiner)
 * @author Sascha
 *
 */
@SuppressWarnings("serial")
public class ZuKleinException extends Exception{
	
	public ZuKleinException() {
		super("Eingabe zu klein");  
	}
	
	

}