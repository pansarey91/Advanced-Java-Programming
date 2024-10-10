import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

class JImgCombo extends JFrame implements ItemListener
{
 JLabel jl; 
 JComboBox jc;

 JImgCombo()
 {
    super("JComboBox Demo");
    setSize(850,700);
    setLayout(null);

    jc = new JComboBox(); 

    jc.addItem("Water lilies");
    jc.addItem("Sunset"); 
    jc.addItem("Blue hills"); 
    jc.addItem("Winter"); 

    jc.addItemListener(this);
    add(jc);
    jc.setBounds(10,10,100,20);

    jl = new JLabel(new ImageIcon("Img0.jpg"));
    add(jl);
    jl.setBounds(10,40,800,600);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  } 
 
  public void itemStateChanged(ItemEvent ie)
  {
   if(jc.getSelectedIndex()==0)
     jl.setIcon(new ImageIcon("Img0.jpg"));

   else if(jc.getSelectedIndex()==1)
     jl.setIcon(new ImageIcon("Img1.jpg"));

   else if(jc.getSelectedIndex()==2)
     jl.setIcon(new ImageIcon("Img2.jpg"));

   else if(jc.getSelectedIndex()==3)
     jl.setIcon(new ImageIcon("Img3.jpg")); 
  }

  public static void main(String args[])
  {
   new JImgCombo();
  }
}
