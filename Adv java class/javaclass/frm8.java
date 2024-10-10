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
        setSize(400,400);
        setLocation(200,200);
        
        setLayout(null);
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
        
        l1.setBounds(100,100,80,20);
        t1.setBounds(200,100,80,20);
        l2.setBounds(100,140,80,20);
        t2.setBounds(200,140,80,20);
        l3.setBounds(100,180,80,20);
        t3.setBounds(200,180,80,20);
        b1.setBounds(100,220,50,20);
        b2.setBounds(165,220,50,20);
        b3.setBounds(230,220,50,20);
        l4.setBounds(100,260,180,20);
        
        
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
            try
            {
                if(t1.getText().length()==0 ||t2.getText().length()==0 )
                {
                    l4.setText("Two numbers required");
                }
                else
                {
                    int x=0,y=0;
                    x=Integer.parseInt(t1.getText());
                    y=Integer.parseInt(t2.getText());
                    t3.setText(""+(x+y));
                    l4.setText("");
                }
            }
            catch(NumberFormatException ex)
            {
                l4.setText("Enter only digit");
            }
            catch(Exception ex)
            {
                l4.setText(ex.toString());
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            l4.setText("");
            t1.requestFocus();
        }
        else
        System.exit(0);
    }
}

class frm8
{
    public static void main(String args[])
    {
        new Addition();
    }
}
