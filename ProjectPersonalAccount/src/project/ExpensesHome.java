package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.ExpensesDao;
import pojos.ExpensesPojo;
/**
 * Servlet implementation class ExpensesHome
 */
@WebServlet("/ExpensesHome")
public class ExpensesHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		out.println("<h1>Expenses </h1>");
		out.println("</header>");
		out.println("<div  class=\"form\">");
		out.println(
				"<form id=\"expensesForm\" name=\"expensesForm\"  method=\"post\" action=\"ExpensesController\">");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Expense</label>");
		out.println("</p>");
		out.println(
				"<input id=\"exp_ac\" name=\"exp_ac\" placeholder=\"Name \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\">Category</label>");
		out.println("</p>");
		out.println(
				"<input id=\"exp_catid\" name=\"exp_catid\" placeholder=\"category id \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"iphone\">Amount</label>");
		out.println("</p>");
		out.println(
				"<input id=\"amount\" name=\"amount\"  required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"pphone\">Date</label>");
		out.println("</p>");
		out.println(
				"<input id=\"tran_date\" name=\"tran_date\"  required=\"\" tabindex=\"1\" type=\"text\" >");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"ephone\">Payby</label>");
		out.println("</p>");
		out.println(
				"<input id=\"payby\" name=\"payby\" placeholder=\"cash or bank \" required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"hphone\">Remark</label>");
		out.println("</p>");
		out.println(
				"<input id=\"remark\" name=\"remark\"  required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println(
				"<br> <input class=\"buttom\" name=\"submit\" id=\"submit\" tabindex=\"3\" value=\"Submit\" type=\"submit\">");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"exp_id\" id=\"exp_id\"   type=\"hidden\">");

		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
