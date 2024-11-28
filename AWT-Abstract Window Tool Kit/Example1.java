import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Example1 extends JFrame implements ActionListener {
    JMenuBar m;
    JMenu f,e;
    JMenuItem i1,i2,i3,i4,i5,i6;
    JTextField t;

    Example1(){
        super("Example 1");
        setSize(400,400);
        setLocation(400, 300);
        setLayout(null);
        setDefaultCloseOperation(3);

        m = new JMenuBar();
        f = new JMenu("File");
        e = new JMenu("Edit");
        i1 = new JMenuItem("New");
        i2 = new JMenuItem("Open");
        i3 = new JMenuItem("Exit");
        i4 = new JMenuItem("Cut");
        i5 = new JMenuItem("Copy");
        i6 = new JMenuItem("Paste");
        t = new JTextField();

        f.add(i1); f.add(i2); f.add(i3);
        e.add(i4); e.add(i5); e.add(i6);

        m.add(f); m.add(e);


        add(m);
        add(t);

        m.setBounds(50,50,100,20);
        t.setBounds(100,150,100,20);

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        t.setText(e.getActionCommand());
        
        if ("Exit".equals(e.getActionCommand())) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Example1();
    }
}
