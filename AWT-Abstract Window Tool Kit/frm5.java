import java.awt.*;
import java.awt.event.*;

class my3 extends Frame implements ActionListener
{
	// 1) Declaration
	Label l1;
	TextField t1;
	Button b1,b2;
	
	my3()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(500,500);
		setLocation(300,100);
		setLayout(new FlowLayout());		// IMP
		setFont(new Font("Arial",Font.BOLD,16));
		
		// 2) Memory Allocation
		b1 = new Button("Square It");
		b2 = new Button("Exit");
		l1 = new Label("Enter the Number");
		t1 = new TextField(10);
		
		// 3) Add Components
		add(l1);	
		add(t1);	
		add(b1);
		add(b2);
		
		// 4) Add Listener to corresponding components
		b1.addActionListener(this);
		b2.addActionListener(this);
		
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
		if(e.getSource() == b1)
		{
			int n = Integer.parseInt(t1.getText());
			int sq = n*n;
			// t1.setText(""+sq);
			t1.setText(Integer.toString(sq));			
		}
		else if(e.getSource() == b2)
		{
			System.exit(0);
		}
	}
		
}

class frm5
{
	public static void main(String args[])
	{
		new my3();
	}
}