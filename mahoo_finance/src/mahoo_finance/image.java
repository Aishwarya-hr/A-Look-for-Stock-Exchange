package mahoo_finance;

//Java Program to create a label 
//and add image to it . 
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
class image extends JFrame { 
	image()
	{
		JLabel background;
		JLabel label;
		JButton button;
		setSize(1200,700);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label=new JLabel(" ");
		Image img=new ImageIcon(this.getClass().getResource("/pick1.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(20,40,1200,700);
		add(label);
		
		JButton login =new JButton("login");
		
		Image img1=new ImageIcon(this.getClass().getResource("/pick1.jpg")).getImage();
		login.setIcon(new ImageIcon(img1));
		login.setFont(new Font("Tachoma",Font.BOLD,15));
		login.setBounds(0,0,150,80);
		add(login);
		
		ImageIcon img2=new ImageIcon("/pick1.jpg");
		
		background=new JLabel("",img2,JLabel.CENTER);
		background.setBounds(0,0,1200,700);
		add(background);
		setVisible(true);
	}
	 

	// main class 
	public static void main(String[] args) 
	{ 
		new image();
		 
	} 
} 
