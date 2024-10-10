import java.awt.*;
import java.awt.event.*;

class myframe extends Frame implements ActionListener 
{
	// 1) Declaration
	Button b1,b2;
	TextField t1;
	int cnt=0;
	
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(800,500);
		setLocation(200,200);
		setLayout(new FlowLayout());
		
		// 2) Memory Allocation
		b1 = new Button("Click Me");
		b2 = new Button("Exit");
		t1 = new TextField(50);
		
		// 3) Add components on Frame
		add(b1);
		add(b2);
		add(t1);
		
		// 4) Add Listener on components
		b1.addActionListener(this);
		b2.addActionListener(this);
		
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

class frm5
{
	public static void main(String args[])
	{
		new myframe();
	}
}