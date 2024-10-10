import java.awt.*;
import java.awt.event.*;

class my extends Frame{
    my(){
        super("Frame");
        setSize(500,500);
        setLocation(500, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
public class frm3 {
    public static void main(String[] args) {
        new my();
    }
}
