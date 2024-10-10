import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample extends JFrame implements KeyListener {
    
    private JTextArea textArea;

    public KeyListenerExample() {
        textArea = new JTextArea();
        textArea.addKeyListener(this);

        add(textArea);
        setSize(400, 400);
        setTitle("KeyListener Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        textArea.append("Key Pressed: " + keyText + "\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        textArea.append("Key Released: " + keyText + "\n");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        textArea.append("Key Typed: " + keyChar + "\n");
    }

    public static void main(String[] args) {
        new KeyListenerExample();
    }
}