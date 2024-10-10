import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 

public class PageCounter extends HttpServlet
{
    public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
		int i,cnt=0;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		
		Cookie cookies[] = req.getCookies();
		
		if(cookies != null)
		{
			for(i = 0 ; i < cookies.length; i++)
				if(cookies[i].getName().equals("counter"))
				{
					cnt = Integer.parseInt(cookies[i].getValue());
					cnt++;
					out.println("Number of Time Visited =  "+cnt); 		
				}
		}
		else
		{
			out.println("Welcome User !!!");
			cnt=1;
		}
		
		Cookie c = new Cookie("counter",Integer.toString(cnt));
 		res.addCookie(c);
		out.println("</body> </html>");
    }
}