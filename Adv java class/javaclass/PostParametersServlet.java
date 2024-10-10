import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import java.util.*;

public class PostParametersServlet extends GenericServlet
{
 public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
 {
  // Get print writer.
  PrintWriter pw = response.getWriter();

  // Get enumeration of parameter names.
  Enumeration e = request.getParameterNames();

  // Display parameter names and values.
  while(e.hasMoreElements())
  {
   String pname = (String)e.nextElement();
   pw.print("Parameter Name = "+pname + " => ");

   String pvalue = request.getParameter(pname);
   pw.println("Parameter Value = "+pvalue + "<BR>");
  }
  pw.close();
 }
}
