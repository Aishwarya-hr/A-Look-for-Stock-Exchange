package mahoo_finance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Contact {

	JFrame frame = new JFrame();
	
	
	JLabel l1 = new JLabel("                          CONTACT MAHOO FINANCE ");
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JButton b1 =new JButton("OK");
	public Contact()
	{
		frame.setLayout(new BorderLayout());
		//frame.setSize(0,700);
		frame.setLocation(100,50);
		frame.setTitle("Smart look up:Contact ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l1.setFont(f);
		
		l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP5.jpg"));
		l3.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP4.png"));
		
		frame.add(l1,BorderLayout.NORTH);
		frame.add(l2,BorderLayout.WEST);
		frame.add(l3,BorderLayout.EAST);
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				frame.dispose();
				
			}
		});
		frame.add(b1,BorderLayout.SOUTH);
		

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Contact();
		

	}

}
