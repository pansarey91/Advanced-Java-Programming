import java.awt.*;
import java.awt.event.*;

class my1 extends Frame implements ActionListener
{
	// 1) Declaration
	Button b1;
	
	my1()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(500,500);
		setLocation(300,100);
		setLayout(new FlowLayout());		// IMP
		setFont(new Font("Arial",Font.BOLD,16));
		
		// 2) Memory Allocation
		b1 = new Button("Click Me");
		
		// 3) Add Components
		add(b1);
		
		// 4) Add Listener to corresponding components
		b1.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}			
		});
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Button Clicked");
	}
		
}

class frm4
{
	public static void main(String args[])
	{
		new my1();
	}
}