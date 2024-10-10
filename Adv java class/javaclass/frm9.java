import java.awt.*;
import java.awt.event.*;

// CB and RB

class myframe extends Frame implements ItemListener
{
	// 1) Declaration
	Checkbox cb1,cb2;
	
	Checkbox cb3,cb4;
	CheckboxGroup grp;
	
	myframe()
	{
		super("CB RB Demo");
		setSize(200,200);
		setLocation(200,200);
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.PLAIN,20));
		
		// 2) Memory Allocation
		cb1 = new Checkbox("Pen");
		cb2 = new Checkbox("Pencil");
		
		grp = new CheckboxGroup();
		cb3 = new Checkbox("Male",true,grp);
		cb4 = new Checkbox("Female",false,grp);
		
		// 3) Add components on Frame
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		
		// 4) Add Listener on components
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}	
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.getState())
				System.out.println("\n\t Pen Checked");
			else
				System.out.println("\n\t Pen UNChecked");
		}
		else if(e.getSource()==cb2)
		{
			if(cb2.getState())
				System.out.println("\n\t Pencil Checked");
			else
				System.out.println("\n\t Pencil UNChecked");
		}
		else if(e.getSource()==cb3 || e.getSource()==cb4)
		{
			if(cb3.getState())
				System.out.println("\n\t Male Selected");
			else
				System.out.println("\n\t Female Selected");
		}
	}
	
}

class frm9
{
	public static void main(String args[])
	{
		new myframe();
	}
}