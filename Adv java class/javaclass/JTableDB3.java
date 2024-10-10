import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/*
create table mytable2
(
roll numeric(5) primary key,
name varchar(100),
dt date
);

insert into mytable2 values(1,'aaa','2016-12-8');
insert into mytable2 values(2,'bbb','2016-11-6');
insert into mytable2 values(3,'ccc','2016-12-6');
insert into mytable2 values(4,'ddd','2016-11-25');
insert into mytable2 values(5,'eee','2016-12-2');

select * from mytable2;

*/

class JTableDB3 extends JFrame implements ActionListener
{
    JLabel lroll,lnm,ldate;
    JTextField troll,tnm;
    JButton clr,add,ext,dispAll,dispRange;
    DateButton calb,dateFrom,dateTo;

    Connection cn;
    Statement stm;
    ResultSet rs;
    String sql;
    PreparedStatement prstm;

    JTableDB3()
    {
        super("Table & DB Connectivity");
        setLayout(null);
        setSize(600,400);
        setVisible(true);
        setLocation(350,200);

        lroll = new JLabel("Roll No.");
        lnm = new JLabel("Name");
        ldate = new JLabel("Date");
        troll = new JTextField();
        tnm = new JTextField();

        dispAll = new JButton("Display All");
        dispRange = new JButton("Display in Range");
        clr = new JButton("CLEAR");
        add = new JButton("ADD");
        ext = new JButton("EXIT");

        calb = new DateButton();
        dateFrom = new DateButton();
        dateTo = new DateButton();

        add(lroll);		add(lnm);	add(ldate);
        add(troll);     add(tnm);	add(calb);
        add(clr);       add(add);   add(ext);
        add(dispAll);   add(dispRange);
        add(dateFrom);  add(dateTo);

        clr.addActionListener(this);
        add.addActionListener(this);
        ext.addActionListener(this);
        dispAll.addActionListener(this);
        dispRange.addActionListener(this);

        lroll.setBounds(10,10,80,20);	troll.setBounds(100,10,100,20);
        lnm.setBounds(10,40,80,20);     tnm.setBounds(100,40,100,20);
        ldate.setBounds(10,70,80,20);   calb.setBounds(100,70,100,20);
        clr.setBounds(10,100,90,20);    add.setBounds(110,100,90,20);
        ext.setBounds(10,130,190,20);

        dispAll.setBounds(10,180,210,20);	dateFrom.setBounds(10,230,100,20);
        dateTo.setBounds(120,230,100,20);	dispRange.setBounds(10,260,210,20);

        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
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
                sql = "insert into mytable2 values(" +troll.getText()+ ",'" +tnm.getText()+"','" + calb.getText()+"')";
                prstm = cn.prepareStatement(sql);
                prstm.execute() ;
                prstm.close();
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully !!!");
            }

            if (e.getSource() == ext)
            {
                System.exit(0);
            }

            if (e.getSource() == dispAll)
            {
                updateTable("select count(*) from mytable2","select * from mytable2 order by dt");
            }

            if (e.getSource() == dispRange)
            {
                updateTable("select count(*) from mytable2 where dt between '" + dateFrom.getText() + "' and '" + dateTo.getText() + "'","select * from mytable2 where dt between '" + dateFrom.getText() + "' and '" + dateTo.getText() + "' order by dt");
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
        troll.requestFocus();
    }

    void updateTable(String s1,String s2)
    {
        try
        {
			// 1) Memory allocation to Array
            rs = stm.executeQuery(s1);
            rs.first();
            int rowcnt = rs.getInt(1);

            String colHeads[] = { "Roll No", "Name", "Date" };
            String data[][] = new String[rowcnt][3];

			// 2) Load Data into array
            rs = stm.executeQuery(s2);
            rs.first();

            for (int i=0;i<rowcnt;i++)
            {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);

                rs.next();
            }

			// 3) create table
            JTable table = new JTable(data, colHeads);
            add(table);
            table.setEnabled(false);
            JScrollPane jsp = new JScrollPane(table);
            add(jsp);
            jsp.setBounds(250,10,250,270);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new JTableDB3();
    }
}
