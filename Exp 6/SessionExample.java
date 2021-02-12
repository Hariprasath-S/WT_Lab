import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionExample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Session Example</title>");
		out.println("<style>"); 
		// out.println("body{background: linear-gradient(to right, #8e2de2, #4a00e0);font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;}div { padding: 16px;width: 35vw;margin: 100px auto;text-align: center;box-shadow: 0px 10px 30px #210063;color: white;}h2{border-bottom: 1px solid;padding: 5px;}");
        out.println("</style>"); 
		out.println("</head>");	
        out.println("<body>");		
        HttpSession session = request.getSession();
		Integer i=(Integer)session.getAttribute("count");
		String dataName = request.getParameter("UName");
		out.println("<div>");
		if(session.isNew()){
			i=1;
			
				if (dataName != null && dataName.length() > 0) {
					session.setAttribute("A",dataName);
					out.println("<h2> Hey " + dataName + " !</h2>");
					out.println("<h3> This is your first visit.</h3>");
				}
				else{
					out.println("<h3>This is your first visit.</h3>");
				}
				session.setAttribute("count",i);
        }
		else{
				 i++;
			     if(session.getAttribute("A")!=null){
					out.println("<h2> Hey "+dataName + " !</h2>");
					out.println("<h3> You have visited "+i+" times.</h3>");
				}
				 else{
					 out.println("<h3>You have visited "+i+" times.</h3>");
				     }
				 session.setAttribute("count",i);
			}
			Date created = new Date(session.getCreationTime());
			Date accessed = new Date(session.getLastAccessedTime());
			out.println("<h4>ID " + session.getId()+"</h4>");
			out.println("<h4>Created: " + created+"</h4>");
			out.println("<h4>Last Accessed: " + accessed+"</h4>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	}
}