import java.sql.*;
import java.util.Scanner;

public class Assign4SetB1 {
    public static void main(String[] args) {
        Connection conn = null;
        Scanner scanner = new Scanner(System.in);

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "root");
            System.out.println("Connected to database.");
            int choice;
            do {
                System.out.println("\n--- Student Table Operations ---");
                System.out.println("1. Insert");
                System.out.println("2. Modify");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. View All");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, scanner);
                        break;
                    case 2:
                        modifyStudent(conn, scanner);
                        break;
                    case 3:
                        deleteStudent(conn, scanner);
                        break;
                    case 4:
                        searchStudent(conn, scanner);
                        break;
                    case 5:
                        viewAllStudents(conn);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 6);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Disconnected from database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
            }
        }
        scanner.close();
    }
    private static void insertStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Percentage: ");
        double percentage = scanner.nextDouble();

        String query = "INSERT INTO student (roll_number, name, percentage) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, rollNumber);
        pstmt.setString(2, name);
        pstmt.setDouble(3, percentage);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student inserted successfully.");
        } else {
            System.out.println("Error inserting student.");
        }
    }
    private static void modifyStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Roll Number of the student to modify: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter New Name: ");
        String newName = scanner.next();
        System.out.print("Enter New Percentage: ");
        double newPercentage = scanner.nextDouble();

        String query = "UPDATE student SET name = ?, percentage = ? WHERE roll_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newName);
        pstmt.setDouble(2, newPercentage);
        pstmt.setInt(3, rollNumber);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student modified successfully.");
        } else {
            System.out.println("Error modifying student or Roll Number not found.");
        }
    }
    private static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Roll Number of the student to delete: ");
        int rollNumber = scanner.nextInt();

        String query = "DELETE FROM student WHERE roll_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, rollNumber);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Error deleting student or Roll Number not found.");
        }
    }
    private static void searchStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Roll Number of the student to search: ");
        int rollNumber = scanner.nextInt();

        String query = "SELECT * FROM student WHERE roll_number = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, rollNumber);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Roll Number: " + rs.getInt("roll_number"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Percentage: " + rs.getDouble("percentage"));
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void viewAllStudents(Connection conn) throws SQLException {
        String query = "SELECT * FROM student";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\n--- Student List ---");
        while (rs.next()) {
            System.out.println("Roll Number: " + rs.getInt("roll_number"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Percentage: " + rs.getDouble("percentage"));
            System.out.println("-------------------------");
        }
    }
}