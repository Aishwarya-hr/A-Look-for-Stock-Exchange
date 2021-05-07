package mahoo_finance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminInterface {
	
	JFrame jf;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	
	AdminInterface()
	{
		jf=new JFrame();
		b1=new JButton("ADD");
		b2=new JButton("SHOW");
		b3=new JButton("UPDATE");
		b4=new JButton("Historical data");
		b5=new JButton("Components");
		b6=new JButton("Stock Data");
		b7=new JButton("Historical data");
		b8=new JButton("Components");
		b9=new JButton("About Stock Exchange");
		b11=new JButton("About Stock Exchange");
		b10=new JButton("close");
		
		b1.setBounds(200,100,150,50);
		b2.setBounds(400,100,150,50);
		b3.setBounds(600,100,150,50);
		b4.setBounds(200,200,200,50);
		b5.setBounds(200,300,200,50);
		b6.setBounds(200,400,200,50);
		b7.setBounds(400,200,200,50);
		b8.setBounds(400,300,200,50);
		b11.setBounds(400,400,200,50);
		b9.setBounds(600,200,200,50);
		b10.setBounds(700,600,200,50);
		
		
		jf.setLayout(null);
	    jf.setSize(1000,700);
	    jf.setLocation(100,30);
		jf.setTitle("Smart look up: Interface to Admin");
		
		
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		jf.add(b4);
		jf.add(b5);
		jf.add(b6);
		jf.add(b7);
		jf.add(b8);
		jf.add(b9);
		jf.add(b10);
		jf.add(b11);
		
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  jf.dispose();
			
			}
		});
		
		
		
		
        JLabel l1 = new JLabel();
		
		JLabel l2 = new JLabel("                              MAHOO FINANCE");
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		l2.setBounds(100, 0, 1000, 40);
		jf.add(l2);
		l1.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP1.jpg"));
		jf.add(l1);
		
		l1.setSize(1000,700);
	    l1.setLocation(20,5);
		jf.setTitle("Smart look up:Admin Interface ");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
	}
	
	void method(String s)
	{
		//Addition of historical data
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AddData obj1 = new AddData();
				obj1.PrintLabel(s);
			  
			
			}
		});
		
		//addition of components
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				AddComponent obj1 = new AddComponent();
				obj1.PrintLabel(s);
			
			}
		});
		
		//addtion of stock data
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				AddStockData obj1 = new AddStockData();
				obj1.PrintLabel(s);
			
			}
		});
		
		//show historical data
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				HistTable t = new HistTable();
				t.CreateWindow();
				t.HistoricalData(s);
			
			}
		});
		//show components data
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				Components t1= new Components();
				t1.CreateWindow();
				t1.ComponentData(s);
			
			}
		});
		//update stock exchanges information
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				AddInfo obj1 = new AddInfo();
				obj1.PrintLabel(s);
			
			}
		});
		
		
		//show stock exchange data
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				
				StockExchange t2= new StockExchange();
				t2.CreateWindow();
				t2.StockExchangeData(s);
			
			}
		});
		
	}
	
	

	public static void main(String[] args) {
		AdminInterface obj=new AdminInterface();
		obj.method("BSE");

	}

}
