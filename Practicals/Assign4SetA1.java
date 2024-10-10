import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Assign4SetA1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        tableModel.addColumn("Roll Number");
        tableModel.addColumn("Name");
        tableModel.addColumn("Percentage");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                int rollNumber = rs.getInt("roll_number");
                String name = rs.getString("name");
                double percentage = rs.getDouble("percentage");
                tableModel.addRow(new Object[]{rollNumber, name, percentage});
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
