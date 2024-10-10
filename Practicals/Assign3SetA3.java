import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assign3SetA3 extends JFrame {
    private JLabel messageLabel;

    public Assign3SetA3() {
        // Set up the frame
        setTitle("Event Panel");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and configure the label
        messageLabel = new JLabel("Perform an action: mouse click, move, drag, or key press.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(messageLabel);

        // Add listeners
        addKeyListener(new KeyEventListener());
        addMouseListener(new MouseEventListener());
        addMouseMotionListener(new MouseMotionEventListener());

        // Make sure the panel is focused to capture key events
        setFocusable(true);
        requestFocusInWindow();
    }

    private class KeyEventListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            messageLabel.setText("Key Pressed: " + e.getKeyChar() + " (Code: " + e.getKeyCode() + ")");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Optionally handle key release events
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Optionally handle key typed events
        }
    }

    private class MouseEventListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            messageLabel.setText("Mouse Clicked: Button " + e.getButton());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            messageLabel.setText("Mouse Pressed: Button " + e.getButton());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Optionally handle mouse release events
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Optionally handle mouse entered events
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Optionally handle mouse exited events
        }
    }

    private class MouseMotionEventListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            messageLabel.setText("Mouse Dragged: X=" + e.getX() + ", Y=" + e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            messageLabel.setText("Mouse Moved: X=" + e.getX() + ", Y=" + e.getY());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Assign3SetA3 frame = new Assign3SetA3();
            frame.setVisible(true);
        });
    }
}
