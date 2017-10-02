/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfromanyattempt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
//import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author pbibu
 */
public class Textfromanyattempt extends JPanel{
    private final String[] inouts = {"text","decimal","binary","hexadecimal"};
    
    private int input;
    private int output;

    
    JComboBox inputBox;
    JComboBox outputBox;
    JLabel inputLabel;
    JLabel outputLabel;
    JTextArea convertedOut;
    JTextArea inputField;

class getInputSelected implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        input = inputBox.getSelectedIndex();
        switch(input){
            case 0:
                inputLabel.setText("Please put in your text:");
                break;
            case 1:
                inputLabel.setText("Please put in decimals like d1,d2,d3...:");
                break;
            case 2:
                inputLabel.setText("Please put in binary without separators:");
                break;
            case 3:
                inputLabel.setText("Please put in hexadecimal without separators:");
                break;
                
        }
    }
}
    

class doItBtnListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        input = inputBox.getSelectedIndex();
        output = outputBox.getSelectedIndex();
        String out = "";
        ArrayList decimal = new ArrayList();
        switch(inouts[input]){
            
        case("binary"):
            decimal = BinaryCons.binaryToDecimal(inputField.getText());
            break;
            
        case("decimal"):
            String[] decs = inputField.getText().replaceAll(" ", "").split(",");
            decimal = new ArrayList<> (Arrays.asList(decs));
            break;
            
        case("hexadecimal"):
            decimal = HexCons.hexToDecimal(inputField.getText());
            break;
            
        case("text"):
            decimal = TextCons.textToDecimal(inputField.getText());
            break;

    }
        
        
        switch(inouts[output]){                
            case("decimal"):
                out = decimal.toString();
                break;
                
            case("binary"):
                out = BinaryCons.decimalToBinary(decimal);
                break;
                
            case("hexadecimal"):
                out = HexCons.decimalToHex(decimal);
                break;
            
            case("text"):
                out = TextCons.decimalToText(decimal);
                break;
        }
        convertedOut.setText(out);
        
    }
}



    public void setUpComponents(){
        JFrame window = new JFrame("Convert some things");
        
        window.setBounds(100,60,900,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel outP = new JPanel();
        Color myColor;
        myColor = new Color(245,245,245);
        
        outP.setBackground(myColor);
        inputField = new JTextArea("Text Input", 25,75);
        inputField.setLineWrap(true);
        convertedOut = new JTextArea("Text Output", 25,75);
        convertedOut.setLineWrap(true);
        outP.add(inputField);
        outP.add(convertedOut);
        Container c = window.getContentPane();
        c.add(BorderLayout.CENTER,outP);
        
        JPanel ctrlP = new JPanel();
        inputBox = new JComboBox(inouts);
        inputBox.setSelectedIndex(0);
        inputBox.addActionListener(new getInputSelected());
        outputBox = new JComboBox(inouts);
        outputBox.setSelectedIndex(0);
        inputLabel = new JLabel("Choose your input ");
        ctrlP.add(inputLabel);
        ctrlP.add(inputBox);
        outputLabel = new JLabel("Choose your output ");
        ctrlP.add(outputLabel);
        ctrlP.add(outputBox);
        
        
        JButton doItBtn = new JButton("convert");
        doItBtn.addActionListener(new doItBtnListener());
        ctrlP.add(doItBtn);
        c.add(BorderLayout.SOUTH, ctrlP);
        
        window.setVisible(true);
        
        
        
    }



    public static void main(String[] args) {
        
        Textfromanyattempt panel = new Textfromanyattempt();
        
        panel.setUpComponents();
        
     /*   
        
       
        Scanner kboard = new Scanner(System.in);
        String done = "";
        String out = "";
        ArrayList decimal = new ArrayList();
        BinaryCons bc = new BinaryCons();
        TextCons tc = new TextCons();
        HexCons hc = new HexCons();
        
        //System.out.println("attempt " + bc.decimalToBinary(new ArrayList<> (Arrays.asList("2"))));
        do{
        System.out.println("What type of data do you have?(binary, decimal, hexadecimal, text): ");
        String have = kboard.next();
        System.out.println("Please put in the " + have);
        String in = kboard.next();
        in += kboard.nextLine();
        switch(have.toLowerCase()){
            
        case("binary"):
            decimal = BinaryCons.binaryToDecimal(in);
            break;
            
        case("decimal"):
            String[] decs = in.split(",");
            decimal = new ArrayList<> (Arrays.asList(decs));
            break;
            
        case("hexadecimal"):
            decimal = HexCons.hexToDecimal(in);
            break;
            
        case("text"):
            decimal = TextCons.textToDecimal(in);
            break;
            
        case("finish"):
            done = "finish";
            break;
    }
        
        
        
        
        if(!"finish".equals(done)){
        System.out.println("What type of data do you want it to be converted to?(binary, decimal, hexadecimal, text): ");
        String want = kboard.next();
        switch(want.toLowerCase()){                
            case("decimal"):
                out = decimal.toString();
                break;
                
            case("binary"):
                out = BinaryCons.decimalToBinary(decimal);
                break;
                
            case("hexadecimal"):
                out = HexCons.decimalToHex(decimal);
                break;
            
            case("text"):
                out = TextCons.decimalToText(decimal);
                break;
        }
        System.out.println("The conversion output is: ");
        System.out.println(out);
        System.out.println("Would you like to finish or continue(finish or continue): ");
        done = kboard.next();
        }
        
       
        }while(!"finish".equals(done)); 

   */ }
    
}
