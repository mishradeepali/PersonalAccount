package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ExpensesDao;
import pojos.ExpensesCategoryPojo;
import pojos.ExpensesPojo;

/**
 * Servlet implementation class ExpensesController
 */
@WebServlet("/ExpensesController")
public class ExpensesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesController() {
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
		int exp_id = 0;
		if(request.getParameter("exp_id") != null && request.getParameter("exp_id").trim().length()>0)
			exp_id = Integer.parseInt(request.getParameter("exp_id"));
		
		String exp_ac = request.getParameter("exp_ac");
		if (exp_ac == null) {
			exp_ac = new String();
		}
		int exp_catid = 0;
		if (request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length() > 0)
			exp_catid = Integer.parseInt(request.getParameter("exp_catid"));
		
		int amount = 0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Integer.parseInt(request.getParameter("amount"));
		
		String tran_date = request.getParameter("tran_date");
		if (tran_date == null) {
			tran_date= new String();
		}
		
		String payby = request.getParameter("payby");
		if (payby == null) {
			payby = new String();
		}
		
		String remark = request.getParameter("remark");
		if (remark == null) {
			remark = new String();
		}

		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		ExpensesDao catDao = new ExpensesDao();

		if (operation.equals("create")) {
			ExpensesPojo cat = new ExpensesPojo(exp_id, exp_ac,exp_catid,amount,tran_date,payby,remark);
			catDao.create(cat);
		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ExpensesHome");
		rd.forward(request, response);
	}
}
