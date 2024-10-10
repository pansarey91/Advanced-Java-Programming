import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays;
import java.io.*;

public class Assign3SetB2 extends JFrame implements ItemListener, ActionListener {
    JMenuBar mb;
    JMenu fm, cm, om, sm;
    JMenuItem lmi, smi, emi, sumi, ami, mmi, mini, medi, srchmi;
    JRadioButtonMenuItem b1, b2;
    JLabel l1;
    JTextArea t1;
    int[] a = new int[50];
    String data = "";
    Random r = new Random();

    public Assign3SetB2() {
        setTitle("Integer Set Operations");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        mb = new JMenuBar();
        fm = new JMenu("File");
        cm = new JMenu("Compute");
        om = new JMenu("Operations");
        sm = new JMenu("Sort");

        lmi = new JMenuItem("Load");
        smi = new JMenuItem("Save");
        emi = new JMenuItem("Exit");
        sumi = new JMenuItem("Sum");
        ami = new JMenuItem("Average");
        mmi = new JMenuItem("Max");
        mini = new JMenuItem("Min");
        medi = new JMenuItem("Median");
        srchmi = new JMenuItem("Search");

        b1 = new JRadioButtonMenuItem("Ascending");
        b2 = new JRadioButtonMenuItem("Descending");
        ButtonGroup bg = new ButtonGroup();

        l1 = new JLabel("Numbers");
        t1 = new JTextArea();

        // Set component bounds
        l1.setBounds(50, 50, 200, 20);
        t1.setBounds(50, 100, 200, 200);

        // Add to menus
        mb.add(fm);
        fm.add(lmi);
        fm.add(smi);
        fm.add(emi);

        mb.add(cm);
        cm.add(sumi);
        cm.add(ami);
        cm.add(mmi);
        cm.add(mini);
        cm.add(medi);

        mb.add(om);
        om.add(srchmi);
        om.add(sm);

        sm.add(b1);
        sm.add(b2);
        bg.add(b1);
        bg.add(b2);
        // Add components
        setJMenuBar(mb);
        add(l1);
        add(t1);
        // Add listeners
        lmi.addActionListener(this);
        smi.addActionListener(this);
        emi.addActionListener(this);
        sumi.addActionListener(this);
        ami.addActionListener(this);
        mmi.addActionListener(this);
        mini.addActionListener(this);
        medi.addActionListener(this);
        srchmi.addActionListener(this);
        b1.addItemListener(this);
        b2.addItemListener(this);
    }
    public void itemStateChanged(ItemEvent e) {
        Arrays.sort(a);
        if (b2.isSelected()) {
            for (int i = 0; i < a.length / 2; i++) {
                int temp = a[i];
                a[i] = a[a.length - 1 - i];
                a[a.length - 1 - i] = temp;
            }
        }
        updateTextArea();
    }
    private void updateTextArea() {
        data = "";
        for (int i = 0; i < a.length; i++) {
            data += a[i] + ((i + 1) % 10 == 0 ? "\n" : " ");
        }
        t1.setText(data);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lmi) {
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt(90) + 10;
            }
            updateTextArea();
        } else if (e.getSource() == smi) {
            try (PrintStream p = new PrintStream(new FileOutputStream("Number.txt"))) {
                p.println(data);
                JOptionPane.showMessageDialog(this, "File Saved Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == emi) {
            System.exit(0);
        } else if (e.getSource() == sumi) {
            JOptionPane.showMessageDialog(this, "Sum = " + Arrays.stream(a).sum());
        } else if (e.getSource() == ami) {
            JOptionPane.showMessageDialog(this, "Avg = " + Arrays.stream(a).average().orElse(0.0));
        } else if (e.getSource() == mmi) {
            JOptionPane.showMessageDialog(this, "Max = " + Arrays.stream(a).max().orElse(0));
        } else if (e.getSource() == mini) {
            JOptionPane.showMessageDialog(this, "Min = " + Arrays.stream(a).min().orElse(0));
        } else if (e.getSource() == medi) {
            Arrays.sort(a);
            double median = (a.length % 2 == 0) ? (a[a.length / 2 - 1] + a[a.length / 2]) / 2.0 : a[a.length / 2];
            JOptionPane.showMessageDialog(this, "Median = " + median);
        } else if (e.getSource() == srchmi) {
            int srch = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the No. To Search:"));
            int idx = Arrays.binarySearch(a, srch);
            JOptionPane.showMessageDialog(this, (idx < 0) ? "Number Not Found" : "Number Found at " + idx + " position");
        }
    }
    public static void main(String[] args) {
        Assign3SetB2 frame = new Assign3SetB2();
        frame.setVisible(true);
    }
}
