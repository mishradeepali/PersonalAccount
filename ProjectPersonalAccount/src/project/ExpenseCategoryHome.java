package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.ExpensesCategoryPojo;

/**
 * Servlet implementation class ExpenseCategoryHome
 */
@WebServlet("/ExpenseCategoryHome")
public class ExpenseCategoryHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseCategoryHome() {
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
		out.println("function del(exp_catid) {");
		out.println("document.getElementById(\"exp_catid\").value = exp_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.expensecategoriesForm.submit();");
		out.println("}");
		out.println("function mod(exp_catid, exp_catname, exp_catdetails) {");
		out.println("document.getElementById(\"exp_catid\").value = exp_catid;");
		out.println("document.getElementById(\"exp_catname\").value = exp_catname;");
		out.println("document.getElementById(\"exp_catdetails\").value = exp_catdetails;");
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
		out.println("<h1>Expense Categories</h1>");
		out.println("</header>");
		out.println("<div  class=\"form\">");
		out.println(
				"<form id=\"expensecategoriesForm\" name=\"expensecategoriesForm\"  method=\"post\" action=\"ExpensesCategoryController\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\"> Category Name</label>");
		out.println("</p>");
		out.println(
				"<input id=\"exp_catname\" name=\"exp_catname\" placeholder=\"Name \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\"> Category Details</label>");
		out.println("</p>");
		out.println(
				"<textarea id=\"exp_catdetails\" rows=\"5\" cols=\"57\" name=\"exp_catdetails\"  required=\"\" tabindex=\"2\" > </textarea><br>");
		out.println(
				"<br> <input class=\"buttom\" name=\"add\" id=\"add\" tabindex=\"3\" value=\"Add !\" type=\"submit\">");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"exp_catid\" id=\"exp_catid\"   type=\"hidden\">");

		out.println("</form>");
		out.println("</div>");
		out.println("<br>");
		out.println("<div  class=\"form\">");
		out.println("<br>");
		out.println("<table width=\"90%\" border=\"1\">");
		out.println(
				"<tr><td align=\"center\">Category Name </td><td align=\"center\"> Category Details</td><td align=\"center\"> &nbsp;</td><td align=\"center\"> &nbsp;</td></tr>");
		ArrayList<ExpensesCategoryPojo> catList = (ArrayList<ExpensesCategoryPojo>) request.getAttribute("catList");
		for (ExpensesCategoryPojo cat : catList) {
			out.println("<tr>");
			out.println("<td>" + cat.getExp_catname() + "</td>");
			out.println("<td>" + cat.getExp_catdetails() + "</td>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+cat.getExp_catid()+"','"+cat.getExp_catname()+"','"+cat.getExp_catdetails()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+cat.getExp_catid()+"');\" ></td>");
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


