import javax.swing.*;
import java.sql.*;
class JTableDB1 extends JFrame
{
    String colHeads[] = { "Roll No", "Name", "Age" };
    String data[][];
    JTable table;

    Connection cn;    Statement stm;
    ResultSet rs;    int r_cnt=0,i;

    JTableDB1()
    {
        super("Table & DB Connectivity");
        setSize(300,200);
        setLocation(250,250);

        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///mydatabase","root", "root");
            stm = cn.createStatement();
            rs = stm.executeQuery("select count(*) from student");
            rs.next();
            r_cnt=rs.getInt(1);

            data = new String[r_cnt][3];

            rs = stm.executeQuery("select * from student order by rollno");
            while (rs.next())
            {
                data[i][0]= rs.getString(1);                
				data[i][1]= rs.getString(2);
                data[i][2]= rs.getString(3);
                i++;
            }
            
            table = new JTable(data, colHeads);            
			add(table);
            table.setEnabled(false);
            int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
            int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
            JScrollPane jsp = new JScrollPane(table, v, h);
            add(jsp);
        }
        catch (Exception e) 
		{            
			e.printStackTrace();        
		}

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new JTableDB1();
    }
}