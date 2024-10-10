import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class FileRead extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1;
	JFileChooser jc;
	
    FileRead()
    {
		super("File Path");
		setSize(400,400);
		setLocation(150,150);
		setLayout(new FlowLayout());
		
		t1 = new JTextField(20);
		b1 = new JButton("Browse");
		jc = new JFileChooser();
		
		add(t1);
		add(b1);
		
		b1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	    
	}
	
	public void actionPerformed(ActionEvent e)
	{
		jc.setCurrentDirectory(new File("."));
		jc.showOpenDialog(this);
		File f1 = jc.getSelectedFile();
		t1.setText(f1.getPath());
	}
	
	public static void main(String args[])
	{
		new FileRead();
	}
}
