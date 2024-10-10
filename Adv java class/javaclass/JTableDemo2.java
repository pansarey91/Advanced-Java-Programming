import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;  

public class JTableDemo2 extends JFrame
{
    JTable table;
    JTextField t1;
    
    JTableDemo2()
    {
        super("Table Demo");
        setSize(300,200);
        setLocation(250,250);
        
        t1 = new JTextField(20);
        
        String colHeads[] = { "Name", "Phone", "Fax" };
        
        String data[][] =
        {
            { "Abc", "1234", "2345" },
            { "Def", "3457", "4567" },
            { "ghi", "5685", "5678" },
            { "Jkl", "2345", "3456" },
            { "Mno", "4656", "3456" },
            { "Pqr", "5787", "5678" },
            { "Stu", "4678", "3456" },
            { "Vwx", "6789", "5678" },
            { "Xyz", "1343", "4567" }
        };
        
        table = new JTable(data, colHeads);
            
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);
        add(jsp,BorderLayout.CENTER);
        add(t1,BorderLayout.SOUTH);

        ListSelectionModel select= table.getSelectionModel();          
        select.addListSelectionListener(new ListSelectionListener() 
        {  
            public void valueChanged(ListSelectionEvent e) 
            {  
                String Data = null;  
                int[] row = table.getSelectedRows();  
                int[] columns = table.getSelectedColumns();  
                for (int i = 0; i < row.length; i++) 
                {  
                    for (int j = 0; j < columns.length; j++) 
                    {  
                        Data = (String) table.getValueAt(row[i], columns[j]);  
                    } 
                }  
                    
                t1.setText("Selected = " + Data);    
            }       
        });  


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new JTableDemo2();
    }
}
