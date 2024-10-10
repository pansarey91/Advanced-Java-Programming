import java.sql.*;
import java.util.*;

public class dosclass1 {
    public static void main(String[] args) {
      try {
        String name;
        int rno,age;
        Scanner sc=new Scanner(System.in);

        Connection cn=null;
        PreparedStatement prstm;
        String sql;

        cn =DriverManager.getConnection("jdbc:mysql:///mydatabase","root","root");

        System.out.println("Enter the Roll No. :");
        rno=sc.nextInt();
        System.out.println("Enter the Name :");
        name=sc.next();
        System.out.println("Enter the Age :");
        age=sc.nextInt();

        sql="insert into mytable values(" +rno+ ",'" +name+"'," +age+")";
        prstm=cn.prepareStatement(sql);
        prstm.execute();
        prstm.close();
        System.out.println("Record Successfully Inserted !!!");      
        sc.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    
}
