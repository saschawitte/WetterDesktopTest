package de.wetterempfehlung.exceptions;

/**
 * Exception die Auftritt, wenn der Benutzter beim ausw‰hlen einr Stadt
 * einen zu groﬂ Wert eingibt (also grˆﬂer als die Anzalh der St‰dte)
 * @author Sascha
 *
 */
@SuppressWarnings("serial")
public class ZuGrossException extends Exception{
	
	public ZuGrossException() {
		super("Eingabe zu groﬂ");  
	}
	
	

}
