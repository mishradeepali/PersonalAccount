package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login</title>");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7; IE=EmulateIE9\">");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		out.println(
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\"/>");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/ProjectPersonalAccount/resources/style.css\" media=\"all\" />");
		out.println(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"/ProjectPersonalAccount/resources/demo.css\" media=\"all\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<header>");
		out.println("<h1>Welcome Home</h1>");
		out.println("</header>");
		out.println("<div  class=\"form\">");
		out.println("<form id=\"contactform\" action=\"LoginServlet\" method=\"post\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"username\">Username</label>");
		out.println("</p>");
		out.println("<input id=\"username\" name=\"username\" placeholder=\"name\" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"password\">Password</label>");
		out.println("</p>");
		out.println("<input id=\"password\" name=\"password\"  required=\"\" tabindex=\"1\" type=\"password\" >");
		out.println("<br> <input class=\"buttom\" name=\"submit\" id=\"submit\" tabindex=\"3\" value=\"Login !\" type=\"submit\">");
		out.println("<p class=\"contact\">");
		out.println("<h1><a href=\"RegistrationPage\">Register Me</a></h1>");
		out.println("</p>");
		
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
