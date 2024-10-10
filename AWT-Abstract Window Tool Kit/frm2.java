import java.awt.*;
import java.awt.event.*;

class my2 extends Frame implements WindowListener
{
    my2()
    {
        setVisible(true);
        setTitle("My Frame");
        setSize(500,500);
        setLayout(new FlowLayout());
        addWindowListener(this);
    }
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}

}
public class frm2 {
    public static void main(String args[]) 
    {
        new my2();
    }
}
