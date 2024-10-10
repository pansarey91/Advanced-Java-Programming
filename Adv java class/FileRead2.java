import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class FileRead2 extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1;
    JFileChooser jc;
    TextArea t2;
	
    FileRead2()
    {
        super("File Path");
        setSize(600,400);
        setLocation(150,150);
        setLayout(null);
		
        t1 = new JTextField();
        b1 = new JButton("Browse");
        jc = new JFileChooser();
        t2 = new TextArea();
		
        add(t1);
        add(b1);
        add(t2);
		
        t1.setBounds(50,50,200,20);
        b1.setBounds(260,50,100,20);
		t2.setBounds(50,80,500,200);
		
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
		
		try
		{
			// read file
			int i;
			String temp="";
			FileInputStream fin = new FileInputStream(f1.getPath());
			do
			{
				i = fin.read();
				
				if (i != -1)
				temp=temp+((char) i);
				
			} while (i != -1);
			
			fin.close();
			t2.setText(temp);
		}
		catch(Exception ex){}
	}
	
	public static void main(String args[])
	{
		new FileRead2();
	}
}

