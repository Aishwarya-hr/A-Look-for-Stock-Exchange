package mahoo_finance;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HistTable {
	 public String stockexchange;
	
	 public JTable jt;
	 public void CreateWindow()
	 {
		 JFrame f;
		 
		 f=new JFrame();
	   
		 f.setSize(1000, 700);
		 f.setTitle("smart look up:history");
		 jt=new JTable();
		 
		 jt.setBounds(0,0,400,400);
			// b1.setBounds(700,800,100,100);
			 jt.setBackground(Color.BLUE);
			 jt.setForeground(Color.WHITE);
			 Font font =new Font("Cambria",Font.PLAIN ,20);
			 jt.setFont(font);
			 
			 
			 JScrollPane sp=new JScrollPane(jt); 
			 //b1= new JButton("ok");
			 sp.setBounds(0, 0, 400, 400);
			// f.add(b1);
			 f.add(sp);
			 
			 
			 f.setVisible(true);
			 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 }
	
	public void HistoricalData(String st)
	{
		stockexchange = st;	
		
		 ResultSet i=null;
		 PreparedStatement stmt4 =null;
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
			
			
			String query1 = "select * from hist_data where stock_exchange = ? order by sdate desc";
			
			stmt4=conn.prepareStatement(query1);
			stmt4.setString(1, stockexchange);
			
			i=stmt4.executeQuery();
			jt.setModel(DbUtils.resultSetToTableModel(i));
			
			
			stmt4.close();
			 conn.close();
		}
		catch(Exception e){
			System.out.println(e);
			}
		
	}
	
	public static void main(String[] args) {
		
		HistTable t = new HistTable();
		t.CreateWindow();
		t.HistoricalData("BSE");
		Components t1= new Components();
		t1.CreateWindow();
		t1.ComponentData("BSE");
		StockExchange t2= new StockExchange();
		t2.CreateWindow();
		t2.StockExchangeData("BSE");
		
	}
}

class Components extends HistTable{

		public void ComponentData(String st)
		{
			
			
			 ResultSet i=null;
			 PreparedStatement stmt4 =null;
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver"); 
				String url="jdbc:mysql://localhost:3306/mahoo";
				String username="root";
				String password="root123";
				Connection conn=DriverManager.getConnection (url,username,password);
				
				
				
				String query1 = "select * from components where stock_exchange = ?";
				
				stmt4=conn.prepareStatement(query1);
				stmt4.setString(1, st);
				
				i=stmt4.executeQuery();
				jt.setModel(DbUtils.resultSetToTableModel(i));
				
				
				stmt4.close();
				 conn.close();
			}
			catch(Exception e){
				System.out.println(e);
				}
			
		}
		
}
class StockExchange extends HistTable{

	public void StockExchangeData(String st)
	{
		
		
		 ResultSet i=null;
		 PreparedStatement stmt4 =null;
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
			
			
			String query1 = "select * from info_se where stock_exchange = ?";
			
			stmt4=conn.prepareStatement(query1);
			stmt4.setString(1, st);
			
			i=stmt4.executeQuery();
			jt.setModel(DbUtils.resultSetToTableModel(i));
			
			
			stmt4.close();
			 conn.close();
		}
		catch(Exception e){
			System.out.println(e);
			}
		
	}
	
}
	
	

 


