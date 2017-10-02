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
public class TextCons {
    
    // check to see is " " are going through properly!
    public static ArrayList textToDecimal(String text){
        ArrayList dec = new ArrayList();
        int y = 0;
        char[] chars = text.toCharArray();
        for(int s = 0; s < chars.length; s++){
            if(chars[s] == ' ') y = 255;
            else y = Character.getNumericValue(chars[s]);
            dec.add(y);
        }
        
        return dec;
    }
    
    
    
    public static String decimalToText(ArrayList dec){
        String ch = "";
        for(int num = 0; num < dec.size(); num++){
            int y;
            String yb4;
            yb4 = dec.get(num).toString();
            y = Integer.parseInt(yb4);
            ch = ch.concat(String.valueOf(Character.forDigit(y, y+1)));
            }
        return ch;
    }
    
}
