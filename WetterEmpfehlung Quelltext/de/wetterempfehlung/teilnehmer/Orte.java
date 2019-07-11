package de.wetterempfehlung.teilnehmer;



/**
 * Liste aller Städt (orteName) der Kursteilnehmer und dazugehörige WetterWebsiteURL (orteURL)
 * Dieses ENUM war notwendig, da die URL ein token enthält 
 * Position des Tokens:
 * https://kachelmannwetter.com/de/wetter/{{{TOKEN}}}-krefeld
 * @author Sascha
 *
 */
public enum Orte {
		KREFELD("Krefeld","https://kachelmannwetter.com/de/wetter/2884509-krefeld"),
		MUENCHEN("München",	"https://kachelmannwetter.com/de/wetter/2867714-muenchen"),
		DARMSTADT("Darmstadt",	"https://kachelmannwetter.com/de/wetter/2938913-darmstadt"),
		NUERNBERG("Nürnberg",	"https://kachelmannwetter.com/de/wetter/2861650-nuernberg"),
		AUGSBURG("Augsburg",	"https://kachelmannwetter.com/de/wetter/2954172-augsburg"),
		BOCHUM("Bochum",	"https://kachelmannwetter.com/de/wetter/2947416-bochum"),
		BRAUNSCHWEIG("Braunschweig",	"https://kachelmannwetter.com/de/wetter/2945024-braunschweig"),
		FRANKFURT("Frankfurt a. M.",	"https://kachelmannwetter.com/de/wetter/2925533-frankfurt-am-main"),
		WUERZBURG("Würzburg",	"https://kachelmannwetter.com/de/wetter/2805615-wuerzburg"),
		BREMEN("Bremen",	"https://kachelmannwetter.com/de/wetter/2944388-bremen"),
		STUTTGART("Stuttgart",	"https://kachelmannwetter.com/de/wetter/2825297-stuttgart");

	
	private final String orteName;
	private final String orteURL;
	
	
	private Orte (String orteName, String orteURL) {
				this.orteName = orteName;
				this.orteURL = orteURL;
	}
	
	// ein paar Methoden...
	
	public String getURL() {
		return orteURL;
	}
	
	public String getName() {
		return orteName;
	}
	
	private static Orte[] list = Orte.values(); //mit Orten in Liste arbeiten (1,2,3,4) https://stackoverflow.com/questions/6692664/how-to-get-enum-value-from-index-in-java/6692713

	/**
	 * Jeder Stadt wird eine ID "i" zugeordnet. Die Liste ist nach Vornamen der Teilnehmer sortiert
	 * @param i Zahl der Stadt (vorher wird eine Liste mit den jeweiligen Städten angezeigt.
	 * @return ENUM StadtNAME
	 */
    public static Orte getStadt(int i) {
        return list[i];
    }

    /**
     *  
     * Anzahl aller Städte bzw. Anzahl der Teilnehmer
     *
     * @return Anzahl Städte
     */
    public static int listGetLastIndex() {
        return list.length - 1;
    }
	
    /**
     * Gibt die Attritbute in einer übersichtlichen Form aus
     * @return Gibt die Attritbute in einer übersichtlichen Form aus
     */
	public String kurzeInfo() {
		return "Ort= " + orteName + 
				"URL= " + orteURL;
	}
	
	

}