package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.CashBookPojo;

/**
 * Servlet implementation class CashBookHome
 */
@WebServlet("/CashBookHome")
public class CashBookHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashBookHome() {
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
		out.println("<h1>Cash Book </h1>");
		out.println("</header>");
		out.println("<div  class=\"form\">");
		out.println(
				"<form id=\"cashbookForm\" name=\"cashbookForm\"  method=\"post\" action=\"CashBookController\">");
		
		out.println("<p class=\"contact\">");
		out.println("<label for=\"name\">Date From</label>");
		out.println("</p>");
		out.println(
				"<input id=\"sdate\" name=\"sdate\"   required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println("<p class=\"contact\">");
		out.println("<label for=\"phone\">To</label>");
		out.println("</p>");
		out.println(
				"<input id=\"edate\" name=\"edate\"  required=\"\" tabindex=\"1\" type=\"text\" >");
		out.println(
				"<br> <input class=\"buttom\" name=\"show\" id=\"show\" tabindex=\"3\" value=\"Show!\" type=\"submit\">");
		
		out.println("<input name=\"acid\" id=\"acid\"   type=\"hidden\">");

		out.println("</form>");
		out.println("</div>");
		out.println("<br>");
		out.println("<div  class=\"form\">");
		out.println("<br>");
		out.println("<table width=\"90%\" border=\"1\">");
		out.println(
				"<tr><td align=\"center\">Date </td><td align=\"center\"> Amount</td><td align=\"center\"> Operation</td></tr>");
		ArrayList<CashBookPojo> catList = (ArrayList<CashBookPojo>) request.getAttribute("catList");
		for (CashBookPojo cat : catList) {
			out.println("<tr>");
			out.println("<td>" + cat.getTran_date() + "</td>");
			out.println("<td>" + cat.getAmount() + "</td>");
			out.println("<td>" + cat.getOperation() + "</td>");
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
