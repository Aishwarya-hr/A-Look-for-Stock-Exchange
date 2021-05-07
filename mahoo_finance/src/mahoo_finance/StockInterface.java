package mahoo_finance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StockInterface extends JFrame{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	public StockInterface()
	{
		
		
		b1=new JButton("BSE");
		b2=new JButton("NSE");
		b3=new JButton("NASDAQ");
		b5=new JButton("TSE");
		b6=new JButton("LSE");
		b7=new JButton("HANG SENG");
		b8=new JButton("DOW");
		b4=new JButton("EXIT");
		b1.setBounds(200,100,100,50);
		b2.setBounds(310,100,100,50);
		b3.setBounds(420,100,100,50);
		b5.setBounds(540,100,100,50);
		b6.setBounds(200,250,100,50);
		b7.setBounds(310,250,100,50);
		b8.setBounds(420,250,100,50);
		b4.setBounds(700,600,200,50);
		b4.setForeground(Color.RED);
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  dispose();
			
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				String a ="BSE"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
			
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="NSE"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="Nasdaq"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="TSE"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="LSE"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="HangSeng"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String a ="DOW"; 
				StockInfo s1 = new StockInfo();
				s1.getValues(a);
		
			}
		});
		
	    setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
	    
		
		JLabel l1 = new JLabel();
		
		JLabel l2 = new JLabel("                              MAHOO FINANCE");
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		l2.setBounds(100, 0, 1000, 40);
		add(l2);
		l1.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP1.jpg"));
		add(l1);
		
		l1.setSize(1000,700);
	    l1.setLocation(40,5);
		setTitle("Smart look up:Stock Interface ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	
	    l1.add(b1);
	    l1.add(b2);
	    l1.add(b3);
	    l1.add(b4);
	    l1.add(b5);
	    l1.add(b6);
	    l1.add(b7);
	    l1.add(b8);
	   
	    
	    
	    
	    
		setVisible(true);
	}

	public static void main(String[] args) {
		new StockInterface();

	}

}
