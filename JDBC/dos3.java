import java.sql.*;
import java.util.*;

class dos3
{
    public static void main(String args[])
    {
        int cnt=0;
        Connection cn;       Statement stm;
        ResultSet rs;        PreparedStatement prstm;
        String sql;		     Scanner s;
        String name;         int roll,age,ch;
		
        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
            stm = cn.createStatement();
			
            s = new Scanner(System.in);
            while (true)
            {
				System.out.print("\n\t *** Menu ***");
				System.out.print("\n\t 1. Display");
				System.out.print("\n\t 2. Insert");
				System.out.print("\n\t 3. Update");
				System.out.print("\n\t 4. Delete");
				System.out.print("\n\t 5. Search");
				System.out.print("\n\t 6. Exit");
				System.out.print("\n\n\t Enter Your Choice = ");
				ch = s.nextInt();
			
				if(ch==6)
					System.exit(0);
			
				switch (ch)
				{
				case 1:
					rs = stm.executeQuery("select * from mytable");
					while (rs.next())
					{
						System.out.print("\n\t"+rs.getString(1)+"\t");
						System.out.print(rs.getString(2)+"\t");
						System.out.print(rs.getString(3));
						cnt++;
					}
					rs.close();
					System.out.println("\n\n\t *** Total No. of Records : "+cnt);
					break;
				
				case 2:
					System.out.println("\n\t Enter the Roll No, Name & Marks : ");
					roll = s.nextInt();		name = s.next();	age = s.nextInt();
					
					sql = "insert into mytable values(" +roll+ ",'" +name+"'," +age+")";
					prstm = cn.prepareStatement(sql);
					prstm.execute();	prstm.close();
					System.out.println("\n\t *** Record Successfully Inserted ***");	
					break;
				
				case 3:
					System.out.println("\n\t Enter the Roll No to Update : ");
					roll = s.nextInt();
					System.out.println("\n\t Enter New Name & New Age : ");					
					name = s.next();	age = s.nextInt();
					
					sql = "update mytable set name='" +name+"', age="+age+" where roll="+roll;
					prstm = cn.prepareStatement(sql);
					prstm.execute();	prstm.close();
					System.out.println("\n\t *** Record Successfully Updated ***");	
					break;
				
				case 4:
					System.out.println("\n\t Enter the Roll No to Delete : ");
					roll = s.nextInt();
					
					sql = "delete from mytable where roll="+roll;
					prstm = cn.prepareStatement(sql);
					prstm.execute() ;
					prstm.close();
					System.out.println("\n\t *** Record Successfully Deleted ***");	
					break;

				case 5:
				try
				{
					System.out.println("\n\t Enter the Roll No to Search : ");
					roll = s.nextInt();
					rs = stm.executeQuery("select * from mytable where roll = "+roll);
					rs.first();
					System.out.print("\n\t Roll = "+rs.getString(1)+"\t Name = " + rs.getString(2)+"\t Age "+rs.getString(3));					
				}
				catch(Exception exx)
				{
					System.out.println("\n\t Student NOT Found !!! ");
				}

				}	// end of Switch
            }	// end of While
		}	// end of try
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}