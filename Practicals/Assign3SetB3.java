import java.awt.event.*;
import javax.swing.*;

class myfrm10 extends JFrame implements ActionListener {

    //1) Define
    char[] arr = new char[10];
    char[] arr1;

    int s,c;
    JLabel j1, j2, j3, j4, j5, j6;
    JTextField jt1, jt2, jt3, jt4;
    JPasswordField jp1, jp2;
    JButton jb1;
    String t1, t2, t3, t4, s1, s2;
    @SuppressWarnings("deprecation")
    public myfrm10() {
        setSize(500, 500);
        setLocation(300, 100);
        setTitle("MY Frm");
        setLayout(null);

        //2) Memory allocation
        j1 = new JLabel("Registration Form");

        j2 = new JLabel("Name");
        jt1 = new JTextField();

        j3 = new JLabel("Login Name");
        jt2 = new JTextField();

        j4 = new JLabel("Password");
        jp1 = new JPasswordField(6);

        j5 = new JLabel("Confirm Password");
        jp2 = new JPasswordField(6);

        j6 = new JLabel("Captcha");
        jt3 = new JTextField();
        jt4 = new JTextField();
        jt3.setEditable(false);
        jb1 = new JButton("Submit");

        //3)Add
        add(j1);
        add(j2);
        add(jt1);

        add(j3);
        add(jt2);

        add(j4);
        add(jp1);

        add(j5);
        add(jp2);

        add(j6);
        add(jt3);
        add(jt4);

        add(jb1);

        //4) Set Bounds
        j1.setBounds(100, 10, 150, 20);
        j2.setBounds(50, 50, 120, 20);
        jt1.setBounds(190, 50, 100, 20);

        j3.setBounds(50, 80, 120, 20);
        jt2.setBounds(190, 80, 100, 20);

        j4.setBounds(50, 110, 120, 20);
        jp1.setBounds(190, 110, 100, 20);

        j5.setBounds(50, 140, 120, 20);
        jp2.setBounds(190, 140, 100, 20);

        j6.setBounds(50, 170, 120, 20);
        jt3.setBounds(190, 170, 50, 20);
        jt4.setBounds(240, 170, 50, 20);

        jb1.setBounds(140, 200, 100, 20);

        int a = new java.util.Random().nextInt(10);
        int b = new java.util.Random().nextInt(10);
        jt3.setText("" + a + "+" + b);
        c=a+b;
        System.out.println("a="+a+"b="+b+"c="+c);
        s1=jp1.getText();
        s2=jp2.getText(); 
        t1 = jt1.getText();
        t2 = jt2.getText();

        //5) Add Listener
        jb1.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        s1=jp1.getText();
        s2=jp2.getText();
        t4=jt4.getText();
        int f=Integer.parseInt(t4);
        if (e.getSource() == jb1) { 
            int a=0,b=0,d=0;
            for (int i = 0; i < s1.length(); i++) { 
                char ch = s1.charAt(i);
                if (((ch >= 65 && ch <= 90))){
                    a+=1;
                }
            } 
            for (int i = 0; i < s1.length(); i++) { 
                char ch = s1.charAt(i);
                if (((ch >= 48 && ch <= 57))){
                    b+=1;
                }
            }
            for (int i = 0; i < s1.length(); i++) { 
                char ch = s1.charAt(i);
                if (((ch==36|| ch ==64 || ch== 38||ch==95))){
                    d+=1;
                }
            }
            if ((jt1.getText().length() == 0) || (jt4.getText().length() == 0) || (jt2.getText().length() == 0) || (jt3.getText().length() == 0) || (jp1.getPassword().length == 0) || (jp2.getPassword().length == 0)) {
                JOptionPane.showMessageDialog(null, "All Fields are Required", "Attension", JOptionPane.ERROR_MESSAGE);
            } else if (jp1.getPassword().length < 6) {
                JOptionPane.showMessageDialog(null, "Password Min 6 letters", "Attension", JOptionPane.ERROR_MESSAGE);
            } else if (!jp1.getText().equals(jp2.getText())) {
                JOptionPane.showMessageDialog(null, "Password Not Matched", "Attension", JOptionPane.ERROR_MESSAGE);
            }else if(a<=0) {
                JOptionPane.showMessageDialog(null, "Password Contains atleast 1 uppercase", "Attension", JOptionPane.ERROR_MESSAGE);
            }
            else if(b<=0) {
                JOptionPane.showMessageDialog(null, "Password Contains atleast 1 Digit", "Attension", JOptionPane.ERROR_MESSAGE);
            }
            else if(d<=0) {
                JOptionPane.showMessageDialog(null, "Password Contains atleast 1 Special Symbol", "Attension", JOptionPane.ERROR_MESSAGE);
            }
            else if(f!=c) {
                JOptionPane.showMessageDialog(null, "Captcha ans is wrong", "Attension", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Sign Up Successfully !!!");
                jt1.setText("");
                jt2.setText("");
                jp1.setText("");
                jp2.setText("");
                jt4.setText("");
            }  
        }
    }

}

class Assign3SetB3 {

    public static void main(String[] args) {
        new myfrm10();
    }
}