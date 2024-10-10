import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

class FileRead3 extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1;
    JFileChooser jc;
    JLabel lbl;
    
    FileRead3()
    {
        super("File Path");
        setSize(500,500);
        setLocation(150,150);
        setLayout(null);
        
        t1 = new JTextField(20);
        b1 = new JButton("Browse");
        jc = new JFileChooser();        
        lbl = new JLabel();
                
        t1.setBounds(50,10,300,20);
        b1.setBounds(360,10,100,20);
        lbl.setBounds(50,40,400,400);
        
        add(t1);
        add(b1);
        add(lbl);
        
        b1.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        jc.setCurrentDirectory(new File("."));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Image Files", "jpg", "png", "gif", "bmp", "jpeg");
        jc.setFileFilter(filter);
        
        int result = jc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File f1 = jc.getSelectedFile();
            t1.setText(f1.getPath());

            try
            {
                BufferedImage img = ImageIO.read(f1);                
                Image resizedImage = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(resizedImage));
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String args[])
    {
        new FileRead3();
    }
}
