import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class JTableDB2 extends JFrame implements ActionListener
{
    JLabel lroll,lnm,lage;
    JTextField troll,tnm,tage;
    JButton clr,add,del,updt,view,ext;

    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
    PreparedStatement prstm;

    JTableDB2()
    {
        super("Table & DB Connectivity");
        setLayout(null);
        setSize(350,500);
        setVisible(true);
        setLocation(350,200);

        lroll = new JLabel("Roll No.");
        lnm = new JLabel("Name");
        lage = new JLabel("Age");
        troll = new JTextField("");
        tnm = new JTextField("");
        tage = new JTextField("");
        clr = new JButton("CLEAR");
        add = new JButton("ADD");
        del = new JButton("Delete");
        view = new JButton("VIEW");
        updt = new JButton("UPDATE");
        ext = new JButton("EXIT");

        add(lroll);
        add(lnm);
        add(lage);
        add(troll);
        add(tnm);
        add(tage);
        add(clr);
        add(add);
        add(view);
        add(updt);
        add(del);
        add(ext);

        clr.addActionListener(this);
        add.addActionListener(this);
        updt.addActionListener(this);
        del.addActionListener(this);
        view.addActionListener(this);
        ext.addActionListener(this);

        lroll.setBounds(10,10,80,20);
        troll.setBounds(100,10,100,20);
        lnm.setBounds(10,40,80,20);
        tnm.setBounds(100,40,100,20);
        lage.setBounds(10,70,80,20);
        tage.setBounds(100,70,100,20);
        clr.setBounds(10,100,80,20);
        add.setBounds(100,100,80,20);
        del.setBounds(190,100,80,20);
        updt.setBounds(10,130,80,20);
        view.setBounds(100,130,80,20);
        ext.setBounds(190,130,80,20);

        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
            stm = cn.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        troll.requestFocus();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if (e.getSource() == clr)
            {
                clearAll();
            }

            if (e.getSource() == add)
            {
                sql = "insert into mytable values(" +troll.getText()+ ",'" +tnm.getText()+"'," +tage.getText()+")";
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully !!!");
                updateTable();
                clearAll();
            }

            if (e.getSource() == del)
            {
                sql = "delete from mytable where roll ="+troll.getText();
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!!");
                updateTable();
                clearAll();
            }

            if (e.getSource() ==updt)
            {
                sql = "update mytable set name='" +tnm.getText()+"', age=" +tage.getText()+" where roll = "+troll.getText();
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Updated Successfully !!!");
                updateTable();
                clearAll();
            }

            if (e.getSource() == view)
            {
                updateTable();
                clearAll();
            }

            if (e.getSource() == ext)
            {
                System.exit(0);
            }
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }

    void clearAll()
    {
        troll.setText("");
        tnm.setText("");
        tage.setText("");
        troll.requestFocus();
    }

    void updateTable()
    {
        try
        {
            rs = stm.executeQuery("select count(*) from mytable");
            rs.first();
            int rowcnt = rs.getInt(1);

            String colHeads[] = { "Roll No", "Name", "Age" };
            String data[][] = new String[rowcnt][3];

            rs = stm.executeQuery("select * from mytable");
            rs.first();

            for (int i=0;i<rowcnt;i++)
            {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);

                rs.next();
            }

            JTable table = new JTable(data, colHeads);
            add(table);
            table.setEnabled(false);
            JScrollPane jsp = new JScrollPane(table);
            add(jsp);
            jsp.setBounds(10,160,250,250);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new JTableDB2();
    }
}