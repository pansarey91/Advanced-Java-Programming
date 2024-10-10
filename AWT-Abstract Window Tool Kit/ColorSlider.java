import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

class ColorSlider extends JFrame implements ChangeListener
{
	JSlider red, blue, green;
	JPanel sliderPanel, colorPanel;
	JLabel rValue, gValue, bValue;
	
	ColorSlider()
	{
		super("Color Slider");
		setLayout(new BorderLayout());
		setSize(400,400);
		setLocation(200,300);
		
		// JSlider(min val, max value,initial value)
		
		red = new JSlider(0,255,0);
		green = new JSlider(0,255,100);
		blue = new JSlider(0,255,200);
		
		red.addChangeListener(this);
		green.addChangeListener(this);
		blue.addChangeListener(this);
		
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(3,3,1,1));
		
		sliderPanel.add(new JLabel("Red", JLabel.RIGHT));
		sliderPanel.add(red);
		sliderPanel.add(rValue = new JLabel("0"));
		
		sliderPanel.add(new JLabel("Green", JLabel.RIGHT));
		sliderPanel.add(green);
		sliderPanel.add(gValue = new JLabel("0"));
		
		sliderPanel.add(new JLabel("Blue", JLabel.RIGHT));
		sliderPanel.add(blue);
		sliderPanel.add(bValue = new JLabel("0"));
		
		colorPanel = new JPanel();
		colorPanel.setSize(300,300);
		
		add(colorPanel , BorderLayout.CENTER);
		add(sliderPanel, BorderLayout.SOUTH);

		add(new JButton("TYBCS"), BorderLayout.EAST);
		add(new JButton("SYBCS"), BorderLayout.WEST);
		
		add(new JButton("TCCOLLEGE"), BorderLayout.NORTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void stateChanged(ChangeEvent ce)
	{
		int r = red.getValue();
		rValue.setText(Integer.toString(r));
		
		int g = green.getValue();
		gValue.setText(Integer.toString(g));
		
		int b = blue.getValue();
		bValue.setText(Integer.toString(b));
		
		Color c = new Color(r,g,b);
		colorPanel.setBackground(c);
	}
	public static void main(String[] args)
	{
		new ColorSlider();
	}
}
