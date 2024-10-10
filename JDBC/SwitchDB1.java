import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwitchDB1 extends JFrame implements ActionListener {
    Connection cn;
    PreparedStatement prstm;
    String tableName = null;

    JButton btnCreateTable, btnInsertData, btnSelectData, btnDeleteData, btnUpdateData, btnDropTable, btnExit;
    JTextArea textArea;
    JTextField txtTableName, txtRollNo, txtName, txtAge;

    public SwitchDB1() {
        setTitle("Database Operations");
        setLayout(new FlowLayout());
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 50);
        add(new JScrollPane(textArea));

        // Input Fields
        txtTableName = new JTextField(20);
        txtRollNo = new JTextField(20);
        txtName = new JTextField(20);
        txtAge = new JTextField(20);

        add(new JLabel("Table Name:"));
        add(txtTableName);
        add(new JLabel("Roll No:"));
        add(txtRollNo);
        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Age:"));
        add(txtAge);

        // Buttons
        btnCreateTable = new JButton("Create Table");
        btnInsertData = new JButton("Insert Data");
        btnSelectData = new JButton("Select Data");
        btnDeleteData = new JButton("Delete Data");
        btnUpdateData = new JButton("Update Data");
        btnDropTable = new JButton("Drop Table");
        btnExit = new JButton("Exit");

        btnCreateTable.addActionListener(this);
        btnInsertData.addActionListener(this);
        btnSelectData.addActionListener(this);
        btnDeleteData.addActionListener(this);
        btnUpdateData.addActionListener(this);
        btnDropTable.addActionListener(this);
        btnExit.addActionListener(this);

        add(btnCreateTable);
        add(btnInsertData);
        add(btnSelectData);
        add(btnDeleteData);
        add(btnUpdateData);
        add(btnDropTable);
        add(btnExit);

        setVisible(true);

        // Connect to the database
        try {
            String dbName = JOptionPane.showInputDialog(this, "Enter the Database name:");
            cn = DriverManager.getConnection("jdbc:mysql:///" + dbName, "root", "root");
        } catch (SQLException e) {
            textArea.append("Database Connection Error: " + e.getMessage() + "\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnCreateTable) {
                tableName = txtTableName.getText();
                String sql = "CREATE TABLE " + tableName + "(rno INT PRIMARY KEY, name VARCHAR(30), age INT)";
                prstm = cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                textArea.append("Table Created Successfully\n");

            } else if (e.getSource() == btnInsertData) {
                int rno = Integer.parseInt(txtRollNo.getText());
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String sql = "INSERT INTO " + tableName + " VALUES(" + rno + ",'" + name + "'," + age + ")";
                prstm = cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                textArea.append("Record Successfully Inserted !!!\n");

            } else if (e.getSource() == btnSelectData) {
                String sql = "SELECT * FROM " + tableName;
                prstm = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = prstm.executeQuery();
            
                // Display data in JTable
                ResultSetMetaData rsmd = rs.getMetaData();
                int columns = rsmd.getColumnCount();
                String[] columnNames = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    columnNames[i - 1] = rsmd.getColumnName(i);
                }
            
                rs.last();
                int rows = rs.getRow();
                rs.beforeFirst();
            
                Object[][] data = new Object[rows][columns];
                int row = 0;
                while (rs.next()) {
                    for (int i = 1; i <= columns; i++) {
                        data[row][i - 1] = rs.getObject(i);
                    }
                    row++;
                }
            
                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame resultFrame = new JFrame("Table Data");
                resultFrame.setSize(400, 300);
                resultFrame.add(scrollPane);
                resultFrame.setVisible(true);
            
                prstm.close();
            }
             else if (e.getSource() == btnDeleteData) {
                int rno = Integer.parseInt(txtRollNo.getText());
                String sql = "DELETE FROM " + tableName + " WHERE rno=" + rno;
                prstm = cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                textArea.append("Record Successfully Deleted !!!\n");

            } else if (e.getSource() == btnUpdateData) {
                int rno = Integer.parseInt(txtRollNo.getText());
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String sql = "UPDATE " + tableName + " SET name='" + name + "', age=" + age + " WHERE rno=" + rno;
                prstm = cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                textArea.append("Record Successfully Updated !!!\n");

            } else if (e.getSource() == btnDropTable) {
                String sql = "DROP TABLE " + tableName;
                prstm = cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                textArea.append("Table Successfully Deleted !!!\n");

            } else if (e.getSource() == btnExit) {
                System.exit(0);
            }
        } catch (SQLException ex) {
            textArea.append("Error: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        new SwitchDB1();
    }
}
