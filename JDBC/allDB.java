import java.sql.*;
import java.util.*;
public class allDB {
    public static void main(String[] args) {
        try {
            Scanner sc =new Scanner(System.in);
            Connection cn=DriverManager.getConnection("jdbc:mysql:///mydatabase","root","root");
            PreparedStatement prstm;
            String sql;

            System.out.println("Enter the Table name : ");
            String name = sc.next();

            //table
            sql="create table "+name+"(rno int primary key,name varchar(30),age int)";
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();
            System.out.println("Table Created Successfully");

            System.out.println("Enter the Roll No. to Insert :");
            int rno=sc.nextInt();
            System.out.println("Enter the Name Insert :");
            String n=sc.next();
            System.out.println("Enter the Age Insert :");
            int age=sc.nextInt();
            // insert
            sql="insert into "+name+" values(" +rno+ ",'" +n+"'," +age+")";
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();
            System.out.println("Record Successfully Inserted !!!");
            // select
            sql="select * from "+name;
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();
            System.out.println("Record Displayed Successfully !!!");
            
           
            System.out.println("Enter the Roll No. to Update the record :");
            int urno=sc.nextInt();
            System.out.println("Enter the Name to Update the record :");
            String n1=sc.next();
            //update
            sql = "update " + name + " set name= '" + n1 + "' where rno=" + urno;
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();
            System.out.println("Record Updated  Successfully !!!");
            
            System.out.println("Enter the Roll No. to Delete the record :");
            int drno=sc.nextInt();
            // delete
            sql="delete from "+name+" where rno="+drno;
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();
            System.out.println("Record Deleted  Successfully !!!");
            sc.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}