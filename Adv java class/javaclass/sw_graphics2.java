import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myframe extends JFrame implements Runnable
{
	JPanel pnl;
	int x=50;
	Thread t;
	
	myframe()
	{
		super("Graphics");
		setSize(800,500);
		setLocation(200,200);
		
		t = new Thread(this);
		t.start();

		pnl = new JPanel()
		{
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillOval(x,50,100,100);
			}
		};
		
		add(pnl);
		pnl.setBackground(Color.YELLOW);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	public void run()
	{
		while(true)
		{
			try
			{
				x=x+10;								
				pnl.repaint();
				
				Thread.sleep(200);
			}catch(Exception ex){}
		}
	}
}

class sw_graphics2
{
	public static void main(String args[])
	{
		new myframe();
	}
}