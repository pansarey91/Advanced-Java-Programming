import java.sql.*;
import java.util.*;
public class table {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            Connection cn =DriverManager.getConnection("jdbc:mysql:///mydatabase", "root", "root");
            PreparedStatement prstm;
            String sql;

            System.out.println("Enter the Table name : ");
            String name = sc.next();

            sql="create table "+name+"(company varchar(30),milage int,price int)";
            prstm=cn.prepareStatement(sql);
            prstm.execute();
            prstm.close();

            sc.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
