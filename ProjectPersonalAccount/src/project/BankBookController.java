package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BankBookDao;
import pojos.BankBookPojo;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
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
		int acid = 0;
		if(request.getParameter("acid") != null && request.getParameter("acid").trim().length()>0)
			acid = Integer.parseInt(request.getParameter("acid"));
		
		String tran_date = request.getParameter("tran_date");
		if (tran_date == null) {
			tran_date = new String();
		}
		String sdate = request.getParameter("sdate");
		if (sdate == null) {
			sdate = new String();
		}
		String edate = request.getParameter("edate");
		if (edate == null) {
			edate = new String();
		}
		double amount = 0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Integer.parseInt(request.getParameter("amount"));
		
		
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation= new String();
		}
		
		
		
		BankBookDao cd = new BankBookDao();

		
		ArrayList<BankBookPojo> catList = cd.findAllDateWise(sdate,edate);
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("BankBookHome");
		rd.forward(request, response);
	}

}
