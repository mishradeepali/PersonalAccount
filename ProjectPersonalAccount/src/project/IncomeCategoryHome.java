package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.IncomeCategoryPojo;
import daos.IncomeCategoryDao;

/**
 * Servlet implementation class IncomeCategoryHome
 */
@WebServlet("/IncomeCategoryHome")
public class IncomeCategoryHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategoryHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<script>");
		out.println("function del(inc_catid) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.incomecategoriesForm.submit();");
		out.println("}");
		out.println("function mod(inc_catid, inc_catname, inc_catdetails) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"inc_catname\").value = inc_catname;");
		out.println("document.getElementById(\"inc_catdetails\").value = inc_catdetails;");
		out.println("document.getElementById(\"add\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'edit';");
		out.println("}");
		out.println("</script>");
		out.println("<title>BankExpenses</title>");
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
		out.println("<h1>Income Categories</h1>");
		out.println("</header>");
		out.println("<div  class=\"form\">");
		out.println(
				"<form id=\"incomecategoriesForm\" name=\"incomecategoriesForm\"  method=\"post\" action=\"IncomeCategoryController\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\"> Category Name</label>");
		out.println("</p>");
		out.println(
				"<input id=\"inc_catname\" name=\"inc_catname\" placeholder=\"Name \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\"> Category Details</label>");
		out.println("</p>");
		out.println(
				"<textarea id=\"inc_catdetails\" rows=\"5\" cols=\"57\" name=\"inc_catdetails\"  required=\"\" tabindex=\"2\" > </textarea><br>");
		out.println(
				"<br> <input class=\"buttom\" name=\"add\" id=\"add\" tabindex=\"3\" value=\"Add !\" type=\"submit\">");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"inc_catid\" id=\"inc_catid\"   type=\"hidden\">");

		out.println("</form>");
		out.println("</div>");
		out.println("<br>");
		out.println("<div  class=\"form\">");
		out.println("<br>");
		out.println("<table width=\"90%\" border=\"1\">");
		out.println(
				"<tr><td align=\"center\">Category Name </td><td align=\"center\"> Category Details</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		ArrayList<IncomeCategoryPojo> catLists = (ArrayList<IncomeCategoryPojo>) request.getAttribute("catLists");
		for (IncomeCategoryPojo cat : catLists) {
			out.println("<tr>");
			out.println("<td>" + cat.getInc_catname() + "</td>");
			out.println("<td>" + cat.getInc_catdetails() + "</td>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+cat.getInc_catid()+"','"+cat.getInc_catname()+"','"+cat.getInc_catdetails()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+cat.getInc_catid()+"');\" ></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
