
package mahoo_finance;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;


public class About extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	JFrame frame = new JFrame();
	
	JLabel l1 = new JLabel("                     ABOUT MAHOO FINANCE ");
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JButton b1 =new JButton("PDF:KNOW MORE ABOUT STOCK MARKET");
	
	
	
	
	
	 About()
	{
		frame.setLayout(new BorderLayout());
	    frame.setSize(850,700);
		frame.setLocation(100,50);
		frame.setTitle("Smart look up:About ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l1.setFont(f);
		
		l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP6.png"));
		l3.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP3.png"));
		
		frame.add(l1,BorderLayout.NORTH);
		frame.add(l2,BorderLayout.WEST);
		frame.add(l3,BorderLayout.EAST);
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				
				openPDF();
				frame.dispose();
			
			}
		});
		
		frame.add(b1,BorderLayout.SOUTH);
		

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	void openPDF()
	{
		try {
			  
			if ((new File("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\StockMarket.pdf")).exists()) {

				Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\StockMarket.pdf");
				p.waitFor();

			} else {

				System.out.println("File is not exists");

			}

			

		  } catch (Exception ex) {
			ex.printStackTrace();
		  }

		}
	
	 
	 
	 
	 
	public static void main(String []args)
	{
		new About();
		
	}			
	
	
}


