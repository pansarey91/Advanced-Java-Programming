import java.io.*;	
import java.sql.*;

class dos
{   
	public static void main(String args[]) 
    {
        try
        {
			String name;
			int roll,age;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Connection cn=null;
			PreparedStatement prstm;
			String sql;
			
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ras","root", "");
			
			System.out.print("\n\t Enter the Roll No : ");
			roll = Integer.parseInt(br.readLine() );
			System.out.print("\n\t Enter the Name : ");
			name = br.readLine();
			System.out.print("\n\t Enter the Age : ");
			age = Integer.parseInt(br.readLine() );
			
			sql = "insert into mytable values(" +roll+ ",'" +name+"'," +age+")";
            prstm = cn.prepareStatement(sql);
            prstm.execute() ;
            prstm.close();
            System.out.println("\n\t *** Record Successfully Inserted ***");
		}
        catch (Exception ee)
        {
            System.out.println(ee);
		}
	}
}