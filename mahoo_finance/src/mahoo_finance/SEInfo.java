package mahoo_finance;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SEInfo extends JFrame{
	
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JLabel l16,l17,l18,l19,l20,l21;
	JButton b1;
	
	public SEInfo()
	{
		
		
		setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
		setTitle("Smart look up:stock exchanges information");
		
		
		l1=new JLabel();
		l2=new JLabel();
		
		
		
		l3=new JLabel("Location ");
		l4=new JLabel("Founded ");
		l5=new JLabel("Chairman ");
		l6=new JLabel("CEO");
		l7=new JLabel("Currency");
		l8=new JLabel("Market cap");
		l9=new JLabel("listings ");
		l10=new JLabel("indices ");
		l11=new JLabel("website");
		/*
		*/
		
		l12=new JLabel("trillion");
		l13=new JLabel();
		l14=new JLabel();
		l15=new JLabel();
		l16=new JLabel();
		l17=new JLabel();
		l18=new JLabel();
		l19=new JLabel();
		l20=new JLabel();
		l21=new JLabel();
		b1=new JButton("EXIT");
	
	
		l1.setBounds(100,5, 1000,50);
		l2.setBounds(5,70, 500,500);
		
		l3.setBounds(500,90,100,50);
		l4.setBounds(500,140,100,50);
		l5.setBounds(500,190,100,50);
		l6.setBounds(500,230,100,50);
		l7.setBounds(500,270,100,50);
		l8.setBounds(500,310,150,50);
		l9.setBounds(500,350,100,50);
		l10.setBounds(500,390,100,50);
		l11.setBounds(500,430,100,50);
		
		l12.setBounds(800,310,100,50);
		b1.setBounds(600,540,100,50);
		
		l13.setBounds(700,90,200,50);
		l14.setBounds(700,140,200,50);
		l15.setBounds(700,190,200,50);
		l16.setBounds(700,230,200,50);
		l17.setBounds(700,270,200,50);
		l18.setBounds(700,310,100,50);
		l19.setBounds(700,350,100,50);
		l20.setBounds(700,390,200,50);
		l21.setBounds(700,430,300,50);
		
		
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  dispose();
			
			}
		});
		
		add(b1);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(l14);
		add(l15);
		add(l16);
		add(l17);
		add(l18);
		add(l19);
		add(l20);
		add(l21);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	
	public  void PrintLabel(String s)
	{
		Font f2 =new Font("Cambria",Font.PLAIN,20);
		l12.setFont(f2);
		
		
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,20);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		l8.setFont(f);
		l9.setFont(f);
		l10.setFont(f);
		l11.setFont(f);
		
		Font f1 =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		
		if(s=="BSE") {
			l1.setText("Bombay Stock Exchange");
		l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS1.jpg"));
		}
		if(s=="NSE")
		{
			l1.setText("National Stock Exchange");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS2.jpg"));	
		}
		if(s=="Nasdaq")
		{
			l1.setText("National Association Securities Dealers Automated Quotations");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS3.jpg"));
		}
		if(s=="TSE")
		{
			l1.setText("Tokyo Stock Exchange");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS4.jpg"));
		}
		if(s=="LSE")
		{
			l1.setText("London Stock Exchange");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS5.jpg"));
		}
		if(s=="HangSeng")
		{
			l1.setText("Hang Seng:Hong Kong Stock Exchange");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS7.jpg"));
		}
		if(s=="DOW")
		{
			l1.setText("Dow Jones Industrial Average");
			l2.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PPS6.jpg"));
		}
	}
	
	public void DataFromTable(String stock)
	{
		 ResultSet rs=null;
		 PreparedStatement stmt4 =null; 
		 
		 
		 Font f3 =new Font("Cambria",Font.PLAIN,20);
		l13.setFont(f3);
		l14.setFont(f3);
		l15.setFont(f3);
		l16.setFont(f3);
		l17.setFont(f3);
		l18.setFont(f3);
		l19.setFont(f3);
		l20.setFont(f3);
		l21.setFont(f3);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
String query1 = "select * from info_se where  stock_exchange = ?";
			
			stmt4=conn.prepareStatement(query1);
			stmt4.setString(1, stock);
			
			rs=stmt4.executeQuery();
			
			
			while(rs.next()) {
			    String location=rs.getString(2);
			   
			    Date sdate=new Date();
				sdate =rs.getDate(3);
				SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
				String date= sdf.format(sdate);
				
			    String currency=rs.getString(4);
				
				Double market_cap=rs.getDouble(5);	
				String s = Double.toString(market_cap);
				
				String indices=rs.getString(7);
				String website=rs.getString(6);
				String chairman=rs.getString(8);
				String ceo=rs.getString(9);
				int no_of_listings=rs.getInt(10);
				String s1 = Integer.toString(no_of_listings);
				
				
				l13.setText(location);
				l14.setText(date);
				l15.setText(chairman);
				l16.setText(ceo);
				l17.setText(currency);
				l18.setText(s);
				l19.setText(s1);
				l20.setText(indices);
				l21.setText(website);
				l21.setForeground(Color.BLUE);
			
				
			}
			
			stmt4.close();
			 conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		
	}
	
	public static void main(String[] args)  {
		String s ="Nasdaq";
		SEInfo obj1 = new SEInfo();
		obj1.PrintLabel(s);
		obj1.DataFromTable(s);

	}

}
