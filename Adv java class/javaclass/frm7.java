import java.awt.*;
import java.awt.event.*;

class Addition extends Frame implements ActionListener
{
    Label l1,l2,l3,l4;
    TextField t1,t2,t3;
    Button b1,b2,b3;
    
    Addition()
    {
        super("Calci");
        setSize(260,200);
        setLocation(200,200);
        
        setLayout(new FlowLayout());
        setFont(new Font("Arial",Font.BOLD,16));
        
        l1=new Label("First no.");
        l2=new Label("Second no.");
        l3=new Label("Answer");
        l4=new Label("");
        
        t1=new TextField(10);
        t2=new TextField(8);
        t3=new TextField(10);
        
        b1=new Button("Add");
        b2=new Button("Clear");
        b3=new Button("Exit");
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(l4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
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
        if(e.getSource()==b1)
        {
            int x=0,y=0;
            x=Integer.parseInt(t1.getText());
            y=Integer.parseInt(t2.getText());
            t3.setText(""+(x+y));
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        else
        System.exit(0);
    }
}

class frm7
{
    public static void main(String args[])
    {
        new Addition();
    }
}

