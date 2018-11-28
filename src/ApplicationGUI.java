
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;  

public class ApplicationGUI {
	
	private final static int FRAME_WIDTH = 600;
	private final static int FRAME_HEIGHT = 500;
	private final static int LEFT_PANEL_YCOORD = 50;
	
	private JFrame frame;
	private DataService dataService;
	

	public ApplicationGUI() {
		this.frame = new JFrame();//creating instance of JFrame  
		//this.seq = s;
		initWindow();
		dataService = new DataService();
	}
	
	//add simple elements to window
	private void initWindow() {
		
		//left panel
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0,LEFT_PANEL_YCOORD, FRAME_WIDTH/2, FRAME_HEIGHT);
		leftPanel.setBackground(Color.GRAY);
		frame.add(leftPanel);
		
		//left label
		JLabel leftLable = new JLabel("Enter your sequences (name + sequece)");
		leftLable.setBounds(0, 0, leftPanel.getWidth(), leftPanel.getY());
		frame.add(leftLable);
		
		//left text area
		JTextArea inputText = new JTextArea("[separate items by new lines] \n"
				+ "[Sequences must have the same length]\n"
				+ "Example: \n"
				+ "human atcatcatc \n"
				+ "cat attccgg");
		//create scroll for input area
		JScrollPane inputBoxScroll = new JScrollPane(
				inputText,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
				);
		inputBoxScroll.setMinimumSize(new Dimension(leftPanel.getWidth(),leftPanel.getHeight()));
		inputBoxScroll.setPreferredSize(new Dimension(leftPanel.getWidth(),leftPanel.getHeight()-80));
		//create border
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    inputText.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		//doesn't need to add inputText as already included in inputBoxScroll
		leftPanel.add(inputBoxScroll);
		
		//right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(FRAME_WIDTH/2, 0, FRAME_WIDTH/2, FRAME_HEIGHT);
		rightPanel.setBackground(Color.DARK_GRAY);
		frame.add(rightPanel);

		//testing
		JButton button = new JButton();
		button.setText("Get input text");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = inputText.getText();
				
				if(dataService.isValidData(s)) dataService.insertData(s);
				else System.out.println(dataService.getValidateError());
				frame.revalidate();
				frame.repaint();
			}});
		
		button.setBounds(100, 100, 100, 50);
		rightPanel.add(button);
		          
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);//600 width and 500 height  
		
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
}