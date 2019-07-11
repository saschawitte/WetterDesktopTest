package de.wetterempfehlung.services;

public class Empfehler {
	private float[] floatTempArray;
	public Empfehler() {
		
	}
	
	/**
	 * Methode die anhand von Temperaturen entscheidet welche Kleidung an dem jeweiligen Tag getragen werden soll
	 * @param p_floatTempArray float array mit Temperaturen
	 * @return String Array mit Empfehlungen f�r respektive jede Temperatur
	 */
	public String[] empfehlung (float[] p_floatTempArray)  {
		floatTempArray = p_floatTempArray;
		String[] outPutArray = new String[floatTempArray.length];
		
		for(int i=0; i<floatTempArray.length;i++) {
			if(floatTempArray[i]>15.5) {
				outPutArray[i] = "Du brauchst nur kurze Hose und T-Shirt 8).";
			}else if(floatTempArray[i]>11) {
				outPutArray[i] = "Deine Empfehlung f�r Heute: T-Shirt, kurze od. lange Hose und Pulli";
			}else if(floatTempArray[i]>7.2) {
				outPutArray[i] = "Deine Empfehlung f�r Heute: Langarmshirt, lange Hose und Pulli. Schweden d�rfen auch noch kurze Hose tragen.";
			}else if(floatTempArray[i]>1.6) {
				outPutArray[i] = "Neben einer M�tze empfehle ich: Langarmshirt, Pulli, lange Hose und �bergangsjacke.";
			}else if(floatTempArray[i] == 1.6) {
				outPutArray[i] = "Neben einer M�tze empfehle ich: Langarmshirt, Pulli, lange Hose und �bergangsjacke.";
			}else if(floatTempArray[i]<1.6) {
				outPutArray[i] = "Langarmshirt und Pulli dazu lange Hosen und eine dicke Winterjacke. M�tze und Schaal nicht vergessen";
			}
		}
	
		return outPutArray;
	}

}