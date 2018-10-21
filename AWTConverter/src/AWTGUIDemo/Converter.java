/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AWTGUIDemo;

/** 
* 
* @author eliza 
*/ 
public class Converter { 
    private static double answer; 
    private static String unitsTo; 
    private static String unitsFrom; 
    private static double inMiles; 
    private static double conversionFactor; 
    private static double beingConverted; 

   
   
    
    /**
     * Calculates the answer based on previous information
     * @return the answer
     */
    public double calculateAnswer(){ 
        doConversionFactors();
        answer = inMiles * conversionFactor * getBeingConverted(); 
        if(getUnitsTo().equals(getUnitsFrom())){
            answer = getBeingConverted();
        }//close if
        
        answer = Math.round(getAnswer() * 100);
        answer = getAnswer()/100;
        return getAnswer(); 
    }//close calculateAnswer
    
    /**
     * sets conversion factors based on user's chosen units
     */
    private void doConversionFactors(){
        switch(getUnitsTo()){
            case "Miles":
                this.setConversionFactor(1);
                break;
            case "Kilometers":
                this.setConversionFactor(1.609344);
                break;
            case "Leagues":
                this.setConversionFactor(0.28965875);
                break;
            case "Nautical Miles":
                this.setConversionFactor(0.86897624);
                break;
            default:
                this.setConversionFactor(1);
                break;
        }//close switch
        switch(getUnitsFrom()){
            case "Miles":
                this.setInMiles(1);
                break;
            case "Kilometers":
                this.setInMiles(0.62137119);
                break;
            case "Leagues":
                this.setInMiles(3.45233834);
                break;
            case "Nautical Miles":
                this.setInMiles(1.15077945);
                break;
            default:
                this.setConversionFactor(1);
                break;
        }//close switch
    }//close doConversionFactors

    /**
     * @return the unitsTo
     */
    public String getUnitsTo() {
        return unitsTo;
    }

    /**
     * @param unitsTo the unitsTo to set
     */
    public void setUnitsTo(String unitsTo) {
        this.unitsTo = unitsTo;
    }

    /**
     * @return the unitsFrom
     */
    public String getUnitsFrom() {
        return unitsFrom;
    }

    /**
     * @param unitsFrom the unitsFrom to set
     */
    public void setUnitsFrom(String unitsFrom) {
        this.unitsFrom = unitsFrom;
    }

    /**
     * @return the answer
     */
    public double getAnswer() {
        return answer;
    }

    /**
     * @return the beingConverted
     */
    public double getBeingConverted() {
        return beingConverted;
    }

    /**
     * @param inMiles the inMiles to set
     */
    public void setInMiles(double inMiles) {
        this.inMiles = inMiles;
    }

    /**
     * @param conversionFactor the conversionFactor to set
     */
    public void setConversionFactor(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * @param beingConverted the beingConverted to set
     */
    public void setBeingConverted(double beingConverted) {
        this.beingConverted = beingConverted;
    }
} 
