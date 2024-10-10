import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class MyFrame4 extends JFrame implements ActionListener,ItemListener
{
	int rno,flg=0;
    JLabel lroll,lnm,lage;
    JTextField troll,tnm,tage;
    JButton clr,add,del,updt,ext,srch;
    JPanel p;
    JTextField tsrch;
    List l1;
	
    Connection cn;
    PreparedStatement prstm;
    Statement stm;
    ResultSet rs;
    String sql;
	
    MyFrame4()
    {
        super("DB Connectivity & MAX Number");        
		setLayout(null);
        setSize(500,260);    
        setLocation(250,200);
		
        lroll = new JLabel("Roll No.");    lnm = new JLabel("Name");
        lage = new JLabel("Age");
        troll = new JTextField("");        tnm = new JTextField("");
        tage = new JTextField("");
        clr = new JButton("Clear");        add = new JButton("ADD");
        del = new JButton("Delete");       ext = new JButton("EXIT");
        updt = new JButton("UPDATE");       srch = new JButton("SEARCH");
        p = new JPanel();                   p.setLayout(null);
        l1 = new List();                    tsrch = new JTextField();
        tsrch.setToolTipText("Ex. abcd OR  ab%d");
		
        add(lroll);  add(lnm);  add(lage);
        add(troll);  add(tnm);  add(tage);
        add(clr);    add(add);  add(ext);  
        add(updt);  add(del);   add(srch);
        add(p);     p.setVisible(false);
        p.add(l1);  p.add(tsrch);
		
		troll.setEditable(false);
		
        clr.addActionListener(this);        add.addActionListener(this);
        updt.addActionListener(this);       del.addActionListener(this);
        ext.addActionListener(this);        srch.addActionListener(this);
        l1.addItemListener(this);
		
        lroll.setBounds(10,10,80,20);     troll.setBounds(100,10,100,20);
        lnm.setBounds(10,40,80,20);       tnm.setBounds(100,40,100,20);
        lage.setBounds(10,70,80,20);      tage.setBounds(100,70,100,20);
        clr.setBounds(10,100,90,20);     add.setBounds(110,100,90,20);
        del.setBounds(10,130,90,20);    updt.setBounds(110,130,90,20);
        srch.setBounds(10,160,90,20);   ext.setBounds(110,160,90,20);
        p.setBounds(220,10,250,200);    p.setBackground(Color.PINK);
        l1.setBounds(10,40,230,150);    tsrch.setBounds(10,10,230,20);
        
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
            stm = cn.createStatement();
		}
        catch(Exception e)
        { e.printStackTrace();
		}
		
        tsrch.addKeyListener(new KeyAdapter()
        {   @SuppressWarnings("deprecation")
		public void keyPressed(KeyEvent e)
            {   if(e.getKeyChar() == KeyEvent.VK_ENTER)
                { try
                    {   
						l1.clear();
                        rs = stm.executeQuery("select * from mytable where name like '%" + tsrch.getText() + "%'");
                        while(rs.next())
						l1.addItem(rs.getString(2));
					}
                    catch(Exception ee)
					{ee.printStackTrace();}
				}
			}
		});
		
		getMax();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}		// End of Con_or
	
	void getMax()
	{
		try
		{
			sql = "select max(roll) from mytable";
			rs = stm.executeQuery(sql);
			rs.next();
			rno=rs.getInt(1);
			rno++;
			troll.setText(""+rno);
		}
		catch(Exception e)
		{
			rno=1;
			troll.setText(""+rno);			
		}
	}
	
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == clr)
            {
				flg=0;
                troll.setText("");
                tnm.setText("");
                tage.setText("");
                tsrch.setText("");
                l1.clear();
                p.setVisible(false);
				getMax();
				add.setEnabled(true);
			}
			
            if(e.getSource() == add)
            {
				if(troll.getText().length()==0 || tnm.getText().length()==0 || tage.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "All fields are required !!!","SAVE Error",JOptionPane.WARNING_MESSAGE);					
				}
				else
				{
					sql = "insert into mytable values(" +troll.getText()+ ",'"+tnm.getText()+"'," +tage.getText()+")";
					prstm = cn.prepareStatement(sql);
					prstm.execute() ;
					prstm.close();
					JOptionPane.showMessageDialog(null, "Record Saved Successfully !!!");
					add.setEnabled(false);
					
				}
			}
			
			if(e.getSource() == del)
			{
				if(flg==0)
				JOptionPane.showMessageDialog(null, "Search the Record before Delete","DELETE Error",JOptionPane.WARNING_MESSAGE);			
				else
				{
					if(troll.getText().length()==0 || tnm.getText().length()==0 || tage.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Roll Number is required !!!","DELETE Error",JOptionPane.WARNING_MESSAGE);			
					else
					{
						sql = "delete from mytable where roll ="+troll.getText();
						prstm = cn.prepareStatement(sql);
						prstm.execute() ;
						prstm.close();
						JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!!");
						flg=0;
					}
				}
			}
			
			if(e.getSource() ==updt)
			{
				if(flg==0)
				JOptionPane.showMessageDialog(null, "Search the Record before Update","UPDATE Error",JOptionPane.WARNING_MESSAGE);			
				else
				{
					if(troll.getText().length()==0 || tnm.getText().length()==0 || tage.getText().length()==0)
					JOptionPane.showMessageDialog(null, "All fields are required !!!","UPDATE Error",JOptionPane.WARNING_MESSAGE);	
					else
					{
						sql = "update mytable set name='" +tnm.getText()+"', age="
						+tage.getText()+" where roll = "+troll.getText();
						prstm = cn.prepareStatement(sql);
						prstm.execute() ;		prstm.close();
						JOptionPane.showMessageDialog(null, "Record Updated Successfully !!!");
						flg=0;
					}
				}
			}
			
			if(e.getSource()==srch)
			{
				add.setEnabled(false);
				p.setVisible(true);
				tsrch.requestFocus();
			}
			
			if(e.getSource() == ext)
			System.exit(0);
		} // End of Try
		catch (SQLException e1)
		{    System.out.println(e1);
		}
	} // End of ActionListener
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==l1)
		{
			try
			{
				sql = "select * from mytable where name='"+l1.getSelectedItem() + "'";
				
				rs = stm.executeQuery(sql);
				rs.next();
				troll.setText(rs.getString(1));
				tnm.setText(rs.getString(2));
				tage.setText(rs.getString(3));
				flg=1;
			}
			catch (SQLException e1){e1.printStackTrace();}
		}
	}
	
	public static void main(String args[])
	{
		new MyFrame4();
	}
}
