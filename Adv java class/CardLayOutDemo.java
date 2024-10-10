// Demonstrate CardLayout.
import java.awt.*;
import java.awt.event.*;
class CardLayOutDemo extends Frame implements ActionListener
{  
	Checkbox Win98, winNT, solaris, mac;
    Panel pnl;
    CardLayout cardLO;
    Button Win, Other;

    CardLayOutDemo()
    {
        setSize(200,200);
		setLayout(new FlowLayout());

        Win = new Button("Windows");
        Other = new Button("Other");
        add(Win);       add(Other);

        cardLO = new CardLayout();
        pnl = new Panel();
        pnl.setLayout(cardLO);

        Win98 = new Checkbox("Windows 98");
        winNT = new Checkbox("Windows NT");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("MacOS");

        Panel p1 = new Panel();
        p1.setBackground(Color.PINK);
        p1.add(Win98);   p1.add(winNT);

        Panel p2 = new Panel();
        p2.setBackground(Color.YELLOW);
        p2.add(solaris); p2.add(mac);

        pnl.add(p1, "Windows");
        pnl.add(p2, "Other");

        add(pnl);

        Win.addActionListener(this);
        Other.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Win)
            cardLO.show(pnl, "Windows");
        else
            cardLO.show(pnl, "Other");
    }

    public static void main(String args[])
    {
        new CardLayOutDemo();
    }
}