// Whenever we create a ResultSet object, 
// which never allows us to update the database through 
// ResultSet object and it allows retrieving the data only in 
// forward direction. 
// Such type of ResultSet is known as non-updatable 
// and non-scrollable ResultSet.

import java.sql.*;

class dos1
{
    public static void main(String args[])
    {
        int cnt=0;
        Connection cn;
        Statement stm;
        ResultSet rs;      
		
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
			stm = cn.createStatement();
			
            rs = stm.executeQuery("select * from mytable");
            while(rs.next())
            {
				System.out.print("\n\t"+rs.getString("roll")+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3));
				cnt++;
            }
            rs.close();
			
            System.out.println("\n\n\t *** Total No. of Records : "+cnt);
		}
		catch (Exception e)
		{
			System.out.println(e);            
		}
	}
}