import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Ass5SetB2 extends JFrame implements ActionListener
{
    JPanel pnl1,pnl2;
    JButton b1,b2;

    Ass5SetB2()
    {
        setSize(600, 600);
        setTitle("Ass5SetB2");
        setLocation(300,100);

        pnl1 = new JPanel();
        pnl1.setBackground(Color.PINK);
        add(pnl1, "Center");

        b1 = new JButton("Start");
        b2 = new JButton("Close");

        pnl2 = new JPanel();
        pnl2.add(b1);        pnl2.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(pnl2, "South");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
        {
            Ball b = new Ball(pnl1);
            b.start();
        }
        if (e.getSource()==b2)
            System.exit(0);
    }

    public static void main(String args[])
    {
        new Ass5SetB2();
    }
}

class Ball extends Thread
{
    JPanel pnl;
    int x = 0,y = 0,flg=0;
    Color c;

    Ball(JPanel pnl)
    {
        this.pnl = pnl;

        int rc = randomInteger(0,255);
        int gc = randomInteger(0,255);
        int bc = randomInteger(0,255);
        c = new Color(rc,gc,bc);
        x = randomInteger(10,550);
    }

    public int randomInteger(int min, int max)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        return randomNum;
    }

    public void draw()
    {
        Graphics g = pnl.getGraphics();
        g.setColor(c);
        g.fillOval(x, y, 50,50);
    }

    void move()
    {
        Graphics g = pnl.getGraphics();
        g.setXORMode(pnl.getBackground());	// like repaint()
        g.setColor(c);
        g.fillOval(x, y, 50,50);

        if (flg==0)
        {
            y=y+10;
            if (y==480)
                flg=1;
        }
        else
        {
            y=y-10;
            if (y==0)
                flg=0;
        }

        g.fillOval(x, y, 50,50);
        g.dispose();
    }

    public void run()
    {
        try
        {
            draw();
            for (;;)
            {
                move();
                sleep(100);
            }
        }
        catch (InterruptedException e) {}
    }
}