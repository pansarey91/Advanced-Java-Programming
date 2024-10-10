import java.awt.*;
import java.awt.event.*;

class my7 extends Frame implements ActionListener,ItemListener
{
	// 1) Declaration
	Label l1;
	TextField t1;
	Button b1,b2,b3;
	Checkbox cb1,cb2,cb3,cb4;
	CheckboxGroup grp;
	List lst;
	Choice cmb;
	TextArea ta;
	Panel pnl;
	
	MenuBar mbr;
	Menu m1,m2;
	MenuItem mi1,mi2,mi3,mi4,mi5;
	
	my7()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(800,600);
		setLocation(300,100);
		setLayout(null);
		setFont(new Font("Arial",Font.BOLD,16));
		
		// 2) Memory Allocation
		l1 = new Label("Event Result");
		t1 = new TextField();
		b1 = new Button("Click Me");
		ta = new TextArea();
		b2 = new Button("Hide");
		b3 = new Button("Show");
		
		pnl = new Panel();
		pnl.setBackground(Color.YELLOW);
		
		for(int i=1;i<=15;i++)
			pnl.add(new Button(""+i));
		
		pnl.setLayout(new GridLayout(5,3,5,5));
		
		cb1 = new Checkbox("Pen");
		cb2 = new Checkbox("Pencil");
		
		grp = new CheckboxGroup();
		cb3 = new Checkbox("Male",true,grp);
		cb4 = new Checkbox("Female",true,grp);
		
		cmb = new Choice();
		cmb.add("Cricket");
		cmb.add("Chess");
		cmb.add("Tennis");
		
		lst = new List();
		lst.add("Mangesh");
		lst.add("Ganesh");
		lst.add("Rajesh");
		lst.add("Suresh");
		lst.add("Ramesh");
		
		mbr = new MenuBar();
		m1 = new Menu("File");
		m2 = new Menu("Edit");
		mi1 = new MenuItem("Open");
		mi2 = new MenuItem("Close");
		mi3 = new MenuItem("Red");
		mi4 = new MenuItem("Green");
		mi5 = new MenuItem("Pink");
		
		// 3) Add Component
		add(l1);
		add(t1);
		add(b1);
		add(ta);
		add(pnl);
		add(b2);
		add(b3);
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cmb);
		add(lst);
		
		m1.add(mi1);
		m1.add(mi2);
		
		m2.add(mi3);
		m2.add(mi4);
		m2.add(mi5);
		
		mbr.add(m1);
//		mbr.add(m2);
		m1.add(m2);
		
		setMenuBar(mbr);		
		
		// 4) setBounds(x,y,wd,th)
		l1.setBounds(50,70,100,20);
		t1.setBounds(160,70,200,30);
		b1.setBounds(50,100,310,20);
		ta.setBounds(50,140,310,150);
		pnl.setBounds(50,300,310,200);
		b2.setBounds(50,510,150,20);
		b3.setBounds(210,510,150,20);
		
		cb1.setBounds(400,70,80,20);
		cb2.setBounds(490,70,80,20);
		 
		cb3.setBounds(400,100,80,20);
		cb4.setBounds(490,100,80,20);
		
		cmb.setBounds(400,140,200,20);
		lst.setBounds(400,190,200,100);
		
		// 5) Add Listener
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cmb.addItemListener(this);
		lst.addItemListener(this);

		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}			
		});
		
		setVisible(true);
	}	// eof con

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			t1.setText("Button CLicked");
		}
		else if(e.getSource()==b2)
		{
			pnl.setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			pnl.setVisible(true);
		}
		else if(e.getSource()==mi2)
		{
			System.exit(0);
		}
		else if(e.getSource()==mi3)
			setBackground(Color.RED);
		else if(e.getSource()==mi4)
			setBackground(Color.GREEN);
		else if(e.getSource()==mi5)
			setBackground(Color.PINK);
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
		else if(e.getSource()==cb3 || e.getSource()==cb4)
		{
			if(cb3.getState())
				t1.setText("Male Selected");
			else
				t1.setText("Female Selected");
		}
		else if(e.getSource()==cmb)
		{
			t1.setText(cmb.getSelectedItem());
		}
		else if(e.getSource()==lst)
		{
			t1.setText(lst.getSelectedItem());
		}
	}
	
}	// eof class

class all_awt
{
	public static void main(String args[])
	{
		new my7();
	}
}