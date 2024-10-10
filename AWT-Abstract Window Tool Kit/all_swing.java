import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class my8 extends JFrame implements ActionListener,ItemListener,ListSelectionListener
{
	// 1) Declaration
	JLabel l1;
	JTextField t1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JCheckBox cb1,cb2;
 	JRadioButton cb3,cb4;
	ButtonGroup grp;
	JList<String> lst;
	JComboBox<String> cmb;
	JTextArea ta;
	JPanel pnl;
	
	JMenuBar mbr;
	JMenu m1,m2;
	JMenuItem mi1,mi2,mi3,mi4,mi5;
	
	Font f;
	String strArr[] = {"Mangesh","Ganesh","Rajesh","Suresh"};

	
	my8()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(800,600);
		setLocation(300,100);
		setLayout(null);
		// setLayout(new FlowLayout());
		f = new Font("Arial",Font.BOLD,16);
		
		// 2) Memory Allocation
		l1 = new JLabel("Event Result");
		t1 = new JTextField();
		b1 = new JButton("Click Me");
		ta = new JTextArea();
		b2 = new JButton("Hide");
		b3 = new JButton("Show");
		
		b4 = new JButton("MD - Info");
		b5 = new JButton("MD - Warining");
		b6 = new JButton("MD - Error");
		b7 = new JButton("CD - Ques");
		b8 = new JButton("ID - Name");
		
		pnl = new JPanel();
		pnl.setBackground(Color.YELLOW);
		
		for(int i=1;i<=15;i++)
			pnl.add(new JButton(""+i));
		
		pnl.setLayout(new GridLayout(5,3,5,5));
		
		cb1 = new JCheckBox("Pen");
		cb2 = new JCheckBox("Pencil");
		
		grp = new ButtonGroup();
		cb3 = new JRadioButton("Male");
		cb4 = new JRadioButton("Female");
		grp.add(cb3);
		grp.add(cb4);
		
		cmb = new JComboBox<>();
		cmb.addItem("Cricket");
		cmb.addItem("Chess");
		cmb.addItem("Tennis");
		
		lst = new JList<>(strArr);
				
		mbr = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Edit");
		mi1 = new JMenuItem("Open");
		mi2 = new JMenuItem("Close");
		mi3 = new JMenuItem("Red");
		mi4 = new JMenuItem("Green");
		mi5 = new JMenuItem("Pink");
		
		// 3) Add Component
		add(l1);		l1.setFont(f);
		add(t1);		t1.setFont(f);
		add(b1);

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(ta, v, h);
		add(jsp);	


		add(pnl);
		add(b2);
		add(b3);
		
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cmb);

		add(lst);	
		// int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		// int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		// JScrollPane jsp1 = new JScrollPane(lst, v1, h1);
		// add(jsp1);	
		
		m1.add(mi1);
		m1.add(mi2);
		
		m2.add(mi3);
		m2.add(mi4);
		m2.add(mi5);
		
		mbr.add(m1);
		m1.add(m2);
		
		add(mbr);		
		
		
		b1.setToolTipText("This is Button");
		b2.setToolTipText("Action = HIDE");
		b3.setToolTipText("Action = SHOW");
		
		b1.setMnemonic('C');
		b2.setMnemonic('H');
		b3.setMnemonic('S');
		
		// 4) setBounds(x,y,wd,th)
		mbr.setBounds(0,0,800,20);
		
		l1.setBounds(50,70,100,20);
		t1.setBounds(160,70,200,30);
		b1.setBounds(50,100,310,20);
		jsp.setBounds(50,140,310,150);
		pnl.setBounds(50,300,310,200);
		b2.setBounds(50,510,150,20);
		b3.setBounds(210,510,150,20);
		
		cb1.setBounds(400,70,80,20);
		cb2.setBounds(490,70,80,20);
		 
		cb3.setBounds(400,100,80,20);
		cb4.setBounds(490,100,80,20);
		
		cmb.setBounds(400,140,200,20);
		lst.setBounds(400,190,200,100);
		
		b4.setBounds(400,310,200,20);
		b5.setBounds(400,340,200,20);
		b6.setBounds(400,370,200,20);
		b7.setBounds(400,400,200,20);
		b8.setBounds(400,430,200,20);


		// 5) Add Listener
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cmb.addItemListener(this);
		lst.addListSelectionListener(this);

		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
		else if(e.getSource()==b4)
		{
			JOptionPane.showMessageDialog(null,"Report Generated Successfully !!!");
		}
		else if(e.getSource()==b5)
		{
			JOptionPane.showMessageDialog(null,"Report Generated Successfully !!!","Attension",JOptionPane.WARNING_MESSAGE);
		}
		else if(e.getSource()==b6)
		{
			JOptionPane.showMessageDialog(null,"Report Generated Successfully !!!","Attension",JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==b7)
		{
			int ans = JOptionPane.showConfirmDialog(null,"Do you want to DELETE the record?");
			if(ans == 0)
				t1.setText("YES Clicked");
			else if(ans == 1)
				t1.setText("NO Clicked");
			else if(ans == 2)
				t1.setText("CANCEL Clicked");
		}
		else if(e.getSource()==b8)
		{
			String name = JOptionPane.showInputDialog(null,"Enter your name");
			t1.setText("Hello "+name);
		}
			
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.isSelected())
				t1.setText("Pen Checked");
			else
				t1.setText("Pen UNChecked");
		}
		else if(e.getSource()==cb2)
		{
			if(cb2.isSelected())
				t1.setText("Pencil Checked");
			else
				t1.setText("Pencil UNChecked");
		}
		else if(e.getSource()==cb3 || e.getSource()==cb4)
		{
			if(cb3.isSelected())
				t1.setText("Male Selected");
			else
				t1.setText("Female Selected");
		}
		else if(e.getSource()==cmb)
		{
			t1.setText(cmb.getSelectedItem().toString());
		}
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		t1.setText(lst.getSelectedValue().toString());		
	}
	
}	// eof class

class all_swing
{
	public static void main(String args[])
	{
		new my8();
	}
}