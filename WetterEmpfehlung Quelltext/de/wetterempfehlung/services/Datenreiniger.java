package de.wetterempfehlung.services;


import java.util.regex.MatchResult;

import de.wetterempfehlung.services.RegExMethoden;

public class Datenreiniger {
	private String pageSource;
	private String inputPattern;
	// Abkürzende Schreibweise

	public Datenreiniger() {
		
	}
	
	/**
	 * Wendet die RegEx Pattern "inputPattern" auf den gegebenen String "inputString" an. 
	 * Achtung: Es können maximal 120 Treffer registriert werden.
	 * @param inputString String auf den die Pattern inputPattern angewendet werden soll
	 * @param inputPattern RegEx Pattern die auf inputString angewendet werden soll.
	 * @return gibt das erste Ergebnis als String zurück
	 */
	public String applyRegEx(String inputString, String inputPattern) {
		String pattern = inputPattern;
		String s = inputString;
		int patternZaehler = 0; //zählt die Treffer via RegEx
		RegExMethoden regex = new RegExMethoden();
		
		String[] results = null;
		results = new String[120];
		
		for (MatchResult r : regex.findMatches(pattern, s)) {
//			System.out.println("\n\n\n" + patternZaehler + ". " + r.group() + "\n von " + r.start() + " bis " + r.end()
//					+ " (dies war Treffer #" + patternZaehler + ")" + "\n\n\n");
			results[patternZaehler] = r.group();
			patternZaehler += 1;
		}
		
		return results[0];
	}
	
	/**
	 * Kleine Methode zum bereinigen meiner Rohdaten um schnell den letzten Char aus einem einzeiligen String (inputString) zu entfernen
	 * 
	 * @param inputString Ein String von dem der allerletzte Char entfernt wird
	 * @return Der Ausgabe String (letzter Charakter wurde entfernt
	 */
	public String letztenCharEntfernen(String inputString) {
		String s = inputString;
		String r;
		r = (s.substring(1, s.length() - 1));
		
		return r;
	}
	
	


}
