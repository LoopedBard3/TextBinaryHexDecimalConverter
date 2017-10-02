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
public class HexCons {
    
    public static ArrayList hexToDecimal(String hex){
        ArrayList hexad = new ArrayList();
        for(int num = 1; num <= hex.length()/2; num++){
            String doub = "";
            Integer outputDecimal = 0;
            for(int dual = 0; dual < 2; dual++){
                doub = doub + hex.charAt(dual + (num - 1)*2);
                outputDecimal = Integer.valueOf(doub, 16);
            }
            hexad.add(outputDecimal);
        }
        return hexad;
    }
    
    
    
    public static String decimalToHex(ArrayList dec){
    String hex = "";
        
        for(int num = 0; num < dec.size(); num++){
            String y = "";   
            y = dec.get(num).toString();
            int i = Integer.parseInt(y);
            for(int zero = Integer.toHexString(i).length(); zero < 2; zero++){
                hex += "0";
            }
            hex += Integer.toHexString(i);
        }
        return hex;
}
}
