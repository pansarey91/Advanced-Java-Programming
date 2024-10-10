import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class MyFrame3 extends JFrame implements ItemListener
{
    JLabel lroll,lnm,lage;
    JTextField tnm,tage;
    @SuppressWarnings("rawtypes")
    JComboBox c1;
    
    Connection cn;
    Statement stm;
    ResultSet rs;
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    MyFrame3(String title)
    {   
        super(title);setLayout(null);
        setSize(300,200);
        setLocation(250,200);
		
        lroll = new JLabel("Roll No.");         lnm = new JLabel("Name");
        lage = new JLabel("Age");               c1 = new JComboBox();
        tnm = new JTextField("");               tage = new JTextField("");
		
        add(lroll);  add(lnm);  add(lage);  add(tnm);  add(tage);   add(c1);
		
        lroll.setBounds(10,10,80,20);       c1.setBounds(100,10,100,20);
        lnm.setBounds(10,40,80,20);         tnm.setBounds(100,40,100,20);
        lage.setBounds(10,70,80,20);        tage.setBounds(100,70,100,20);
		
		
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
			stm = cn.createStatement();
            rs = stm.executeQuery("select * from mytable order by roll");
            while(rs.next())
				c1.addItem(rs.getString("name"));   
		}        
        catch (Exception e) {}
        
        c1.addItemListener(this);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
    public void itemStateChanged(ItemEvent e)
    {
        String sql;
		sql = "select * from mytable where roll="+c1.getSelectedItem().toString();
		try
		{
			rs = stm.executeQuery(sql);
			rs.next();
			tnm.setText(rs.getString(2));
			tage.setText(rs.getString(3));
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	
    public static void main(String args[])
    {
		new MyFrame3("DB Conectivity");
	}
}	