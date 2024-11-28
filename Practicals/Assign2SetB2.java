import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class Assign2SetB2 extends JFrame implements ActionListener {
    JPanel pnl1, pnl2;
    JButton b1, b2;

    Assign2SetB2() {
        setSize(600, 600);
        setTitle("Bouncing Ball");
        setLocation(300, 100);

        pnl1 = new JPanel();
        pnl1.setBackground(Color.PINK);
        add(pnl1, BorderLayout.CENTER);

        b1 = new JButton("Start");
        b2 = new JButton("Close");

        pnl2 = new JPanel();
        pnl2.add(b1);
        pnl2.add(b2);
        add(pnl2, BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Ball b = new Ball(pnl1);
            b.start();
        } else if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Assign2SetB2();
    }
}

class Ball extends Thread {
    JPanel pnl;
    int x, y = 0, direction = 1; // direction: 1 for down, -1 for up
    Color color;

    Ball(JPanel pnl) {
        this.pnl = pnl;
        this.color = randomColor();
        this.x = randomInteger(10, pnl.getWidth() - 60);
    }

    private Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    private int randomInteger(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private void moveBall() {
        Graphics g = pnl.getGraphics();
        g.setColor(color);
        g.setXORMode(pnl.getBackground()); // Used to clear the previous ball position

        // Draw and erase the ball
        g.fillOval(x, y, 50, 50);

        // Update position
        y += direction * 10;
        if (y >= pnl.getHeight() - 60) direction = -1; // Bounce up
        if (y <= 0) direction = 1; // Bounce down

        g.fillOval(x, y, 50, 50);
        g.dispose();
    }

    public void run() {
        while (true) {
            try {
                moveBall();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
