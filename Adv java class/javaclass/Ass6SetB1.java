import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ass6SetB1 extends JFrame implements ActionListener
{
	// 1) Declaration
    JTextField t1;
	JPanel pnl;
	JButton b[];
	int i;
	Font f;
	double x,y,z;
	int flg=0;

    Ass6SetB1()
    {
		super("Calculator");	
		setSize(400,450);
		setLocation(200,100);
		setLayout(null);

		// 2) Memory Allocation
		f = new Font("Arial",Font.BOLD,20);
        t1 = new JTextField();
		pnl = new JPanel();

		add(t1);		t1.setFont(f);
		add(pnl);		pnl.setLayout(new GridLayout(4,3,10,10));
		pnl.setBackground(Color.YELLOW);
		
		t1.setBounds(50,40,270,30);	pnl.setBounds(50,80,200,200);
		b = new JButton[18];
		for(i=1;i<10;i++)
		{	b[i] = new JButton(""+i);
			pnl.add(b[i]);
		}
		
		b[0] = new JButton("0");		
		b[10] = new JButton(".");		b[11] = new JButton("=");	
		b[12] = new JButton("+");		b[13] = new JButton("-");	
		b[14] = new JButton("*");		b[15] = new JButton("/");
		b[16] = new JButton("Clear");	b[17] = new JButton("Exit");

		pnl.add(b[0]);	pnl.add(b[10]);	pnl.add(b[11]);
		add(b[12]);		add(b[13]);		add(b[14]);		add(b[15]);		
		add(b[16]);		add(b[17]);		

		b[12].setBounds(260,80,60,42);	b[13].setBounds(260,132,60,42);
		b[14].setBounds(260,184,60,42);	b[15].setBounds(260,236,60,42);
		b[16].setBounds(50,290,130,42);	b[17].setBounds(190,290,130,42);
		
		// 5) Add Font and Listeners
		for(i=0;i<18;i++)
		{	b[i].setFont(f);
			b[i].addActionListener(this);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {   
		if(e.getSource()==b[1]||e.getSource()==b[2]||e.getSource()==b[3]||e.getSource()==b[4]||e.getSource()==b[5]||e.getSource()==b[6]||e.getSource()==b[7]||e.getSource()==b[8]||e.getSource()==b[9])
		{
			if(t1.getText().length()==0)
				t1.setText(e.getActionCommand());
			else
				t1.setText(t1.getText()+e.getActionCommand());
		}
		
		if(e.getSource()==b[0])
			if(t1.getText().length()==0)
				t1.setText(e.getActionCommand());	
			else
				if(!t1.getText().equals("0"))
					t1.setText(t1.getText()+e.getActionCommand());

		if(e.getSource()==b[10])
			if(t1.getText().length()!=0)
				if(t1.getText().indexOf('.') == -1)
					t1.setText(t1.getText()+e.getActionCommand());	
				
		if(e.getSource()==b[12])
		{	
			x = Double.parseDouble(t1.getText());
			flg=1;	t1.setText("");
		}
		
		if(e.getSource()==b[13])
		{	
			x = Double.parseDouble(t1.getText());
			flg=2;	t1.setText("");
		}
		
		if(e.getSource()==b[14])
		{	
			x = Double.parseDouble(t1.getText());
			flg=3;	t1.setText("");
		}
		
		if(e.getSource()==b[15])
		{	
			x = Double.parseDouble(t1.getText());
			flg=4;	t1.setText("");
		}
		
		if(e.getSource()==b[11])
		{	
			y = Double.parseDouble(t1.getText());
			if(flg==1)		z=x+y;
			else if(flg==2)	z=x-y;
			else if(flg==3)	z=x*y;
			else if(flg==4)	z=x/y;
			t1.setText(""+z);
		}
		
		if(e.getSource()==b[16])
			t1.setText("");
		
		if(e.getSource()==b[17])
			System.exit(0);
    }

	public static void main(String args[])
	{	
		new Ass6SetB1();
	}
}