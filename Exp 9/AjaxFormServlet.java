import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AjaxFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String field_name = request.getParameter("field");
		String value = request.getParameter("data");

		if(field_name.equals("username")){
			if(value!=" " && value!=null){
				String regex1 = "^[a-zA-Z]+$";
				Pattern pattern1 = Pattern.compile(regex1);
				Matcher matcher1 = pattern1.matcher(value);
				if(!matcher1.matches()){
					out.write("*Name must not contain numbers");
				}
				else{
					out.write("valid");
				}
			}
		}


		if(field_name.equals("emailId")){
			if(value!=" " && value!=null){
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[.][a-z]+$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(value);
				if(!matcher.matches()){
					out.write("*Please enter a valid email address");
				}
				else{
					out.write("valid");
				}
			}
		}


		if(field_name.equals("dob")){
			if(value!=" " && value!=null){
				int user_age = Integer.parseInt(value);
				if(user_age<5 || user_age>99){
					out.write("*Invalid age");
				}
					else{
						out.write(" ");
					}
				}
		}

		if(field_name.equals("password1")){
			if(value!=" " && value!=null){
				if(value.length()<6 || value.length()>15)
				{
					out.write("*Password must be 6 to 15 Characters");
				}
				else{
					out.write("valid");
				}
			}
		}
		out.close();
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		out.println("Welcome "+username+" !");
		out.close();
	}
}