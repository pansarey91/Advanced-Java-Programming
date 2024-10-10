import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Hashtable;
public class Assign1SetB1 extends JFrame implements ActionListener {
    // Declaration
    JTextField t1,t2,t3,t4;
    JTextArea ta;
    JButton b1,b2,b3;
    Hashtable<String,Integer> ht;
    Assign1SetB1() {
        setTitle("Assignment 1 Set B-1");
        setLayout(null);
        setSize(500, 300);
        setLocation(500, 200);
        setVisible(true);
        setDefaultCloseOperation(3);
        //memeory allocation
        ht=new Hashtable<>();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        ta = new JTextArea();
        b1 = new JButton("Add");
        b2 = new JButton("Remove");
        b3 = new JButton("Search");
        //add the components
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(ta);
        add(b1);
        add(b2);
        add(b3);
        //set bounds
        ta.setBounds(50, 50, 200, 150);
        t1.setBounds(260, 50, 100, 30);
        t2.setBounds(370, 50, 100, 30);
        b1.setBounds(310, 90, 100, 30);
        t3.setBounds(260, 130, 100, 30);
        b2.setBounds(260, 170, 100, 30);
        t4.setBounds(370, 130, 100, 30);
        b3.setBounds(370, 170, 100, 30);
        // add Listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = t1.getText();
            int n = Integer.parseInt(t2.getText());
            if(!ht.containsValue(n))
            {
                ht.put(s1, n);
                ta.setText(""); 
                Enumeration<String> keys = ht.keys();
                Enumeration<Integer> values=ht.elements();
                while( keys.hasMoreElements() && values.hasMoreElements()) {
                    ta.append(keys.nextElement()+" - "+values.nextElement() + "\n");
                }
                t1.setText("");
                t2.setText("");
            }
            else
                JOptionPane.showMessageDialog(null,"Plz change the Code");
        }
        if(e.getSource() == b2) {
            String s3 = t3.getText();
            Integer r = ht.remove(s3);
            if (r != null) {
                JOptionPane.showMessageDialog(null, "Key is removed");
                ta.setText("");
                Enumeration<String> keys = ht.keys();
                Enumeration<Integer> values=ht.elements(); 
                while( keys.hasMoreElements() && values.hasMoreElements()) {
                    ta.append(keys.nextElement()+" - "+values.nextElement() + "\n");
                }
            } else
                JOptionPane.showMessageDialog(null, "Key not found");
            t3.setText("");
        }
        if(e.getSource() == b3) {
            String s4 = t4.getText();
            if(ht.containsKey(s4)) {
                int n = ht.get(s4);
                JOptionPane.showMessageDialog(null, "Key is present with value: " + n);
            }
            else 
                JOptionPane.showMessageDialog(null, "Key is not present");
            t4.setText("");
        }
    }
    public static void main(String[] args){
            new Assign1SetB1();
    }
}