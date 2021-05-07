package mahoo_finance;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CallHistTable {
	JFrame frame = new JFrame();
	JButton b1 =new JButton("OK");
	public CallHistTable()
	{
		frame.setLayout(new BorderLayout());
	    frame.setSize(850,700);
		frame.setLocation(100,50);
		
		frame.setTitle("Smart look up:About ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String b ="BSE";
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				HistTable t = new HistTable();
				t.CreateWindow();
				t.HistoricalData(b);
			
			}
		});
	    frame.add(b1);
		

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		new CallHistTable();

	}

}
