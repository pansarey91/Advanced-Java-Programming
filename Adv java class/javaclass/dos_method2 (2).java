// Prepared statements => pre-compiled SQL statements. 

import java.io.*;	
import java.sql.*;

class dos_method2
{   
	public static void main(String args[]) 
    {
        try
        {
			String name;
			int roll,age;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Connection cn=null;
			PreparedStatement prstm=null;
			String sql;
			
            cn = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
			
			System.out.print("\n\t Enter the Roll No : ");
			roll = Integer.parseInt(br.readLine() );
			System.out.print("\n\t Enter the Name : ");
			name = br.readLine();
			System.out.print("\n\t Enter the Age : ");
			age = Integer.parseInt(br.readLine() );
			
			sql = "insert into mytable values(?,?,?)";
			prstm=cn.prepareStatement(sql);
			prstm.setInt(1,roll);
			prstm.setString(2,name);
			prstm.setInt(3,age);
            prstm.execute();
            prstm.close();
            System.out.println("\n\t *** Record Successfully Inserted ***");
		}
        catch (Exception ee)
        {
            System.out.println(ee);
		}
	}
}