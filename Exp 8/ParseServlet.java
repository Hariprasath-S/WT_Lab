import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Parse XML</title>"+
		"<link rel=\"stylesheet\" href=\"styles.css\">");
		out.println("</head>");
		out.println("<body");
		out.println("<div class=\"container\">");
		out.println("<center><h1>Details</h1>");
			DomParser parser=new DomParser();
			String str[]=parser.searchstudent(request.getParameter("data"));
			if(str!=null)
			{
				out.println("<table id=\"viewtable\">");
				out.println("<tr><td>Name : </td><td>"+str[1]+"</td></tr>");
				out.println("<tr><td>Roll No: </td><td>"+str[0]+"</td></tr>");
				out.println("<tr><td>Department : </td><td>"+str[2]+"</td></tr>");
				out.println("<tr><td>Email : </td><td>"+str[3]+"</td></tr>");
				out.println("<div><a href=\"index.html\" class=\"button\">Back</a></div>");
			}
			else{
				out.println("<h2>"+"No student found"+"</h2>");
				out.println("<div><a href=\"index.html\" class=\"button\">Back</a></div>");
			}

	out.println("</div>"+"</body>");
	out.println("</html>");
}
}
		