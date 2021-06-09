//program to make our own Calculator
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyCalculator extends JFrame implements ActionListener
{
	JPanel[] row = new JPanel[5];
	//Added two more panel.

	JButton[] button = new JButton[16];
	//Added new buttons.
    
	String[] buttonString = {"7", "8", "9", "+",
                         	"4", "5", "6", "-",
                         	"1", "2", "3", "*",
                         	"0", "/", "C", "="};
   
	int[] dimW = {300,45,100,90};
	int[] dimH = {44,40};
	Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
	Dimension regularDimension = new Dimension(dimW[3], dimH[1]);
    
	boolean[] function = new boolean[4];
	double[] temporary = {0, 0};
    
	JTextArea display = new JTextArea(1,20);
	Font font = new Font("Times new Roman", Font.BOLD, 14);
	MyCalculator()
	{
    	super("Badal's Calculator");
    	setDesign();
    	setSize(400,350);
    	setResizable(false);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	GridLayout grid = new GridLayout(5,5);
    	setLayout(grid);
   	 
    	for(int i = 0; i < 4; i++)
        	function[i] = false;
   	 
    	FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
    	FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
   	 
    	for(int i = 0; i < 5; i++)
        	row[i] = new JPanel();
    	row[0].setLayout(f1);
   	 
    	for(int i = 1; i < 5; i++)
        	row[i].setLayout(f2);
   	 
    	for(int i = 0; i < 16; i++)
    	{
        	button[i] = new JButton();
        	button[i].setBackground(Color.RED);
        	button[i].setText(buttonString[i]);
        	button[i].setFont(font);
        	button[i].addActionListener(this);
    	}
   	 
    	display.setFont(font);
    	display.setEditable(false);
    	display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    	display.setPreferredSize(displayDimension);
        display.setBackground(Color.CYAN);
   	  
    	for(int i = 0; i < 16; i++)
        	button[i].setPreferredSize(regularDimension);
   	 
    	row[0].add(display);
    	add(row[0]);
   	 
    	for(int i = 0; i < 4; i++)
        	row[1].add(button[i]);
        	add(row[1]);
   	 
    	for(int i = 4; i < 8; i++)
        	row[2].add(button[i]);
   		 add(row[2]);
 	 
    	for(int i = 8; i < 12; i++)
        	row[3].add(button[i]);
   		 add(row[3]);
   	 
 	 
    	for(int i = 12; i < 16; i++)
        	row[4].add(button[i]);
   		 add(row[4]);
   	 
   	 
    	setVisible(true);
	}
    
	public void clear()
	{
    	try {
        	display.setText("");
        	for(int i = 0; i < 4; i++)
            	function[i] = false;
        	for(int i = 0; i < 2; i++)
            	temporary[i] = 0;
    	} catch(NullPointerException e)
    	{
   		 display.setText("Error");
    	}
	}
    
	public void getResult()
	{
    	double result = 0;

    	String stringTemp = display.getText();
    	
    	String split[]= stringTemp.split("(\\+)|(\\-)|(\\*)|(\\/)");
    	temporary[1] = Double.parseDouble(split[1]);
    	
   	 
   	 
    	String temp0 = Double.toString(temporary[0]);
    	String temp1 = Double.toString(temporary[1]);
 
    	try
    	{
        	if(temp0.contains("-"))
        	{
            	String[] temp00 = temp0.split("-", 2);
            	temporary[0] = (Double.parseDouble(temp00[1]) * -1);
        	}
        	if(temp1.contains("-"))
        	{
            	String[] temp11 = temp1.split("-", 2);
            	temporary[1] = (Double.parseDouble(temp11[1]) * -1);
        	}
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
   		 display.setText("Error");
    	}
   	 
    	try
    	{
        	if(function[2] == true)
            	result = temporary[0] * temporary[1];
        	else if(function[3] == true)
            	result = temporary[0] / temporary[1];
        	else if(function[0] == true)
            	result = temporary[0] + temporary[1];
        	else if(function[1] == true)
            	result = temporary[0] - temporary[1];
        	display.setText(Double.toString(result));
        	for(int i = 0; i < 4; i++)
            	function[i] = false;
    	} catch(NumberFormatException e)
    	{
   		 display.setText("Error");
    	}
	}
    
	public final void setDesign() {
    	try {
        	UIManager.setLookAndFeel(
                	"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch(Exception e)
    	{   
   		 display.setText("Error");
    	}
	}

    
	public void actionPerformed(ActionEvent ae)
	{
    	if(ae.getSource() == button[0])
        	display.append("7");
    	if(ae.getSource() == button[1])
        	display.append("8");
    	if(ae.getSource() == button[2])
        	display.append("9");
    	if(ae.getSource() == button[3])
    	{
        	//Add
        	temporary[0] = Double.parseDouble(display.getText());
        	function[0] = true;
        	display.append("+");
     	 
    	}
    	if(ae.getSource() == button[4])
        	display.append("4");
    	if(ae.getSource() == button[5])
        	display.append("5");
    	if(ae.getSource() == button[6])
        	display.append("6");
    	if(ae.getSource() == button[7])
    	{
        	//Subtract
        	temporary[0] = Double.parseDouble(display.getText());
        	function[1] = true;
        	display.append("-");
    	}
   	 
    	if(ae.getSource() == button[8])
        	display.append("1");
    	if(ae.getSource() == button[9])
        	display.append("2");
    	if(ae.getSource() == button[10])
        	display.append("3");
    	if(ae.getSource() == button[11])
    	{
        	//Multiply
        	temporary[0] = Double.parseDouble(display.getText());
        	function[2] = true;
        	display.append("*");
    	}
   	 

    	if(ae.getSource() == button[13])
    	{
        	//Divide
        	temporary[0] = Double.parseDouble(display.getText());
        	function[3] = true;
        	display.append("/");
    	}
    	if(ae.getSource() == button[14])
        	clear();
    	if(ae.getSource() == button[15])
        	getResult();
    	if(ae.getSource() == button[12])
        	display.append("0");
   	 
	}
    
	public static void main(String[] arguments)
	{
    	MyCalculator c = new MyCalculator();
	}
}
