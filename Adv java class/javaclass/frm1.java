import java.awt.*;

class myframe extends Frame
{
	myframe()
	{
		super("My First Frame");	// setTitle("My First Frame");
		setSize(800,500);
		setLocation(200,200);
		
		setVisible(true);
	}
}

class frm1
{
	public static void main(String args[])
	{
		new myframe();
	}
}