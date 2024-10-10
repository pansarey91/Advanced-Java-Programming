import javax.swing.*;
import java.sql.*;
// import javax.swing.event.*;
import java.awt.event.*;
public class switchframe extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton b1;
    JTextArea t1,t2,t3;
    Connection cn;
    PreparedStatement prstm;
    String sql;
    switchframe()
    {
        super("switch frame");
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,200);

        try {
            cn=DriverManager.getConnection("jdbc:mysql:///mydatabase","root","root");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        l1 = new JLabel("Enter Roll no:");
        l2= new JLabel("Enter Name:");
        l3= new JLabel("Enter Age");

        t1 = new JTextArea();
        t2 = new JTextArea();
        t3 = new JTextArea();

        b1 = new JButton("Submit");

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(b1);

        l1.setBounds(50,50,100,20);
        l2.setBounds(50,100,100,20);
        l3.setBounds(50,150,100,20);
        t1.setBounds(150,50,100,20);
        t2.setBounds(150,100,100,20);
        t3.setBounds(150,150,100,20);
        b1.setBounds(150,200,100,20);
        
        setVisible(true);

        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String name = t2.getText();
            int rno = Integer.parseInt(t1.getText());
            int age = Integer.parseInt(t3.getText());

            try {
                sql="insert into student values("+rno+",'"+name+"',"+age+")";
                prstm=cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                JOptionPane.showMessageDialog(this,"Record Successfully Inserted !!!");
                t1.setText("");
                t2.setText("");
                t3.setText("");
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }
    public static void main(String[] args) {
        new switchframe();
    }
}
