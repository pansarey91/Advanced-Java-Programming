import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrm extends JFrame implements ItemListener {
    // Declaration
    JLabel l1, l2, l3;
    JComboBox<String> cmb1;
    JComboBox<Integer> cmb2;
    JCheckBox cb1, cb2;
    JTextField t1;

    MyFrm() {
        setVisible(true);
        setTitle("YASH FRAME");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Memory Allocation
        l1 = new JLabel("FONT");
        l2 = new JLabel("SIZE");
        l3 = new JLabel("STYLE");

        String[] fonts = {"Arial", "Algerian", "Parchment", "Times New Roman"};
        cmb1 = new JComboBox<>(fonts);
        Integer[] sizes = {10, 14, 20, 28};
        cmb2 = new JComboBox<>(sizes);

        cb1 = new JCheckBox("BOLD");
        cb2 = new JCheckBox("ITALIC");

        t1 = new JTextField("MY NAME IS YASH I'M 20 YEARS OLD");

        // Adding the components
        add(l1);
        add(cmb1);
        add(l2);
        add(cmb2);
        add(l3);
        add(cb1);
        add(cb2);
        add(t1);

        // Set Bounds
        l1.setBounds(50, 50, 200, 30);
        cmb1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        cmb2.setBounds(50, 190, 200, 30);

        l3.setBounds(260, 50, 200, 30);
        cb1.setBounds(260, 100, 200, 30);
        cb2.setBounds(260, 140, 200, 30);

        t1.setBounds(50, 230, 400, 30);

        // Adding the listeners
        cmb1.addItemListener(this);
        cmb2.addItemListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
    }
    public void itemStateChanged(ItemEvent e) {
        String fn = cmb1.getSelectedItem().toString();      
        int fs = Integer.parseInt(cmb2.getSelectedItem().toString());

        if (cb1.isSelected() && cb2.isSelected()) {
            t1.setFont(new Font(fn, Font.BOLD|Font.ITALIC, fs));
        } else if (cb1.isSelected()) {
            t1.setFont(new Font(fn, Font.BOLD, fs));
        } else if (cb2.isSelected()) {
            t1.setFont(new Font(fn,Font.ITALIC, fs));
        }
        else{
            t1.setFont(new Font(fn, Font.PLAIN, fs));
        }
    }
}
class Assign3SetA1 {
    public static void main(String[] args) {
        new MyFrm();
    }
}