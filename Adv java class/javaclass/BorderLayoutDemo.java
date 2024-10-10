// Demonstrate BorderLayout.
import java.awt.*;
class BorderLayoutDemo extends Frame
{   
	BorderLayoutDemo()
    {
        setSize(400,400);
        setLayout(new BorderLayout());

		add(new Button("This is across the top."),BorderLayout.NORTH);
		add(new Label("The footer message"),BorderLayout.SOUTH);
        add(new Button("Right"), BorderLayout.EAST);
        add(new Button("Left"), BorderLayout.WEST);
        String msg = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \n " +
                     "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb \n" +
                     "ccccccccccccccccccccccccccccccc \n " +
                     "dddddddddddddddddddddddddddddd";
        add(new TextArea(msg), BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String args[])
    {   
		new BorderLayoutDemo();
    }
}