/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AWTGUIDemo;
import java.awt.BorderLayout;
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
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Font;
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
    private static Panel topPanel;
    private static Panel middlePanel;
    private static Panel bottomPanel;
    private static Panel bottomLeftPanel;
    private static Panel bottomRightPanel;
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
    private static Converter converter;
    
    public static void main(String args[]){
        converter = new Converter();
        createCheckboxes();
        prepareGUI();
        eventHandlers();
        closeWindow();
    }//close main
    
    
    public static void createCheckboxes(){
        //create checkboxGroups for radio button interaction
        distanceFrom = new CheckboxGroup();
        distanceTo = new CheckboxGroup();
        
       //create each checkbox, Label, set CheckboxGroup, isBoxChecked
        milesTo = new Checkbox("Miles",distanceTo,false);
        milesFrom = new Checkbox("Miles",distanceFrom,false);
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
        mainFrame.setSize(600,275);
        mainFrame.setLayout(new BorderLayout());
        
        //create input Labels
        fromLabel = new Label("Convert From:");
        Font unitFont = new Font("",Font.BOLD,14);
        toLabel = new Label("Convert To:");
        fromLabel.setFont(unitFont);
        toLabel.setFont(unitFont);
        
        //crete input textField and instruction Label
        userTypesHere = new TextField("",20);
        textInstruct = new Label("Type Number To Convert:");
        textInstruct.setFont(new Font("",Font.BOLD,14));
        
        //create panel for units from checkboxes
        leftTopPanel = new Panel(new GridLayout(5,1));
        
        //add checkboxes to leftTopPanel
        leftTopPanel.add(fromLabel);
        leftTopPanel.add(milesFrom);
        leftTopPanel.add(kilometersFrom);
        leftTopPanel.add(leaguesFrom);
        leftTopPanel.add(nMilesFrom);
        
        //crete Panel for units to checkboxes
        rightTopPanel = new Panel(new GridLayout(5,1));
        
        //add checkboxes to rightTopPanel
        rightTopPanel.add(toLabel);
        rightTopPanel.add(milesTo);
        rightTopPanel.add(kilometersTo);
        rightTopPanel.add(leaguesTo);
        rightTopPanel.add(nMilesTo);
        
        //create topPanel
        FlowLayout leftAlignLayout = new FlowLayout(FlowLayout.LEFT,25,5);
        topPanel = new Panel(leftAlignLayout);
        mainFrame.add(topPanel, BorderLayout.NORTH);
        topPanel.add(leftTopPanel);
        topPanel.add(rightTopPanel);
       
        //create first of two Middle Panels
        middlePanel = new Panel(leftAlignLayout);
        middlePanel.add(textInstruct);
        middlePanel.add(userTypesHere);
        mainFrame.add(middlePanel, BorderLayout.CENTER);
        
        //create second Middle Panel
        bottomPanel = new Panel(new BorderLayout());
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
        bottomLeftPanel = new Panel(leftAlignLayout);
        bottomPanel.add(bottomLeftPanel, BorderLayout.WEST);
        bottomRightPanel = new Panel(leftAlignLayout);
        bottomPanel.add(bottomRightPanel, BorderLayout.CENTER);
        
        //create calculate Button, set Button size and add to mainFrame
        calculateButton = new Button("Calculate");
        calculateButton.setPreferredSize(new Dimension(125,45));
        calculateButton.setFont(new Font("",Font.BOLD,18));
        calculateButton.setBackground(Color.GRAY);
        calculateButton.setForeground(Color.WHITE);
        bottomLeftPanel.add(calculateButton);
        
        
        //create Units From Label and Add to mainFrame
        outputLabel = new Label(converter.getUnitsFrom());
        outputLabel.setFont(unitFont);
        bottomRightPanel.add(outputLabel);
        
        //create exceptionMessage & make it red
        exceptionMessage = new Label();
        exceptionMessage.setForeground(RED);

        //set mainFrame to Visisble
        mainFrame.setVisible(true);
    }//close prepareGUI
    
    private static void eventHandlers(){
        milesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsTo("Miles");
            }
        });
        
        kilometersTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsTo("Kilometers");
            }
        }); 
        
        leaguesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               converter.setUnitsTo("Leagues");
            }
        });
        
        nMilesTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsTo("Nautical Miles");
            }
        });
        
        milesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsFrom("Miles");
            }
        });
        
        kilometersFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsFrom("Kilometers");
            }
        });
        
        leaguesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsFrom("Leagues");
            }
        });
        
        nMilesFrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                converter.setUnitsFrom("Nautical Miles");
            }
        });
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    bottomRightPanel.removeAll();
                    String input = userTypesHere.getText().replace(" ", "");
                    Double number = Double.valueOf(input);
                    converter.setBeingConverted(number);
                    exceptionMessage.setText("");
                    outputLabel.setText(converter.getBeingConverted() + " " +
                        converter.getUnitsFrom() + " is equal to " + 
                        converter.calculateAnswer() + " " + converter.getUnitsTo() );
                    bottomRightPanel.add(outputLabel);
                    mainFrame.setVisible(true);
                }catch(NumberFormatException e){
                    userTypesHere.setText("");
                    bottomRightPanel.removeAll();
                    exceptionMessage.setText("Incorrect number entry: Try Again!");
                    bottomRightPanel.add(exceptionMessage);
                    mainFrame.setVisible(true);
                }
                
            }
        });
        
    }
}
    

    

    
       
    
