import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class MyFrame2 extends JFrame implements ActionListener
{
    JLabel lroll,lnm,lage;
    JTextField troll,tnm,tage;
    JButton clr,add,del,updt,ext,fst,lst,nxt,prv;
	
    Connection cn;    Statement stm;
    ResultSet rs;     String sql;
    PreparedStatement prstm;
	
    MyFrame2(String title)
    {
        super(title);
        setLayout(null);
        setSize(500,200);
        setLocation(250,200);
		
        lroll = new JLabel("Roll No.");      lnm = new JLabel("Name");
		lage = new JLabel("Age");            troll = new JTextField("");
		tnm = new JTextField("");            tage = new JTextField("");
		clr = new JButton("Clear");          add = new JButton("ADD");
		del = new JButton("Delete");         ext = new JButton("EXIT");
		updt = new JButton("UPDATE");        nxt = new JButton("Next");
		prv = new JButton("Prev.");          fst = new JButton("First");
		lst = new JButton("Last");
		add(lroll);  add(lnm);  add(lage);  add(troll);  add(tnm);  add(tage);
		add(clr);    add(add);  add(ext);  add(updt);  add(del);
		add(nxt);    add(prv);  add(fst);  add(lst);
		
		clr.addActionListener(this);        add.addActionListener(this);
		updt.addActionListener(this);       del.addActionListener(this);
		ext.addActionListener(this);         nxt.addActionListener(this);
		prv.addActionListener(this);         fst.addActionListener(this);
		lst.addActionListener(this);
		
		lroll.setBounds(10,10,80,20);     troll.setBounds(100,10,100,20);
		lnm.setBounds(10,40,80,20);       tnm.setBounds(100,40,100,20);
		lage.setBounds(10,70,80,20);      tage.setBounds(100,70,100,20);
		clr.setBounds(10,100,80,20);      add.setBounds(100,100,80,20);
		del.setBounds(190,100,80,20);     updt.setBounds(280,100,80,20);
		ext.setBounds(370,100,80,50);     nxt.setBounds(10,130,80,20);
		prv.setBounds(100,130,80,20);     fst.setBounds(190,130,80,20);
		lst.setBounds(280,130,80,20);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
			
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from mytable order by roll");
			rs.first() ;
			display();
		}
		catch (Exception e)
		{   e.printStackTrace();
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource() == clr)
			{
				troll.setText("");
				tnm.setText("");
				tage.setText("");
				troll.requestFocus();
			}
			
			if(e.getSource() == add)
			{
				sql = "insert into mytable values(" +troll.getText()+ ",'" +tnm.getText()+"'," +tage.getText()+")";
				prstm = cn.prepareStatement(sql);
				prstm.execute() ;
				refresh();
			}
			
			if(e.getSource() == del)
			{
				sql = "delete from mytable where roll ="+troll.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute() ;
				refresh();
			}
			
			if(e.getSource() ==updt)
			{
				sql = "update mytable set name='" +tnm.getText()+"', age=" +tage.getText()+" where roll = "+troll.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute() ;
				refresh();
			}
			
			if(e.getSource() == ext)
			System.exit(0);
			
			//  Part - 2
			
			if(e.getSource() == fst)
			{
				rs.first() ;
				display();
			}
			
			if(e.getSource() == lst)
			{
				rs.last();
				display();
			}
			
			if(e.getSource() == nxt)
			{
				rs.next();
				if(rs.isAfterLast())
					rs.last();
				display();
			}
			
			if(e.getSource() == prv)
			{
				rs.previous();
				if(rs.isBeforeFirst())
					rs.first();
				display();
			}
		}
		catch(Exception ex)
		{  ex.printStackTrace();
		}
	}// EOF actionPerformed
	
	public void refresh()
	{   try
		{
			rs = stm.executeQuery("select * from mytable order by roll");
			rs.next();
			display();
			prstm.close();
		}
		catch(Exception ex)
		{ ex.printStackTrace();}
	}
	
	public void display()
	{   try
		{
			troll.setText(rs.getString(1));
			tnm.setText(rs.getString(2));
			tage.setText(rs.getString(3));
		}
		catch(Exception ex)
		{     ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{  new MyFrame2("DB Connectivity");
	}
}