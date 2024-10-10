
import javax.swing.*;
class complete_reference_2 {
 complete_reference_2() { 
 JFrame jfrm = new JFrame("A Simple Swing Application");
 jfrm.setSize(275, 100);
 jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JLabel jlab = new JLabel(" Swing means powerful GUIs.");
 jfrm.add(jlab);
 jfrm.setVisible(true);
 }
 public static void main(String args[]) {
 new complete_reference_2();
 }
}