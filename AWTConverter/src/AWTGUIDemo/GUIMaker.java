/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AWTGUIDemo;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Checkbox;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eliza
 */
public class GUIMaker {
    private static Frame mainFrame;
    private static Panel leftTopPanel;
    private static Panel rightTopPanel;
    private static Panel leftMiddlePanel;
    private static Panel rightMiddlePanel;
    private static Panel topPanel;
    private static Panel mid1Panel;
    private static Panel mid2Panel;
    private static Panel bottomPanel;
    private static Panel leftPanel;
    private static Panel rightPanel;
    private static Label fromLabel;
    private static Label toLabel;
    private static Label outputLabel;
    private static Label exceptionMessage;
    private static Label textInstruct;
    private static Button calculateButton;
    private static TextField userTypesHere;
    private static Checkbox milesTo;
    private static Checkbox milesFrom;
    private static Checkbox kilometersTo;
    private static Checkbox kilometersFrom;
    private static Checkbox leaguesTo;
    private static Checkbox leaguesFrom;
    private static Checkbox nMilesTo;
    private static Checkbox nMilesFrom;
    private static CheckboxGroup distanceFrom;
    private static CheckboxGroup distanceTo;
    
    public static void main(String args[]){
        createCheckboxes();
        prepareGUI();
        eventHandlers();
        closeWindow();
    }
    
    
    public static void createCheckboxes(){
        //create checkboxGroups for radio button interaction
        distanceFrom = new CheckboxGroup();
        distanceTo = new CheckboxGroup();
        
       //create each checkbox, Label, set CheckboxGroup, isBoxChecked
        milesTo = new Checkbox("Miles",distanceTo,true);
        milesFrom = new Checkbox("Miles",distanceFrom,true);
        kilometersTo = new Checkbox("Kilometers",distanceTo,false);
        kilometersFrom = new Checkbox("Kilometers",distanceFrom,false);
        leaguesTo = new Checkbox("Leagues",distanceTo, false);
        leaguesFrom = new Checkbox("Leagues",distanceFrom,false);
        nMilesTo = new Checkbox("Nautical Miles",distanceTo,false);
        nMilesFrom = new Checkbox("Nautical Miles",distanceFrom, false);
    }//close createCheckboxes
    
    public static void closeWindow(){
        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }

    private static void prepareGUI(){
        //create frame called "Distance Converte"
        mainFrame = new Frame("Distance Converter");
        //set size of frame to 600 x 600 pixels
        mainFrame.setSize(600,600);
        mainFrame.setLayout(new GridLayout(4,1));
        
        
        
        
        fromLabel = new Label("Convert From:");
        toLabel = new Label("Convert To:");
        exceptionMessage = new Label();
        userTypesHere = new TextField("",20);
        textInstruct = new Label("Type Unit To Convert:");
        
        leftPanel = new Panel(new GridLayout(5,1));
        
        leftPanel.add(fromLabel);
        leftPanel.add(milesTo);
        leftPanel.add(kilometersTo);
        leftPanel.add(leaguesTo);
        leftPanel.add(nMilesTo);
        
        topPanel = new Panel();
        mainFrame.add(topPanel);
        topPanel.add(leftPanel);
        
        rightPanel = new Panel(new GridLayout(5,1));
        mainFrame.add(rightPanel);
        
        rightPanel.add(toLabel);
        rightPanel.add(milesFrom);
        rightPanel.add(kilometersFrom);
        rightPanel.add(leaguesFrom);
        rightPanel.add(nMilesFrom);
        
        topPanel.add(rightPanel);
       
        mid1Panel = new Panel(new FlowLayout());
        mid1Panel.add(textInstruct);
        mid1Panel.add(userTypesHere);
        mainFrame.add(mid1Panel);
        
        
        rightMiddlePanel = new Panel(new FlowLayout());
        rightMiddlePanel.add(exceptionMessage);
        
        mainFrame.add(rightMiddlePanel);
        
        
        calculateButton = new Button("Calculate");
        calculateButton.setPreferredSize(new Dimension(10,10));
        mainFrame.add(calculateButton);
        
        outputLabel = new Label(Converter.getUnitsFrom());
        mainFrame.add(outputLabel);
        
        mainFrame.setVisible(true);
        
        
    }
    
    private static void eventHandlers(){
        milesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsTo("Miles");
                Converter.setConversionFactor(1);
            }
        });
        
        kilometersTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsTo("Kilometers");
                Converter.setConversionFactor(1.16);
            }
        }); 
        
        leaguesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               Converter.setUnitsTo("Leagues");
               Converter.setConversionFactor(0.29);
            }
        });
        
        nMilesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsTo("Nautical Miles");
                Converter.setConversionFactor(0.87);
            }
        });
        
        milesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsFrom("Miles");
                Converter.setInMiles(1);
            }
        });
        
        kilometersFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsFrom("Kilometers");
                Converter.setInMiles(0.62);
            }
        });
        
        leaguesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsFrom("Leagues");
                Converter.setInMiles(3.45);
            }
        });
        
        nMilesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Converter.setUnitsFrom("Nautical Miles");
                Converter.setInMiles(1.15);
            }
        });
        
        userTypesHere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    String input = userTypesHere.getText().replace(" ", "");
                    Double number = Double.valueOf(input);
                    Converter.setBeingConverted(number);
                }catch(NumberFormatException e){
                    userTypesHere.setText("");
                    exceptionMessage.setForeground(RED);
                    exceptionMessage.setText("Incorrect Data Type! Numbers Only!");
                    System.out.println(e.toString() +  "\nIncorrect Data Type! Numbers Only!");
                }
                
            }
            
        });
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                exceptionMessage.setText("");
                
            }
        });
        
    }
}
    

    

    
       
    
