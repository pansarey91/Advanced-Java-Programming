import javax.swing.*;


public class JFImg_2 extends JFrame
{
    JLabel l1;
	
    JFImg_2()
	{
		super("Image Demo");
		setSize(500,700);
		setLocation(100,100);
		setLayout(null);
		
		l1 = new JLabel(new ImageIcon("Friend.jpg"));
		add(l1);
		l1.setBounds(50,50,385,425);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new JFImg_2();
	}
}

