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
    
    public static void setUnitsTo(String units){
        unitsTo = units;    
    }
    
    public static String getUnitsTo(){
        return unitsTo;
    }
    
    public static void setUnitsFrom(String units){
        unitsFrom = units;
    }
    
    public static String getUnitsFrom(){
        return unitsFrom;
    }
    
    public static void setInMiles(double converted){
        inMiles = converted;
    }
    
    public static void setConversionFactor(double convert){
        conversionFactor = convert;
    }
    
    public static void setBeingConverted(double typed){
        beingConverted = typed;
    }
    
    public static double getBeingConverted(){
        return beingConverted;
    }
    
    public static double getAnswer(){
        return answer;
    }
    
    public static double calculateAnswer(){
        answer = inMiles * conversionFactor * beingConverted;
        return answer;
    }
}
