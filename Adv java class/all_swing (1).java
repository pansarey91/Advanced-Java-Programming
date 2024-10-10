import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class all_swing extends JFrame implements ActionListener,ItemListener,ListSelectionListener
{
	// 1) Declaration
	JLabel lbl,lbl2;
	JTextField t1;
	JPasswordField t2;
	JButton b1;
	JCheckBox cb1,cb2;
	JComboBox<String> ch;
	JList<String> lst;
	JMenuBar mbr;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mir,mig,mib;
	JMenuItem md1,md2,md3,md4,md5,md6;
	JTextArea ta;
	String s_arr[] = {"Apple","Banana","Cat","Dog"};
	
	JRadioButton rb1,rb2;
	ButtonGroup grp;
	Font f;
	
	JSeparator sep;
	
	JPanel pnl;
	JButton b[];
	JButton b2,b3;
	
	all_swing()
	{
		super("All Swing Controls");
		setSize(700,700);
		setLocation(100,50);
		setLayout(null);		// IMP
		
		f = new Font("Arial",Font.BOLD,15);
		//		setFont(f);		// not applicable for swing
		
		// 2) Memory Allocation
		lbl = new JLabel("Enter Your Name");
		lbl2 = new JLabel("JPasswordField");
		t1 = new JTextField("Welcome");
		t2 = new JPasswordField();
		b1 = new JButton("Click Me");
		b2 = new JButton("Hide Panel");
		b3 = new JButton("Show Panel");		
		cb1 = new JCheckBox("Pen");
		cb2 = new JCheckBox("Pencil",true);
		ch = new JComboBox<>();
		//lst = new List();
		lst = new JList<>(s_arr);
		ta = new JTextArea();
		sep = new JSeparator();  
		
		grp = new ButtonGroup();
		rb1 = new JRadioButton("Book",true);
		rb2 = new JRadioButton("Note Book");
		grp.add(rb1);	grp.add(rb2);
		
		mbr = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Edit");
		m3 = new JMenu("Help");
		m4 = new JMenu("Color");
		m5 = new JMenu("MessageDialogs");
		mi1 = new JMenuItem("Open");
		mi2 = new JMenuItem("Save");
		mi3 = new JMenuItem("Exit");
		mi4 = new JMenuItem("Cut");
		mi5 = new JMenuItem("Copy");
		mi6 = new JMenuItem("Paste");
		mi7 = new JMenuItem("About Us");
		mir = new JMenuItem("Red"); 
		mig = new JMenuItem("Green");
		mib = new JMenuItem("Blue");
		md1 = new JMenuItem("Simple Msg Box");
		md2 = new JMenuItem("Warning Msg Box");
		md3 = new JMenuItem("Error Msg Box");
		md4 = new JMenuItem("Confirm Box");
		md5 = new JMenuItem("Confirm Box 2");
		md6 = new JMenuItem("Input Dialog");
		
		m1.add(mi1);	m1.add(mi2);	m1.addSeparator();	
		m1.add(mi3);	mbr.add(m1);
		
		m2.add(mi4);	m2.add(mi5);	m2.add(mi6);
		mbr.add(m2);
		//		m1.add(m2);
		
		m3.add(mi7);
		mbr.add(m3);
		
		m4.add(mir);	m4.add(mig);	m4.add(mib);
		mbr.add(m4);
		
		m5.add(md1);	m5.add(md2);	m5.add(md3);
		m5.add(md4);	m5.add(md5);	m5.add(md6);
		mbr.add(m5);
		
		add(mbr);
		
		pnl = new JPanel();
		b = new JButton[12];
		
		for(int i=0;i<12;i++)
		{
			b[i] = new JButton("Button "+(i+1));
			pnl.add(b[i]);
		}
		// by default panel having FlowLayout()
		pnl.setLayout(new GridLayout(4,3,5,5));
		pnl.setBackground(Color.YELLOW);
		add(pnl);
		
		
		// 3) Add component on Frame
		add(lbl);	add(t1);	add(b1);	add(cb1);
		add(cb2);	add(b2);	add(b3);	add(lbl2);
		add(rb1);	add(rb2);	add(t2);	add(sep);
		add(ch);	
		
		//		add(lst);	
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(lst, v1, h1);
		add(jsp1);	
		
		
		//		add(ta);
		int v2 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h2 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp2 = new JScrollPane(ta, v2, h2);
		add(jsp2);	
		
		ch.addItem("Apple");	ch.addItem("Banana");
		ch.addItem("Cat");		ch.addItem("Dog");
		
		t1.setFont(f);
		
		// 4) setBounds(x,y,wd,ht)
		mbr.setBounds(0,0,800,30);
		lbl.setBounds(50,100,100,30);
		lbl2.setBounds(50,190,100,30);
		t1.setBounds(160,100,460,30);
		t2.setBounds(160,190,290,30);
		b1.setBounds(50,145,400,30);
		cb1.setBounds(50,230,100,30);
		cb2.setBounds(160,230,100,30);
		rb1.setBounds(50,260,100,30);
		rb2.setBounds(160,260,100,30);
		
		//		ta.setBounds(50,300,400,100);
		jsp2.setBounds(50,300,400,100);
		sep.setBounds(20,410,650,100);
		pnl.setBounds(50,430,400,150);
		b2.setBounds(470,430,150,70);
		b3.setBounds(470,510,150,70);
		
		ch.setBounds(470,150,150,30);
		//		lst.setBounds(500,200,200,200);
  		jsp1.setBounds(470,200,150,200);
		
		// 5) Add Listeners
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		ch.addItemListener(this);
		//		lst.addItemListener(this);
		lst.addListSelectionListener(this);
		mi3.addActionListener(this);
		mir.addActionListener(this);
		mig.addActionListener(this);
		mib.addActionListener(this);
		md1.addActionListener(this);
		md2.addActionListener(this);
		md3.addActionListener(this);
		md4.addActionListener(this);
		md5.addActionListener(this);
		md6.addActionListener(this);
		
		t1.setToolTipText("Result shown here");
		b1.setToolTipText("This is a Button");
		
		b1.setMnemonic('C');
		m1.setMnemonic('F');
		mi3.setMnemonic('X');
		
		m4.setMnemonic('L');
		mir.setMnemonic('R');
		mig.setMnemonic('G');
		mib.setMnemonic('B');
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		t1.setText("Button Clicked");
		
		if(e.getSource()==b2)
		pnl.setVisible(false);
		
		if(e.getSource()==b3)
		pnl.setVisible(true);
		
		if(e.getSource()==mi3)
		System.exit(0);
		
		//		setBackground(Color.pink);	// not applicable for swing
		if(e.getSource()==mir)
		pnl.setBackground(Color.red);
		if(e.getSource()==mig)
		pnl.setBackground(Color.green);
		if(e.getSource()==mib)
		pnl.setBackground(Color.blue);
		
		if(e.getSource()==rb1 || e.getSource()==rb2)
		{
			if(rb1.isSelected())
			t1.setText("Book Selected");
			else
			t1.setText("Note Book Selected");
		}
		
		if(e.getSource()==md1)
		JOptionPane.showMessageDialog(null, "This is Simple Msg Box");
		
		if(e.getSource()==md2)
		JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
		
		if(e.getSource()==md3)
		JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.ERROR_MESSAGE);
		
		if(e.getSource()==md4)
        {
            int ans=JOptionPane.showConfirmDialog(null,"Do you want to delete this record?");
            if (ans==0)
			t1.setText("You clicked on YES Button");
            else if (ans==1)
			t1.setText("You clicked on NO Button");
            else
			t1.setText("You clicked on CANCEL Button");
		}
		
		if(e.getSource()==md5)
        {
			int ans = JOptionPane.showConfirmDialog(null,"Message","Msg Box Title",	JOptionPane.OK_CANCEL_OPTION);			
			if(ans==0)
			t1.setText("You clicked on Ok Button");
			else
			t1.setText("You clicked Cancel button");
		}
		
		if(e.getSource()==md6)
		{
            String str = JOptionPane.showInputDialog(null, "Enter some text : ");
            if (str != null)
			t1.setText("You entered the text : " + str);
            else
			t1.setText("You pressed CANCEL button.");
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.isSelected())
			t1.setText("Pen Checked");
			
			if(cb1.isSelected()==false)
			t1.setText("Pen UNChecked");
		}
		if(e.getSource()==cb2)
		{
			if(cb2.isSelected())
			t1.setText("Pencil Checked");
			
			if(cb2.isSelected()==false)
			t1.setText("Pencil UNChecked");
		}
		if(e.getSource()==ch)
		{
			t1.setText(ch.getSelectedItem()+" is at Index = " + ch.getSelectedIndex());
		}
	}
	
	public void valueChanged(ListSelectionEvent e)
	{ 
		t1.setText("Selected Item = "+lst.getSelectedValue());
	}
	
	public static void main(String args[])
	{
		new all_swing();
	}
}
