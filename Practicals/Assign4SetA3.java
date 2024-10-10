import java.sql.*;

public class Assign4SetA3 {
       public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            System.out.println("Total Columns: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("\nColumn " + i + " Info:");
                System.out.println("Column Name: " + rsMetaData.getColumnName(i));
                System.out.println("Column Type: " + rsMetaData.getColumnTypeName(i));
                System.out.println("Column Size: " + rsMetaData.getColumnDisplaySize(i));
                System.out.println("Is Nullable: " + (rsMetaData.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));
                System.out.println("Is Auto Increment: " + (rsMetaData.isAutoIncrement(i) ? "YES" : "NO"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}