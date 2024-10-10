import java.awt.*;
class myframe extends Frame
{
    myframe()
    {
        setVisible(true);
        setTitle("My Frame");
        setSize(500,500);
        setLayout(new FlowLayout());    
        
    }
}
class frm1{
    public static void main(String []args)
    {
        new myframe();
    }
}