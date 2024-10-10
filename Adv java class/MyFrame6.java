import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.LinkedList;

class MyFrame6 extends JFrame implements ItemListener,ActionListener
{
    JLabel lbl_srch,lbl_data;
    JTextField txt_data;
	JRadioButton rb_roll,rb_name;
	ButtonGroup grp;
	List l1;
	
    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
	
	@SuppressWarnings("rawtypes")
	LinkedList linkedlist;
	
    @SuppressWarnings("rawtypes")
	MyFrame6()
    {
        super("Working on Duplication Entries with Collection");        
		setLayout(null);	setSize(300,260);    
		setVisible(true);	setLocation(450,200);
		
        lbl_srch = new JLabel("Search by");    
        lbl_data = new JLabel("Enter Data");    
		txt_data = new JTextField();
		rb_roll = new JRadioButton("Roll No.");
		rb_name = new JRadioButton("Name");
		grp = new ButtonGroup();
		l1 = new List();
		
        add(lbl_srch);  add(lbl_data);
		add(txt_data);	add(l1);
		add(rb_roll);	add(rb_name);
		grp.add(rb_roll);	grp.add(rb_name);
		
        lbl_srch.setBounds(20,10,60,20);     
		rb_roll.setBounds(90,10,80,20);
		rb_name.setBounds(170,10,80,20);
		
		lbl_data.setBounds(20,40,60,20);
		txt_data.setBounds(90,40,140,20);
		
		l1.setBounds(20,70,210,100);
		
		l1.addItemListener(this);
		rb_roll.addActionListener(this);
		rb_name.addActionListener(this);
		
		linkedlist = new LinkedList();
        
        try
        {   cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
            stm = cn.createStatement();
		}
        catch(Exception e)
        { e.printStackTrace();
		}
		
        txt_data.addKeyListener(new KeyAdapter()
        {   
            @SuppressWarnings({ "deprecation", "unchecked" })
			public void keyTyped(KeyEvent e)
            {
				if(rb_roll.isSelected())
				{
					char c = e.getKeyChar();
					if(Character.isDigit(c) && txt_data.getText().length()<5)
						super.keyTyped(e);  // Optional
					else
					{   e.consume();        // Discard the event
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();          // Raise the Sound
					}					
				}
				else if(rb_name.isSelected())
				{
					char c = e.getKeyChar();
					if(Character.isLetter(c) || c == KeyEvent.VK_SPACE)
						super.keyTyped(e);  // Optional
					else
					{   e.consume();        // Discard the event
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();          // Raise the Sound
					}					
				}
				
				
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
			try
                    {   l1.clear();
						
				if(rb_roll.isSelected())
                        rs = stm.executeQuery("select * from mytable where roll like '%" + txt_data.getText() + "%'");
					else
                        rs = stm.executeQuery("select * from mytable where name like '%" + txt_data.getText() + "%'");
						
                        while(rs.next())
						{
							l1.addItem(rs.getString(2));
							linkedlist.add(rs.getString(1));
						}
					}
                    catch(Exception ee){ee.printStackTrace();}
				}
			}
		});
		
		rb_roll.setSelected(true);	
		txt_data.requestFocus();
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}		// End of Con_or
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==l1)
		{
			try
			{
				sql = "select * from mytable where roll="+ linkedlist.get(l1.getSelectedIndex());
				rs = stm.executeQuery(sql);
				rs.next();
				JOptionPane.showMessageDialog(null,"Roll = "+rs.getString(1)+" Name = "+rs.getString(2)+" Age = "+rs.getString(3));
			}
			catch (SQLException e1){e1.printStackTrace();}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		l1.clear();
		txt_data.setText("");
		txt_data.requestFocus();
	}
	
	public static void main(String args[])
	{
		new MyFrame6();
	}
}

