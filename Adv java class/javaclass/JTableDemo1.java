import javax.swing.*;

class JTableDemo1 extends JFrame
{
  JTableDemo1()
  {
      super("Table Demo");
      setSize(300,200);
      setLocation(250,250);

    String colHeads[] = { "Name", "Phone", "Fax" };

    String data[][] =
    {
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" },
            { "Abcd", "1234", "5678" }
    };

    JTable table = new JTable(data, colHeads);
    table.setEnabled(false);

    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane jsp = new JScrollPane(table, v, h);
    add(jsp);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

    public static void main(String args[])
    {
        new JTableDemo1();
    }
}
