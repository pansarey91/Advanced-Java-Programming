import java.awt.*;
import java.awt.event.*;

class myframe extends Frame implements WindowListener
{
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(800,500);
		setLocation(200,200);
		
		setVisible(true);
		addWindowListener(this);		// IMP
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
	public void windowClosed(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
}

class frm2
{
	public static void main(String args[])
	{
		new myframe();
	}
}