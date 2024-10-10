import java.awt.*;
import javax.swing.*;

class myframe extends JFrame
{
	JPanel pnl;
	
	myframe()
	{
		super("Graphics");
		setSize(800,500);
		setLocation(200,200);
		
		pnl = new JPanel()
		{
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillOval(50,50,100,100);
			}
		};
		
		add(pnl);
		pnl.setBackground(Color.YELLOW);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}

class sw_graphics1
{
	public static void main(String args[])
	{
		new myframe();
	}
}