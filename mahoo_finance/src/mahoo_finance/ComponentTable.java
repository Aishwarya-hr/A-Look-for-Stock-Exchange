package mahoo_finance;



import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class ComponentTable {
	 public String stockexchange;
	
 
	
	public void method1(String st)
	{
		stockexchange = st;	
		
		 ResultSet i=null;
		 PreparedStatement stmt4 =null;
		
		//fetching details from hist_data tblae using where condition
		try {
			
			JFrame f;
			 //JButton b1;
			 f=new JFrame();
		   
			 f.setSize(1000, 700);
			 f.setTitle("smart look up:component");
			 
			// f.setLayout(null);
			// String column[]={"stock_exchange","sdate","open","high","low","close","adj_close","volume"};
			 JTable jt=new JTable();
			  //b1=new JButton();
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
			 
			 
			Class.forName("com.mysql.jdbc.Driver"); 
			String url="jdbc:mysql://localhost:3306/mahoo";
			String username="root";
			String password="root123";
			Connection conn=DriverManager.getConnection (url,username,password);
			
			
			
			String query1 = "select * from components where stock_exchange = ?";
			
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
		ComponentTable t = new ComponentTable();
		t.method1("BSE");

}
	
}