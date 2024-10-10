import java.sql.*;

public class Assign4SetA2 {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "root");
            DatabaseMetaData dbMetaData = conn.getMetaData();

            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("JDBC Driver Name: " + dbMetaData.getDriverName());
            System.out.println("JDBC Driver Version: " + dbMetaData.getDriverVersion());
            System.out.println("User Name: " + dbMetaData.getUserName());
            System.out.println("URL: " + dbMetaData.getURL());

            System.out.println("\nTables in the database:");
            String[] types = {"TABLE"};
            ResultSet rsTables = dbMetaData.getTables(null, null, "%", types);

            while (rsTables.next()) {
                String tableName = rsTables.getString("TABLE_NAME");
                String tableSchema = rsTables.getString("TABLE_SCHEM");
                System.out.println("Table: " + tableName + " | Schema: " + tableSchema);
            }

            rsTables.close();
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
