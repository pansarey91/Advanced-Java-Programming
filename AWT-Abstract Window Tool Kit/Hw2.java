import java.awt.*;
import java.awt.event.*;
class Frame2 extends Frame implements ActionListener{
    // 1) Declaration
    Label l1,l2,l3;
    TextField t1,t2,t3;
    Button b1,b2,b3,b4,b5,b6;
    Frame2(){
        super("Frame");
        setSize(500,500);
        setLocation(500,200);
        setVisible(true);
        setLayout(null);

        // 2) memeory allocation
        l1 = new Label("Enter The First Number  :");
        l2 = new Label("Enter  Second Number :");
        l3 = new Label("Result :");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();

        b1 = new Button("Add");
        b2 = new Button("clear");
        b3 = new Button("exit");
        b4 = new Button("Sub");
        b5 = new Button("Mul");
        b6 = new Button("Div");

        // 3) add the components

        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);    
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);        

        // 4) set Bounds

        l1.setBounds(50,50,150,30);
        t1.setBounds(220, 50, 150, 30);

        l2.setBounds(50, 100, 150, 30);
        t2.setBounds(220, 100, 150, 30);

        l3.setBounds(50, 150, 150, 30);
        t3.setBounds(220, 150, 150, 30);

        b1.setBounds(50, 200, 75, 30);
        b4.setBounds(135, 200, 75, 30);
        b5.setBounds(215, 200, 75, 30);
        b6.setBounds(295, 200, 75, 30);

        b2.setBounds(50, 250, 150, 30);
        b3.setBounds(220, 250, 150, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int c = a+b;
            t3.setText(Integer.toString(c));
        }
        if(e.getSource() == b4)
        {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int c = a-b;
            t3.setText(Integer.toString(c));
        }
        if(e.getSource() == b5)
        {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int c = a*b;
            t3.setText(Integer.toString(c));
        }
        if(e.getSource() == b6)
        {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            float c = (float)a/b;
            t3.setText(Float.toString(c));
        }
        if(e.getSource() == b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        if(e.getSource() == b3)
        {
            System.exit(0);
        }
    }
}
class Hw2{
    public static void main(String[] args) {
        new Frame2();
    }
}