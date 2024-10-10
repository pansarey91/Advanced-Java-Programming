import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myframe extends JFrame implements ActionListener 
{
	// 1) Declaration
	JButton b1,b2;
	JTextField t1;
	int cnt=0;
	
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(800,500);
		setLocation(200,200);
		setLayout(new FlowLayout());
		
		// 2) Memory Allocation
		b1 = new JButton("Click Me");
		b2 = new JButton("Exit");
		t1 = new JTextField(50);
		
		// 3) Add components on Frame
		add(b1);
		add(b2);
		add(t1);
		
		b1.setMnemonic('C');
		b2.setMnemonic('x');
		
		b1.setToolTipText("This is Click Button");
		b2.setToolTipText("Way to Exit");
		t1.setToolTipText("Result displyed here");
		
		// 4) Add Listener on components
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			cnt++;
			t1.setText("Button Clicked = "+cnt);
		}
		else if(e.getSource()==b2)
		{
			System.exit(0);
		}
	}
}

class sw1
{
	public static void main(String args[])
	{
		new myframe();
	}
}