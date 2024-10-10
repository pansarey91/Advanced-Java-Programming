import java.awt.*;
import java.awt.event.*;

class frm12 extends Frame implements ActionListener
{
	MenuBar mbr;
	Menu file,edit,help;
	MenuItem open1,close,copy,paste,about,exit1;
	
	frm12(String title)
	{
		super(title);
		setSize(400,400);
		
		mbr = new MenuBar();
		
		file = new Menu("File");
		edit = new Menu("Edit");
		help = new Menu("Help");
		
		exit1 = new MenuItem("Exit");
		about = new MenuItem("About");
		paste = new MenuItem("Paste");
		open1 = new MenuItem("Open");
		close = new MenuItem("Close");
		copy  = new MenuItem("Copy");
		
		
		file.add(open1);
		file.add(close );
		file.add(new MenuItem("-"));
		file.add(exit1);
		
		mbr.add(file );
		
		edit.add(copy );
		edit.add(paste );
		
		mbr.add(edit);
		//file.add(edit);
		
		help.add(about);
		mbr.add(help);
		
		setMenuBar(mbr);
		
		exit1.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
			{
                public void windowClosing(WindowEvent e)
                {
					System.exit(0);
				}  
			});
            setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
        System.exit(0);
	}
	
	public static void main(String args[])
	{
        new frm12("Menu frame");
	}
}