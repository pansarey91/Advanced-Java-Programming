/* Updatable ResultSet

Whenever we create a ResultSet object, which never allows us to update the database through ResultSet object and it allows retrieving the data only in forward direction.
Such type of ResultSet is known as non-updatable and non-scrollable ResultSet.
In order to make the ResultSet object as updatable and scrollable, we must use the following constants which are present in ResultSet.
int Type => TYPE_SCROLL_SENSITIVE
int Mode => CONCUR_UPDATABLE  

public Statement createStatement(int Type, int Mode);

*/

import java.sql.*;

class dos2
{
    public static void main(String args[])
    {
        int cnt=0;
        Connection cn;       
		Statement stm;
        ResultSet rs; 
		
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql:///ras","root","");
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			
			System.out.print(" *** Table Data - Before RS OP ***");
            rs = stm.executeQuery("select * from mytable order by roll");
            while(rs.next())
            {
				System.out.print("\n\t"+rs.getString("roll")+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3));
			}


			// Updating First Row from table
			rs.absolute(1);
			rs.updateString(2,"NewName");
			rs.updateInt(3,99);
			rs.updateRow();

			// Deleting Third Row from table
			rs.absolute(3);
			rs.deleteRow();

			// Inserting Row in Table 
			rs.moveToInsertRow();
			rs.updateInt(1,6);
			rs.updateString(2,"NewStud");
			rs.updateInt(3,25);
			rs.insertRow();
			
			System.out.print("\n\n *** Table Data - After RS OP ***");
			rs.beforeFirst();
            while(rs.next())
            {
				System.out.print("\n\t"+rs.getString("roll")+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3));
			}
						
			rs.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}