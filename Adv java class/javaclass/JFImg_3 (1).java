import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class JFImg_3 extends JFrame implements ActionListener
{
    JButton b1,b2,b3;

    JFImg_3()
    {
        super("ImageIcon Demo");	setSize(500,150);
        setLocation(150,150);		setLayout(new FlowLayout());

        b1 = new JButton(new ImageIcon("b1.png"));	
		b1.setText("SAVE");
        
		b2 = new JButton(new ImageIcon("b2.png"));	
		b2.setText("UPDT");
		
        b3 = new JButton(new ImageIcon("b3.png"));	
		b3.setText("DELT");

        add(b1);	add(b2);	add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
      JOptionPane.showMessageDialog(null,e.getActionCommand());
    }

    public static void main(String args[])
    {
        new JFImg_3();
    }
}
