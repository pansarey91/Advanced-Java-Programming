import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
 
public class ColorGetServlet extends HttpServlet 
{ 
  public void doGet(HttpServletRequest request,  
    HttpServletResponse response)  
  throws ServletException, IOException { 
 
    String clr = request.getParameter("color"); 
    response.setContentType("text/html"); 
    PrintWriter pw = response.getWriter(); 
    pw.println("<B>The selected color is:  "); 

    if (clr == null) {
      pw.println("no color selected");
    } else {
      pw.println(clr);
    }
    pw.println(clr); 
    pw.close(); 
  } 
} 