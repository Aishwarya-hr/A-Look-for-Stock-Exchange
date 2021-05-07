package mahoo_finance;


import javax.swing.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class AddInfo extends JFrame implements ActionListener{
	
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField l13,l14,l15,l16,l17,l18,l19,l20,l21;
	JButton b1,b2;
	java.util.Date sdate;
	java.sql.Date sqldate;
	
	public String stock;
	public AddInfo()
	{
		
		
		setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
		setTitle("Smart look up: Adding of stock exchanges information");
		
		
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
		
		
		l12=new JLabel("trillion");
		
		
		l13=new JTextField();
		l13.setSize(50, 20);
		l13.setLocation(700, 90);
		
		
		l13=new JTextField();
		l14=new JTextField();
		l15=new JTextField();
		l16=new JTextField();
		l17=new JTextField();
		l18=new JTextField();
		l19=new JTextField();
		l20=new JTextField();
		l21=new JTextField();
		l21.setForeground(Color.BLUE);
		b1=new JButton("CLOSE");
		b2=new JButton("UPDATE");
		
		
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
	
		l1.setBounds(100,5, 1000,50);
		l2.setBounds(5,70, 500,500);
		
		l3.setBounds(500,85,100,50);
		l4.setBounds(500,135,100,50);
		l5.setBounds(500,185,100,50);
		l6.setBounds(500,225,100,50);
		l7.setBounds(500,265,100,50);
		l8.setBounds(500,305,150,50);
		l9.setBounds(500,345,100,50);
		l10.setBounds(500,385,100,50);
		l11.setBounds(500,425,100,50);
		
		l12.setBounds(800,310,100,50);
		b1.setBounds(700,540,100,50);
		b2.setBounds(500,540,100,50);
		
		l13.setBounds(650,95,200,30);
		l14.setBounds(650,145,200,30);
		l15.setBounds(650,195,200,30);
		l16.setBounds(650,235,200,30);
		l17.setBounds(650,275,200,30);
		l18.setBounds(650,315,100,30);
		l19.setBounds(650,355,100,30);
		l20.setBounds(650,395,200,30);
		l21.setBounds(650,435,300,30);
		
		b2.addActionListener(this);
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  dispose();
			
			}
		});
		
		add(b1);
		add(b2);
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
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e){

		String s =

		e.getActionCommand();//System.out.println(s);

		if (s.equals("UPDATE")) {
		String location = l13.getText();
		
		String Founded = l14.getText();
		//convert string to date
		try {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		sdate = sdf.parse(Founded);
		
		sqldate = new java.sql.Date(sdate.getTime());
		
		//System.out.println(sqldate);
		}
		catch(ParseException r)
		{
			System.out.println(r);
		}
		
		String chairman = l15.getText();
		String ceo = l16.getText();
		String Currency = l17.getText();
		String Market_cap = l18.getText();
		double marketcap =Double.parseDouble(Market_cap);
		
		String listings = l19.getText();
		int listing = Integer.parseInt(listings);
		
		String indices = l20.getText();
		String website = l21.getText();
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
String query1 = "update info_se set location=?,founded=?,currency=?,market_cap=?,website=?,indices=?,chairman=?,ceo=?, no_of_listings=? where stock_exchange =?";
			
PreparedStatement stmt2=conn.prepareStatement(query1);
stmt2.setString(10,stock);
stmt2.setString(1,location);
stmt2.setDate(2, sqldate);
stmt2.setString(3,Currency);
stmt2.setDouble(4,marketcap);
stmt2.setString(5,website);
stmt2.setString(6,indices);
stmt2.setString(7,chairman);
stmt2.setString(8,ceo);
stmt2.setInt(9,listing);

int i=stmt2.executeUpdate();
stmt2.close();
conn.close();
System.out.println(i);
JOptionPane.showMessageDialog(null, "records updated succesfully");
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
			System.out.println(e1);
		}
		finally
		{
			JOptionPane.showMessageDialog(null, "database connection closed");
		}
	}
	
	}
public  void PrintLabel(String s)
	{
		Font f2 =new Font("Cambria",Font.PLAIN,20);
		l12.setFont(f2);
		
		stock = s;
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
	
	
	public static void main(String[] args)  {
		String s ="Nasdaq";
		AddInfo obj1 = new AddInfo();
		obj1.PrintLabel(s);
		

	}

}
