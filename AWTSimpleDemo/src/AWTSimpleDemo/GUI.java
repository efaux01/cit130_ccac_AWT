package AWTSimpleDemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A simple program demonstrating how to use the AWT GUI system
 * @author eliza
 */
public class GUI {
    private static Frame mainFrame;
    private static Panel topPanel;
    private static Panel bottomPanel;
    private static Button button1;
    private static Button button2;
    private static Label instructionLabel;
    private static Label pushedButton1;
    private static Label pushedButton2;
    private static FlowLayout centeredText;
    private static Font labelFont;
    
    
    /**
     * Calls other Methods
     * @param args 
     */        
    public static void main(String args []){
        GUIMaker();
        eventHandlers();
    }//closes main
    
    /**
     * Creates the GUI
     */
    public static void GUIMaker(){
        //Create project Frame(title)
        mainFrame = new Frame("AWT Simple Demo");
        
        //Set mainFrame Layout
        mainFrame.setLayout(new BorderLayout());

        //Set mainFrame size
        mainFrame.setSize(500,250);
        
        //Program the exit button
        mainFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }//Close windowClosing()
        });//Close addWindowListener
        
        //create top  & bottom Panels
        centeredText = new FlowLayout(FlowLayout.CENTER,35,35);
        topPanel = new Panel(centeredText);
        bottomPanel = new Panel(centeredText);
        
        //add Panels to mainFrame
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
        
        //create Buttons
        button1 = new Button("Button 1");
        button2 = new Button("Button 2");
        
        //adjust the size of the Buttons
        Dimension buttonSize = new Dimension(175,55);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        
        //change the font size of the buttons
        Font buttonFont = new Font("",Font.PLAIN, 30);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        
        //add Buttons to topPanel
        topPanel.add(button1);
        topPanel.add(button2);
        
        //create Labels
        instructionLabel = new Label("Push A Button");
        pushedButton1 = new Label("You pushed Button 1");
        pushedButton2 = new Label("You pushed Button 2");
        
        //add instructionLabel to bottomPanel
        bottomPanel.add(instructionLabel);
        
        //create and set Label Font
        labelFont = new Font("",Font.PLAIN,25);
        instructionLabel.setFont(labelFont);
        pushedButton1.setFont(labelFont);
        pushedButton2.setFont(labelFont);
        
        //make Label text green
        instructionLabel.setForeground(Color.GREEN);
        pushedButton1.setForeground(Color.GREEN);
        pushedButton2.setForeground(Color.GREEN);
        
        //Set the mainFrame as visible
        mainFrame.setVisible(true);
    }//Close GUIMaker
    
    
    
    /**
     * EventHandlers for Buttons
     */
    public static void eventHandlers(){
        //EventHandler Button 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bottomPanel.removeAll();
                bottomPanel.add(pushedButton1);
                mainFrame.setVisible(true);
            }//close actionPerformed
        });//close button1.addActionListener
       
        //EventHandler Button 2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bottomPanel.removeAll();
                bottomPanel.add(pushedButton2);
                mainFrame.setVisible(true);
            }//close actionPerformed
        });//close button2.addActoinListener
        
    }//close eventHandlers
}//Glose GUI
