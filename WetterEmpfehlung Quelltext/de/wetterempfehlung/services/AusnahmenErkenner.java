package de.wetterempfehlung.services;

public class AusnahmenErkenner {
	private String[] inputStringArray;
	private int arrayNummerFuehrFehlerReport = 0;
	private float[] outPutFloatArray;
	private float[] outputFloatV1;
	private float[] outputFloatV2;
	private boolean esGabKeineProbleme;
	

	public AusnahmenErkenner() {

	}
	/**
	 * Diese Methode (stringArrayToFloatArray) wandelt ein String Array in ein Float Array um
	 * Dabei wird die parseFloat Methode aufgerufen
	 * Außerdem muss aufgrund der dynamischen Wetterdatenlage aufgepasst werden ob 8 oder 9 Array Elemente zurückgegeben werden
	 * Falls null im Array vorkommt wird versucht das Array 
	 * 
	 * @param p_inputStringArray Das String Array, das in ein Float Array umgewandelt werden soll
	 * @return Das output Float Array
	 */
	public float[] stringArrayToFloatArray(String[] p_inputStringArray) {
		inputStringArray = new String[p_inputStringArray.length];
		inputStringArray = p_inputStringArray;

		boolean esGabKeineProbleme = false;
    	int arrayNummerFuerFehlerReport = 0;
    	int arrayNummerFuerFehlerReportV2 = 0;
    	
		try {
    	outputFloatV1 = new float[inputStringArray.length];
        for(int i =0; i < inputStringArray.length; i++) {
        	outputFloatV1[i]=Float.parseFloat(inputStringArray[i]);  
            //System.out.println("Temperatur als float= ["+i+"]= "+inputStringArray[i]); //könnte man sich noch ausgeben lassen
            arrayNummerFuerFehlerReport = i;
        }
        outPutFloatArray = outputFloatV1;
        esGabKeineProbleme = true;
    	}catch(NumberFormatException nfe) {
    		System.out.println("Problem bei Array Element #" + (1+arrayNummerFuerFehlerReport)); //TODO: Locale Variable im try body
    		System.out.println("Folgendes Problem (vermutlich wurde versucht Buchstaben oder andere Zeichen in einen Float zu konvertieren= " + nfe);
//    		throw new NumberFormatException();
    	}
    	

    	
    	//temperaturStringArray[4] = "hehe"; // dem Programm ein Bein stellen
    	
    	if(esGabKeineProbleme == false) {
    		System.err.println("Es kam zu Problemen! Das String Array enhält Zeichen die nicht zu Float konvertiert werden konnten.\nEs wird versucht das String Array zu verkürzen");
    		
    		int exceptionLenght= (inputStringArray.length)-1;
    		
    		try {
//    		float[] outputFloatV2 = new float[exceptionLenght];
    		outputFloatV2 = new float[exceptionLenght];
    		 for(int i =0; i < exceptionLenght; i++) {
    			 outputFloatV2[i]=Float.parseFloat(inputStringArray[i]);  
    	            //System.out.println("Temperatur als float= ["+i+"]= "+outputFloatV2[i]); 
    	            arrayNummerFuerFehlerReportV2 = i;
    	        }
    		 outPutFloatArray = outputFloatV2;
    		}catch(NumberFormatException nfe) {
        		System.out.println("Problem bei Array Element #" + (1+arrayNummerFuerFehlerReportV2)); //TODO: Locale Variable im try body
        		System.out.println("Folgendes Problem (vermutlich wurde versucht Buchstaben oder andere Zeichen in einen Float zu konvertieren= " + nfe);
        		throw new NumberFormatException();
        	}
    	}

    	return outPutFloatArray;
}
}
