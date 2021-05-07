package mahoo_finance;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

class MainFrame1 extends JFrame {
	
	
	/**
	 * main window
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame1(String title)
	{
		super(title);
		this.setSize(1000,700);
		this.setLocation(100,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b1 =new JButton("ABOUT");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new About();
			
			}
		});
		
		JButton b2 =new JButton("CONTACT");
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Contact();
			
			}
		});
		
		JLabel l3 = new JLabel("                         MAHOO FINANCE                          ");
		Font f =new Font("Cambria",Font.CENTER_BASELINE ,30);
		l3.setFont(f);
		
		
		JButton b3 =new JButton("PROCEED");
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new StockInterface();
			
			}
		});
		
		JButton b4 =new JButton("ADMIN");
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Login();
			
			}
		});
		
		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		mainContainer.setBackground(Color.YELLOW);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		topPanel.add(b1);
		topPanel.add(b2);
		
		topPanel.add(l3);
		
		topPanel.add(b4);
		
		mainContainer.add(topPanel,BorderLayout.NORTH);
		
		JPanel midPanel = new JPanel();
		JLabel l1 = new JLabel();
		l1.setIcon(new ImageIcon("C:\\Users\\aishwarya\\Desktop\\CSE65.MP\\PP1.jpg"));
		
	
		
		midPanel.add(l1);
		
		mainContainer.add(midPanel,BorderLayout.CENTER);
		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.MAGENTA);
		bottomPanel.add(b3);
		mainContainer.add(bottomPanel,BorderLayout.SOUTH);
		

	}

}

public class MainFrame 
{
	public static void main(String []args)
	{
		
		MainFrame1 m1 = new MainFrame1("SMART LOOK UP");
		m1.setVisible(true);

	}
}
