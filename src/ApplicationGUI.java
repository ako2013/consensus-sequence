
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class ApplicationGUI {
	
	JFrame f;
	final JTextField tf;
	String seq;

	public ApplicationGUI(String s) {
		this.f = new JFrame();//creating instance of JFrame  
		this.tf= new JTextField();
		initWindow();
		this.seq = s;
	}
	
	//add simple elements to window
	private void initWindow() {
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tf.setText(seq); 
			}  
		});
		          
		f.add(b);//adding button in JFrame  
		          
		f.setSize(400,500);//400 width and 500 height  
		
		tf.setBounds(50,50, 150,20); 
		tf.setText(seq);
		
		f.add(tf);
		
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
		
	}
}