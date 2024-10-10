import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Page1Servlet extends HttpServlet {

  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
{
    int sum=0;
    String[] values=req.getParameterValues("item");
     if(values !=null)
     {
        for(int i=0;i<values.length;i++)
        	sum=sum+Integer.parseInt(values[i]);
     }
     HttpSession hs = req.getSession(true);
     hs.setAttribute("page1", sum);
     res.sendRedirect("Page2.html");
}
}
