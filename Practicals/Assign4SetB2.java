import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Assign4SetB2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2, l3, l4;
    Connection cn;
    Statement stm;
    ResultSet rs;
    PreparedStatement prstm;
    String sql;
    Assign4SetB2() {
        setTitle("Phone Book ");  setSize(600, 600);
        setDefaultCloseOperation(3);
        setLocation(400, 100);
        setLayout(null);
        l1 = new JLabel("Name");
        l2 = new JLabel("Address");
        l3 = new JLabel("Phone Number");
        l4 = new JLabel("Email");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        b1 = new JButton("<<");
        b2 = new JButton("Delete");
        b3 = new JButton("Update");
        b4 = new JButton(">>");
        b5 = new JButton("Exit");
        add(l1); add(l2); add(l3); add(l4);
        add(t1); add(t2); add(t3); add(t4);
        add(b1); add(b2); add(b3); add(b4);
        add(b5);
        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 100, 100, 20);
        l3.setBounds(50, 150, 100, 20);
        l4.setBounds(50, 200, 100, 20);
        t1.setBounds(250, 50, 150, 20);
        t2.setBounds(250, 100, 150, 20);
        t3.setBounds(250, 150, 150, 20);
        t4.setBounds(250, 200, 150, 20);
        b1.setBounds(50, 250, 80, 20);
        b2.setBounds(140, 250, 80, 20);
        b3.setBounds(230, 250, 80, 20);
        b4.setBounds(320, 250, 80, 20);
        b5.setBounds(410, 250, 80, 20);
        b1.addActionListener(this); b2.addActionListener(this);
        b3.addActionListener(this); b4.addActionListener(this);
        b5.addActionListener(this);
        try {
            cn = DriverManager.getConnection("jdbc:mysql:///java_db", "root", "root");
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("SELECT * FROM phonebook ORDER BY name");
            if (rs.first()) {
                display();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b5) {
                System.exit(0);
            } else if (ae.getSource() == b4) {
                if (rs.next()) {
                    display();
                } else {
                    rs.last();
                }
            } else if (ae.getSource() == b1) {
                if (rs.previous()) {
                    display();
                } else {
                    rs.first();
                }
            } else if (ae.getSource() == b2) { // Delete
                sql = "DELETE FROM phonebook WHERE phone_number = ?";
                prstm = cn.prepareStatement(sql);
                prstm.setString(1, t3.getText());
                prstm.executeUpdate();
                refresh();
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
            } else if (ae.getSource() == b3) { // Update
                if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!", "Save Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    sql = "UPDATE phonebook SET name = ?, address = ?, phone_number = ?, email = ? WHERE phone_number = ?";
                    prstm = cn.prepareStatement(sql);
                    prstm.setString(1, t1.getText());
                    prstm.setString(2, t2.getText());
                    prstm.setString(3, t3.getText());
                    prstm.setString(4, t4.getText());
                    prstm.setString(5, t3.getText());
                    prstm.executeUpdate();
                    refresh();
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void refresh() {
        try {
            rs = stm.executeQuery("SELECT * FROM phonebook ORDER BY name");
            if (rs.first()) {
                display();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void display() {
        try {
            t1.setText(rs.getString("name"));
            t2.setText(rs.getString("address"));
            t3.setText(rs.getString("phone_number"));
            t4.setText(rs.getString("email"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Assign4SetB2();
    }
}