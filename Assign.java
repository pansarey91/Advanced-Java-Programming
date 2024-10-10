// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import javax.swing.event.*;

class myframe extends JFrame{
	
		JLabel l1,l2;
		JTextArea t1;
		
		
		myframe(){
			setTitle("A3A3");
			setSize(400,400);
			setLocation(500,400);
			setLayout(null);
			
			l1=new JLabel();
			l2=new JLabel();
			t1=new JTextArea();
			add(l1);
			add(l2);
			add(t1);
			l1.setBounds(40,40,250,30);
			l2.setBounds(40,90,250,30);
			t1.setBounds(40,130,500,300);
			
			

		// adding MouseMotionListener
			addMouseMotionListener(new MouseMotionAdapter()
			{
				public void mouseMoved(MouseEvent m)
				{
					l1.setText("mouse moved:X ="+m.getX()+" Y ="+m.getY());
				}
				public void mouseDragged(MouseEvent m)
				{
					l1.setText("mouse Dragged:X ="+m.getX()+" Y ="+m.getY());
				}
			});
			
		// adding mouseListener	
			addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent m1)
				{
					l2.setText("mouse clicked:X = "+m1.getX()+" Y = "+m1.getY());
				}
				public void mousePressed(MouseEvent m1)
				{
					l2.setText("mouse pressed:X = "+m1.getX()+" Y = "+m1.getY());
				}
				public void mouseReleased(MouseEvent m1)
				{
					l2.setText("mouse Released:X = "+m1.getX()+" Y = "+m1.getY());
				}
				public void mouseEntered(MouseEvent m1)
				{
					l2.setText("mouse Entered:X = "+m1.getX()+" Y = "+m1.getY());
				}
				public void mouseExited(MouseEvent m1)
				{
					l2.setText("mouse Exited:X = "+m1.getX()+" Y = "+m1.getY());
				}
			}
			);
		// adding KeyListener
			t1.addKeyListener(new KeyAdapter()
			{
				 public void keyPressed(KeyEvent e) 
				{
					int keyCode = e.getKeyCode();
					String keyText = KeyEvent.getKeyText(keyCode);
					t1.append("Key Pressed: " + keyText + "\n");
				}
				 public void keyReleased(KeyEvent e)
				{
					int keyCode = e.getKeyCode();
					String keyText = KeyEvent.getKeyText(keyCode);
					t1.append("Key Released: " + keyText + "\n");
				}
				 public void keyTyped(KeyEvent e) 
				{
					char keyChar = e.getKeyChar();
					t1.append("Key Typed: " + keyChar + "\n");
				}

			}
			);			
			setDefaultCloseOperation(3);
			setVisible(true);
	}
}

class Assign{
	public static void main(String args[])
	{
		new myframe();
	}
}