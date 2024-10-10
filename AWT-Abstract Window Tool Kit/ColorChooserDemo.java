import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class ColorChooserDemo extends JFrame implements ChangeListener
{
    JColorChooser cc;
    JLabel l1;
	
    ColorChooserDemo()
    {
        super("Color Chooser Demo");
        setSize(550,500);
        setLocation(200,200);
        setLayout(null);
		
        l1 = new JLabel("Welcome to the Tutorial Zone!",JLabel.CENTER);
        l1.setForeground(Color.yellow);
        l1.setBackground(Color.black);
        l1.setOpaque(true);
		/*
			javax.swing.JComponent
			public void setOpaque(boolean isOpaque)
			If true the component paints every pixel within its bounds.
			Otherwise, the component may not paint some or all of its pixels,
			allowing the underlying pixels to show through.
			The default value of this property is false for JComponent.
			However, the default value for this property on most standard JComponent subclasses
			(such as JButton and JTree) is look-and-feel dependent.
		*/
		
        l1.setFont(new Font("SansSerif", Font.BOLD, 30));
		l1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
		
        cc = new JColorChooser(l1.getForeground());
        cc.getSelectionModel().addChangeListener(this);
        cc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
		
        add(l1);
        add(cc);
		
        l1.setBounds(15,15,500,80);
        cc.setBounds(15,105,500,350);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
    public void stateChanged(ChangeEvent e)
    {
        Color clr = cc.getColor();
        l1.setForeground(clr);
	}
	
    public static void main(String[] args)
    {
		new ColorChooserDemo() ;
	}
}