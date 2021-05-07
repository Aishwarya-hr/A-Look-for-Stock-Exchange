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

public class AddStockData extends JFrame implements ActionListener{
	
	
	JLabel l1,l2,l4,l5,l6;
	JTextField l14,l15,l16;
	JButton b1,b2;
	java.util.Date sdate;
	java.sql.Date sqldate;
	
	public String stock;
	public AddStockData()
	{
		
		
		setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
		setTitle("Smart look up: Adding of stock exchanges information");
		
		
		l1=new JLabel();
		l2=new JLabel();
		
		l4=new JLabel("Date");
		l5=new JLabel("Current Stock Rate");
		l6=new JLabel("Inc/Dec in Stock");
		
		
		
		
		
		l14=new JTextField();
		l15=new JTextField();
		l16=new JTextField();
		
		
		
		b1=new JButton("CLOSE");
		b2=new JButton("ADD");
		
		
		add(l14);
		add(l15);
		add(l16);
		
		
	
		l1.setBounds(100,5, 1000,50);
		l2.setBounds(5,70, 500,500);
		
		
		l4.setBounds(450,135,200,50);
		l5.setBounds(450,185,200,50);
		l6.setBounds(450,225,200,50);
		
		
		b1.setBounds(700,540,100,50);
		b2.setBounds(500,540,100,50);
		
		
		l14.setBounds(650,145,200,30);
		l15.setBounds(650,195,200,30);
		l16.setBounds(650,235,200,30);
		
	
		
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
		
		add(l4);
		add(l5);
		add(l6);
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e){

		String s =

		e.getActionCommand();//System.out.println(s);

		if (s.equals("ADD")) {
		
		
			String sdate = l14.getText();
			try {
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
			Date daterec = sdf.parse(sdate);
			
			sqldate = new java.sql.Date(daterec.getTime());
			
			
			}
			catch(ParseException r)
			{
				System.out.println(r);
			}
			
			
			
			String current = l15.getText();
			double currentd =Double.parseDouble(current);
			
			String inc_dec = l16.getText();
			double inc_decd =Double.parseDouble(inc_dec);
			
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
String query1 = "insert into  stock_info values(?,?,?,?)";
			
PreparedStatement stmt2=conn.prepareStatement(query1);

stmt2.setString(1,stock);
stmt2.setDate(2,sqldate);
stmt2.setDouble(3,currentd);
stmt2.setDouble(4,inc_decd);



stmt2.executeUpdate();
stmt2.close();
conn.close();

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
		
		
		stock = s;
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,20);
		
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		
		
		Font f3 =new Font("Cambria",Font.PLAIN,20);
		
		l14.setFont(f3);
		l15.setFont(f3);
		l16.setFont(f3);
		
		
		
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
		String s ="BSE";
		AddStockData obj1 = new AddStockData();
		obj1.PrintLabel(s);
		

	}

}


