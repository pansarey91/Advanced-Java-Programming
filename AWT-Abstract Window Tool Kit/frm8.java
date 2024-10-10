import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;

class my6 extends Frame implements ItemListener
{
	// 1) Declaration
	Choice ch;
	TextField t1;
	List l1;
		
	my6()
	{
		setTitle("My Frame");		//super("My First Frame");
		setSize(500,500);
		setLocation(300,100);
		setLayout(new FlowLayout());	
		setFont(new Font("Arial",Font.BOLD,16));
		
		// 2) Memory Allocation
		ch = new Choice();
		t1 = new TextField(20);
		l1 = new List(10,true);
		
		ch.add("Aaa");
		ch.add("bbb");
		ch.add("ccc");
		ch.add("ddd");
				
		l1.add("Aaa");
		l1.add("bbb");
		l1.add("ccc");
		l1.add("ddd");
				
		// 3) Add Components
		add(ch);
		add(t1);
		add(l1);
		
		// 4) Add Listener to corresponding components
		ch.addItemListener(this);
		l1.addItemListener(this);
			
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}			
		});
		
		setVisible(true);
	}	
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==ch)
		{
			t1.setText(ch.getSelectedItem()+" Index = "+ch.getSelectedIndex());
		}
		else if(e.getSource()==l1)
		{
			String arr[] = l1.getSelectedItems();
			if(arr.length==1)
			{
				t1.setText(l1.getSelectedItem()+" Index = "+l1.getSelectedIndex());
			}
			else
			{
				t1.setText("");
		
				 t1.setText(Arrays.toString(arr));
				// for(int i=0;i<arr.length;i++)
					// t1.setText(t1.getText()+" "+arr[i]);
			}
		}
	}
}

class frm8
{
	public static void main(String args[])
	{
		new my6();
	}
}