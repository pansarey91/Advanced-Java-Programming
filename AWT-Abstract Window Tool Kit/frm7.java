import java.awt.*;
import java.awt.event.*;

class my5 extends Frame implements ItemListener
{
	// 1) Declaration
	Checkbox cb1,cb2;
	TextField t1;
	Checkbox rb1,rb2;
	CheckboxGroup grp;
	
	my5()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(500,500);
		setLocation(300,100);
		setLayout(null);	
		setFont(new Font("Arial",Font.BOLD,16));
		
		// 2) Memory Allocation
		cb1 = new Checkbox("Pen");
		cb2 = new Checkbox("Pencil");
		t1 = new TextField();
		
		grp = new CheckboxGroup();
		rb1 = new Checkbox("Male",true,grp);
		rb2 = new Checkbox("Female",false,grp);
				
		// 3) Add Components
		add(t1);
		add(cb1);
		add(cb2);
		add(rb1);
		add(rb2);
		
		// 4) setBounds(x,y,wd,ht)
		cb1.setBounds(50,50,100,20);
		cb2.setBounds(160,50,100,20);
		t1.setBounds(50,80,210,20);
		rb1.setBounds(50,110,100,20);
		rb2.setBounds(160,110,100,20);
		
		// 5) Add Listener to corresponding components
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}			
		});
		
		setVisible(true);
	}	
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.getState())
				t1.setText("Pen Checked");
			else
				t1.setText("Pen UNChecked");
		}
		else if(e.getSource()==cb2)
		{
			if(cb2.getState())
				t1.setText("Pencil Checked");
			else
				t1.setText("Pencil UNChecked");
		}
		else if(e.getSource()==rb1 || e.getSource()==rb2)
		{
			if(rb1.getState())
				t1.setText("Male Selected");
			else
				t1.setText("Female Selected");
		}
	}
}

class frm7
{
	public static void main(String args[])
	{
		new my5();
	}
}