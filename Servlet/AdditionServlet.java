import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
public class AdditionServlet extends HttpServlet {    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();        
        String a = request.getParameter("num1");
        String b = request.getParameter("num2");
        int c = Integer.parseInt(a) + Integer.parseInt(b);
        out.println("<h1>The sum is " + c + "</h1>");        
    }
}