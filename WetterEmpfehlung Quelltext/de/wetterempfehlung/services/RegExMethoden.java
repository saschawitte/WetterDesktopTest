package de.wetterempfehlung.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse die Methoden enthält um die Regular Expressions auf den
 * Quelltext der Wetterwebsite anzuwenden.
 * @author Sascha
 *
 */
public class RegExMethoden {
	

	/**
	 * 
	 * Pattern Matcher Beispiel aus Java ist eine Insel erweiterte Edition
	 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_04_007.htm
	 * RegEX= Abkürzung für RegularExpression.
	 * 
	 * @param pattern RegEX Pattern die erkannt werden soll
	 * 
	 * @param s String "s" aus dem eine die RegEx "pattern" erkannt werden soll
	 * 
	 * @return Ausgabe des (mehrzeiligen) Strings der erkannt wurde.
	 * 
	 */
	public Iterable<MatchResult> findMatches(String pattern, CharSequence s) {

		List<MatchResult> results = new ArrayList<MatchResult>();
		for (Matcher m = Pattern.compile(pattern).matcher(s); m.find();)

			results.add(m.toMatchResult());

		return results;
	}
	
	/**
	 * Entfernt den letzten Character Char im String inputString
	 * @param inputString String Input aus dem der letzte Charakter entfernt werden soll
	 * @return Ausgabe des Strings, in dem der letzte Buchstabe/Char fehlt
	 */
	public String letztenCharEntfernen(String inputString) {
        if (inputString != null && inputString.length() > 0 && inputString.charAt(inputString.length() - 1) == 'x') {
            inputString = inputString.substring(0, inputString.length() - 1);
        }
        return inputString;
    }

}
