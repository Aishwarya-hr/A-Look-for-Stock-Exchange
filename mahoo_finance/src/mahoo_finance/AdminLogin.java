package mahoo_finance;



import javax.swing.JFrame; //Swing Components Class included
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener; //EventHandler interface &amp; class
import java.awt.event.ActionEvent;
import java.awt.Color; //To use static color CONSTANTs
import java.awt.Font;
//Step:1-Implementing the ActionListener interface in the class
class Login implements ActionListener{
JLabel l1,l2,l3,l4; //JComponents Declared
JTextField t1;
JPasswordField p1;
JButton b1;
JFrame jf;

Login(){
jf=new JFrame("     MAHOO FINANCE        ");
jf.setVisible(true); //making the frame visible
jf.setSize(400,400);
jf.setLocation(100,30);//300 width and 300 height
jf.setLayout(null); //using no layout managers
jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//JComponents created
l1=new JLabel("Admin Login ");
l2=new JLabel("UserName");
t1=new JTextField();
l3=new JLabel("Password");
p1=new JPasswordField();
b1=new JButton("login");
l4=new JLabel();

l1.setForeground(Color.green);
//adding components created in JFrame
jf.add(l1);
jf.add(l2);
jf.add(l3);
jf.add(t1);
jf.add(p1);
jf.add(b1);
jf.add(l4);
//x axis, y axis, width, height
l1.setBounds(100,40,200,40);
l1.setForeground(Color.RED);
l2.setBounds(70,80,150,30);
t1.setBounds(170,80,150,30);
l3.setBounds(70,130,150,30);
p1.setBounds(170,130,150,30);
b1.setBounds(80,200,150,30);
l4.setBounds(50,320,150,30);
//Step:2-Registering the component with the Listener
b1.addActionListener(this);
}
//Step:3-Overridding the actionPerformed() method
public void actionPerformed(ActionEvent e){

String s =

e.getActionCommand();//System.out.println(s);

if (s.equals("login")) {
String uname = t1.getText();
String pass = p1.getText();
if(uname.equals("admin") &&pass.equals("1234")){
l4.setForeground(Color.GREEN);
l4.setText("SUCCESS");


b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e)
	{
		jf.dispose();
		new AdminInterface1();
	
	}
});

}
else{
l4.setForeground(Color.RED);
l4.setText("FAILURE");
}
}
}
}

class AdminInterface1 extends JFrame
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	AdminInterface1()
	{
		
		setLayout(null);
	    setSize(1000,700);
	    setLocation(100,30);
		
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
	    l1.setLocation(30,10);
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
	    
	    
	    b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			  dispose();
			
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				AdminInterface obj=new AdminInterface();
				obj.method("BSE");
			
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AdminInterface obj=new AdminInterface();
				obj.method("NSE");
		
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AdminInterface obj=new AdminInterface();
				obj.method("Nasdaq");
		
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AdminInterface obj=new AdminInterface();
				obj.method("TSE");
		
			}
		});
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AdminInterface obj=new AdminInterface();
				obj.method("LSE");
		
			}
		});
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				 
				AdminInterface obj=new AdminInterface();
				obj.method("HangSeng");
		
			}
		});
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				AdminInterface obj=new AdminInterface();
				obj.method("DOW");
		
			}
		});
	    
	    setVisible(true);
	}
	
}

public class AdminLogin{
public static void main(String[] args){
new Login();
}
}