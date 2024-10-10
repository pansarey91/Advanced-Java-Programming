import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class MyFrame1 extends JFrame implements ActionListener
{
    JLabel lroll,lnm,lage;
    JTextField troll,tnm,tage;
    JButton clr,add,del,updt,ext;
	
    Connection cn;
    String sql;
    PreparedStatement prstm;
	
    MyFrame1(String title)
    {
        super(title);        setLayout(null);
        setSize(500,200);    setVisible(true);
        setLocation(250,200);
		
        lroll = new JLabel("Roll No.");    lnm = new JLabel("Name");
        lage = new JLabel("Age");
        troll = new JTextField("");        tnm = new JTextField("");
        tage = new JTextField("");
        clr = new JButton("Clear");        add = new JButton("ADD");
        del = new JButton("Delete");       ext = new JButton("EXIT");
        updt = new JButton("UPDT");
		
        add(lroll);  add(lnm);  add(lage);
        add(troll);  add(tnm);  add(tage);
        add(clr);    add(add);  add(ext);  add(updt);  add(del);
		
        clr.addActionListener(this);        add.addActionListener(this);
        updt.addActionListener(this);       del.addActionListener(this);
        ext.addActionListener(this);
		
        lroll.setBounds(10,10,80,20);     troll.setBounds(100,10,100,20);
        lnm.setBounds(10,40,80,20);       tnm.setBounds(100,40,100,20);
        lage.setBounds(10,70,80,20);      tage.setBounds(100,70,100,20);
        clr.setBounds(10,100,80,20);      add.setBounds(100,100,80,20);
        del.setBounds(190,100,80,20);     updt.setBounds(280,100,80,20);
        ext.setBounds(370,100,80,20);
		
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
		}
        catch(Exception e)
        { e.printStackTrace();
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
			}
			
            if(e.getSource() == add)
            {
                sql = "insert into mytable values(" +troll.getText()+ ",'"
				+tnm.getText()+"'," +tage.getText()+")";
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Saved Successfully !!!");
			}
			
            if(e.getSource() == del)
            {
                sql = "delete from mytable where roll ="+troll.getText();
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!!");
			}
			
            if(e.getSource() ==updt)
            {
                sql = "update mytable set name='" +tnm.getText()+"', age="
				+tage.getText()+" where roll = "+troll.getText();
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Updated Successfully !!!");
			}
			
            if(e.getSource() == ext)
			System.exit(0);
		} // End of Try
		catch (SQLException e1)
		{    System.out.println(e1);
		}
	} // End of ActionListener
	
    public static void main(String args[])
    {
        new MyFrame1("DB Conectivity");
	}
}

