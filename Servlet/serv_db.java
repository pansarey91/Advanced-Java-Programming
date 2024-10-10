import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class serv_db extends HttpServlet
{
    Connection con;
	Statement stmt;
	ResultSet rs;
	
    public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HTML><HEAD><TITLE>Database Connectivity</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<P align=center><BIG>Data From Database</BIG></P>");
        out.println("<TABLE align=center border=1>");
        out.println("<TR>");
        out.println("<TH>Roll Number</TH><TH>Name</TH><TH>Age</TH></TR>");

        try
        {
            con = DriverManager.getConnection("jdbc:mysql:///ras","root", "");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from mytable");

            while (rs.next())
            {
                out.println("<TR>");
                out.println("<TD>" + rs.getString(1) + "</TD>");
                out.println("<TD>" + rs.getString(2) + "</TD>");
                out.println("<TD>" + rs.getString(3) + "</TD>");
                out.println("</TR>");
            }
            rs.close();		stmt.close();	con.close();
        }
        catch (Exception e)
        {  out.println(e.getMessage());
        }
        out.println("</TABLE></BODY></HTML>");
    }
}