package mahoo_finance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import java.text.SimpleDateFormat;

import javax.swing.*;

public class StockInfo extends JFrame{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b1,b2,b3,b4;
	
	ResultSet i=null;
	 PreparedStatement stmt4 =null;
	 public String stock;
	public StockInfo()
	{
		setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
	    
	     l1 = new JLabel();
	     l1.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP8.jpg"));
	     l2 = new JLabel("                               MAHOO FINANCE");
	     l3 = new JLabel();
	     l4 = new JLabel();
	     l5 = new JLabel();
	     l6 = new JLabel();
	     l7 = new JLabel();
	     l8 = new JLabel(" % ");
	     
	     b1=new JButton("EXIT");
	     b2=new JButton("INFO");
	     b3=new JButton("HISTORY");
	     b4=new JButton("COMPONENT");
	     
	     
	    		 
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,40);
		
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		
		Font g =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l3.setFont(g);
		l3.setForeground(Color.BLACK);
		
		Font h =new Font("Cambria",Font.CENTER_BASELINE ,25);
		l4.setFont(h);
		l5.setFont(h);
		l7.setFont(h);
		l8.setFont(h);
		
		b1.setForeground(Color.BLACK);
		l4.setForeground(Color.BLUE);
		//l5.setForeground(Color.GRAY);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(l7);
		add(l8);
		
		
		
		l1.setSize(1000,700);
	    l1.setLocation(40,5);
	    l2.setBounds(100, 0, 1000, 40);
	    l3.setBounds(200, 70, 1000, 40);
	    l7.setBounds(800, 100, 200, 100);
	    b1.setBounds(700,600,100,50);
	    l4.setBounds(600, 150,200, 70);
	    l5.setBounds(600, 200,260, 70);
	    l8.setBounds(650, 200,200, 70);
	    
	    b2.setBounds(500,400,130,50);
	    b3.setBounds(650,400,130,50);
	    b4.setBounds(800,400,130,50);
	    
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  dispose();
			
			}
		});
	    
	    
	    
	    
	    
		setTitle("Smart look up:Stock information ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void getValues(String st1)
	{
		
		stock = st1;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
		
			String query1 = "select * from stock_info where  stock_exchange = ? order by sdate desc limit 1";
			
			stmt4=conn.prepareStatement(query1);
			stmt4.setString(1, st1);
			
			i=stmt4.executeQuery();
			while(i.next()) {
			    String stock_exchange=i.getString(1);
				Date sdate=new Date();
				sdate =i.getDate(2);
				Double Current_prize=i.getDouble(3);			
				Double inc_dec=i.getDouble(4);
				//System.out.println(stock_exchange+" "+sdate+" "+Current_prize+" "+inc_dec);
				l3.setText(stock_exchange); 
				String s = Double.toString(Current_prize);
				String s1 = Double.toString(inc_dec);
				l4.setText(s);
				l5.setText(s1);
				
				SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
				String date= sdf.format(sdate);
				l7.setText(date);
			}
				
				
				
			
			 stmt4.close();
			 conn.close();
		}
		catch(Exception e){
			System.out.println(e);
			}
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				HistTable t = new HistTable();
				t.CreateWindow();
				t.HistoricalData(st1);
				
			
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				Components t1= new Components();
				t1.CreateWindow();
				t1.ComponentData(st1);
				
			
			}
		});
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				SEInfo obj1 = new SEInfo();
				obj1.PrintLabel(st1);
				obj1.DataFromTable(st1);
				
			
			}
		});
		
		
	}

	public static void main(String[] args) {
		String a ="BSE"; 
		StockInfo s1 = new StockInfo();
		s1.getValues(a);
		
		// TODO Auto-generated method stub

	}

}
