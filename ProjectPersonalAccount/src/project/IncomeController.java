package project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.IncomesDao;
import pojos.IncomesPojo;

/**
 * Servlet implementation class IncomeController
 */
@WebServlet("/IncomeController")
public class IncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeController() {
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
		int inc_id = 0;
		if(request.getParameter("inc_id") != null && request.getParameter("inc_id").trim().length()>0)
			inc_id = Integer.parseInt(request.getParameter("inc_id"));
		
		String inc_ac = request.getParameter("inc_ac");
		if (inc_ac == null) {
			inc_ac = new String();
		}
		int inc_catid = 0;
		if (request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length() > 0)
			inc_catid = Integer.parseInt(request.getParameter("inc_catid"));
		
		int amount = 0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Integer.parseInt(request.getParameter("amount"));
		
		String tran_date = request.getParameter("tran_date");
		if (tran_date == null) {
			tran_date= new String();
		}
		
		String receiveby = request.getParameter("receiveby");
		if (receiveby == null) {
			receiveby = new String();
		}
		
		String remark = request.getParameter("remark");
		if (remark == null) {
			remark = new String();
		}

		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		IncomesDao catDao = new IncomesDao();

		if (operation.equals("create")) {
			IncomesPojo cat = new IncomesPojo(inc_id,inc_ac,inc_catid,amount,tran_date,receiveby,remark);
			catDao.create(cat);
		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("IncomeHome");
		rd.forward(request, response);
	}
	
}


