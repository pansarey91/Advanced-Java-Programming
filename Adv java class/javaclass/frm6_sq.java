import java.awt.*;
import java.awt.event.*;

class myframe extends Frame implements ActionListener 
{
	// 1) Declaration
	Button b1,b2,b3;
	TextField t1,t2;
	Label l1,l2;
	
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(300,200);
		setLocation(200,200);
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.PLAIN,20));
		setBackground(Color.PINK);
		
		// 2) Memory Allocation
		b1 = new Button("Square");
		b2 = new Button("Clear");
		b3 = new Button("Exit");
		t1 = new TextField(10);
		t2 = new TextField(10);
		l1 = new Label("Enter No.");
		l2 = new Label("Square = ");
		
		// 3) Add components on Frame
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
		add(b3);
		
		// 4) Add Listener on components
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
			int n = Integer.parseInt(t1.getText());
			int ans = n*n;
			
			//t2.setText(""+ans);
			t2.setText(Integer.toString(ans));
		}
		else if(e.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
		}
		else if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
}

class frm6_sq
{
	public static void main(String args[])
	{
		new myframe();
	}
}