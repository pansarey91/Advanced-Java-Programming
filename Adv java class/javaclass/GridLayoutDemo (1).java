// Demonstrate GridLayout
import java.awt.*;
class GridLayoutDemo extends Frame
{
    GridLayoutDemo()
    {
        setSize(300,300);
        setLayout(new GridLayout(4,5,10,10));

        setFont(new Font("SansSerif", Font.BOLD, 24));

        for (int i = 0; i < 20; i++)
                add(new Button(""+(i+1)));

		setVisible(true);
    }

	public static void main(String args[])
	{
		new GridLayoutDemo();
	}
}