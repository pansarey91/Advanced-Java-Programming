import java.awt.*;
import java.awt.event.*;

class myframe extends Frame implements ActionListener 
{
	// 1) Declaration
	Button b1;
	int cnt=0;
	
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(800,500);
		setLocation(200,200);
		setLayout(new FlowLayout());
		
		// 2) Memory Allocation
		b1 = new Button("Click Me");
		
		// 3) Add components on Frame
		add(b1);
		
		// 4) Add Listener on components
		b1.addActionListener(this);
		
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		cnt++;
		System.out.println("Button Clicked = "+cnt);
	}
}

class frm4_btn
{
	public static void main(String args[])
	{
		new myframe();
	}
}