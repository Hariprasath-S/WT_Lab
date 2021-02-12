import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
public class ServletDemo extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws IOException, ServletException
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<head>");
			out.println("<title>Srevlet Demo</title>"); 
			out.println("</head>"); 
			out.println("<body bgcolor=#C39BD3>");
			out.println("<h1>The servlet is running...</h1>");
			out.println("</body>");
			out.println("</html>");   
			
		}
}
