import java.sql.*;
import java.util.*;
public class switchdb {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            String str;
            System.out.println("Enter the Database name : ");
            str=sc.next();
            Connection cn=DriverManager.getConnection("jdbc:mysql:///"+str,"root","root");
            String sql;
            PreparedStatement prstm;
            String name=null;
            while (true) {
                System.out.println("My Operations ");
                System.out.println("1. Create Table");
                System.out.println("2. Insert Data");
                System.out.println("3. Select Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Update Data");
                System.out.println("6. Drop Table");
                System.out.println("7. Exit");
                System.out.println("Enter your choice : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the Table name : ");
                        name = sc.next();
                        sql="create table "+name+"(rno int primary key,name varchar(30),age int)";
                        prstm=cn.prepareStatement(sql);
                        prstm.execute();
                        prstm.close();
                        System.out.println("Table Created Successfully");
                    break;
                    case 2:
                        System.out.println("Enter the Roll No. to Insert : ");
                        int rno=sc.nextInt();
                        System.out.println("Enter the Name Insert : ");
                        String n=sc.next();
                        System.out.println("Enter the Age Insert : ");
                        int age=sc.nextInt();
                        sql="insert into "+name+" values(" +rno+ ",'" +n+"'," +age+")";
                        prstm=cn.prepareStatement(sql);
                        prstm.execute();
                        prstm.close();
                        System.out.println("Record Successfully Inserted !!!");
                    break;
                    case 3:
                        sql="select * from "+name;
                        prstm=cn.prepareStatement(sql);
                        ResultSet rs=prstm.executeQuery();
                        while(rs.next()){
                            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                        }
                        prstm.close();
                    break;
                    case 4:
                        System.out.println("Enter the Roll No. to Delete : ");
                        rno=sc.nextInt();
                        sql="delete from "+name+" where rno="+rno;
                        prstm=cn.prepareStatement(sql);
                        prstm.execute();
                        prstm.close();
                        System.out.println("Record Successfully Deleted !!!");
                    break;
                    case 5:
                        System.out.println("Enter the Roll No. to Update : ");
                        rno=sc.nextInt();
                        System.out.println("Enter the Name Update : ");
                        n=sc.next();
                        System.out.println("Enter the Age Update : ");
                        age=sc.nextInt();
                        sql="update "+name+" set name='"+n+"',age="+age+" where rno="+rno;
                        prstm=cn.prepareStatement(sql);
                        prstm.execute();
                        prstm.close();
                        System.out.println("Record Successfully Updated !!!");
                    break;
                    case 6:
                        sql="drop table "+name;
                        prstm=cn.prepareStatement(sql);
                        prstm.execute();
                        prstm.close();
                        System.out.println("Table Successfully Deleted !!!");
                    break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                    sc.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }  
    }
}