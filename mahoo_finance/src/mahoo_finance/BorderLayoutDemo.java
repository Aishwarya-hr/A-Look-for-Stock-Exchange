package mahoo_finance;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutDemo{
	JFrame frame = new JFrame("Borderlayout demo");
	
	JButton b1 =new JButton("NORTH");
	JButton b2 =new JButton("SOUTH");
	JButton b3 =new JButton("CENTER");
	JButton b4 =new JButton("WEST");
	JButton b5 =new JButton("EAST");
	
	public BorderLayoutDemo()
	{
		frame.setLayout(new BorderLayout());
		frame.setSize(900,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(b1,BorderLayout.NORTH);
		frame.add(b2,BorderLayout.SOUTH);
		frame.add(b3,BorderLayout.CENTER);
		frame.add(b4,BorderLayout.WEST);
		frame.add(b5,BorderLayout.EAST);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String []args)
	{
		new BorderLayoutDemo();		
	}			
	
	
}


