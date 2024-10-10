//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Assign3 extends JFrame implements ItemListener {
    // Declaration
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    JCheckBox cb1, cb2, cb3;
    JRadioButton rb1, rb2, rb3;

    Assign3() {
        setVisible(true);
        setTitle("Assign3SetA2");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Memory allocation
        l1 = new JLabel("Your Name");
        l2 = new JLabel("Your Class");
        l3 = new JLabel("Your Hobbies");
        l4 = new JLabel("Output");

        t1 = new JTextField();
        t2 = new JTextField();

        cb1 = new JCheckBox("Music");
        cb2 = new JCheckBox("Dance");
        cb3 = new JCheckBox("Singing");

        rb1 = new JRadioButton("FY");
        rb2 = new JRadioButton("SY");
        rb3 = new JRadioButton("TY");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        // Adding the components
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(cb1);
        add(cb2);
        add(cb3);
        add(rb1);
        add(rb2);
        add(rb3);

        // Set bounds
        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(130, 50, 110, 30);

        l2.setBounds(50, 90, 100, 30);
        rb1.setBounds(50, 130, 50, 30);
        rb2.setBounds(50, 170, 50, 30);
        rb3.setBounds(50, 210, 50, 30);

        l3.setBounds(130, 90, 110, 30);
        cb1.setBounds(130, 130, 110, 30);
        cb2.setBounds(130, 170, 110, 30);
        cb3.setBounds(130, 210, 110, 30);

        l4.setBounds(50, 250, 100, 30);
        t2.setBounds(130, 250, 300, 30);

        // Add the Listeners
        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        StringBuilder output = new StringBuilder();

        // Add name
        String name = t1.getText();
        output.append("Name=").append(name);

        // Add class
        String classText = "";
        if (rb1.isSelected()) {
            classText = "FY";
        } else if (rb2.isSelected()) {
            classText = "SY";
        } else if (rb3.isSelected()) {
            classText = "TY";
        }
        output.append(", Class=").append(classText.isEmpty() ? "___________" : classText);

        // Add hobbies
        String hobbies = "";
        if (cb1.isSelected()) {
            hobbies += "Music";
        }
        if (cb2.isSelected()) {
            if (!hobbies.isEmpty()) hobbies += ", ";
            hobbies += "Dance";
        }
        if (cb3.isSelected()) {
            if (!hobbies.isEmpty()) hobbies += ", ";
            hobbies += "Singing";
        }
        output.append(", Hobbies=").append(hobbies.isEmpty() ? "__________" : hobbies);

        // Set combined text to the output text field
        t2.setText(output.toString());
    }
}

public class Assign3SetA2 {
    public static void main(String args[]) {
        new Assign3();
    }
}
