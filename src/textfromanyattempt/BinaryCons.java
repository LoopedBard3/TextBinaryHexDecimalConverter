/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfromanyattempt;

import java.util.ArrayList;

/**
 *
 * @author pbibu
 */
public class BinaryCons {
    //Converts binary to decimal
    public static ArrayList binaryToDecimal(String bi){
        //Creates new arraylist to store each individual values
        ArrayList dec = new ArrayList();
        //Loop through in groups of 8
        for(int num = 1; num <= bi.length()/8; num++){
            //y is an accumulator that is reset for each group
            int y = 0;   
            //Goes through the zeros and ones and multiples the value by the proper exponent
            for (int exp = 7; exp >= 0; exp--){
                y += Integer.parseInt(String.valueOf(bi.charAt(Math.abs(exp - 7) + (num-1) * 8))) * Math.pow(2,Math.abs(exp));               
            }
            dec.add(y);      
        }
        return dec;
    }
    
    
    
    
    public static String decimalToBinary(ArrayList dec){
        //StringBuilder binary = new StringBuilder();
        String bi = "";
        
        for(int num = 0; num < dec.size(); num++){
            String y = "";
            
            y = dec.get(num).toString();
            int i = Integer.parseInt(y);
            for(int zero = Integer.toBinaryString(i).length(); zero < 8; zero++){
                bi += "0";
            }
            bi += Integer.toBinaryString(i);
        }
        return bi;
}
    
}



