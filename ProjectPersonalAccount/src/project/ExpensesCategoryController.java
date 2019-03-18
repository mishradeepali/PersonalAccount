package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ExpenseCategoryDao;
import pojos.ExpensesCategoryPojo;

/**
 * Servlet implementation class ExpensesCategoryController
 */
@WebServlet("/ExpensesCategoryController")
public class ExpensesCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesCategoryController() {
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
		int exp_catid = 0;
		if(request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length()>0)
			exp_catid = Integer.parseInt(request.getParameter("exp_catid"));
		String exp_catname = request.getParameter("exp_catname");
		if (exp_catname == null) {
			exp_catname = new String();
		}
		String exp_catdetails = request.getParameter("exp_catdetails");
		if (exp_catdetails == null) {
			exp_catdetails = new String();
		}
	
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		ExpenseCategoryDao catDao = new ExpenseCategoryDao();

		if (operation.equals("create")) {
			ExpensesCategoryPojo cat = new ExpensesCategoryPojo(exp_catid, exp_catname, exp_catdetails);
			catDao.create(cat);
		} else if (operation.equals("edit")) {
			ExpensesCategoryPojo cat = new ExpensesCategoryPojo(exp_catid, exp_catname, exp_catdetails);
			catDao.edit(cat);
		} else if (operation.equals("remove")) {
			catDao.remove(exp_catid);
		} 

		ArrayList<ExpensesCategoryPojo> catList = catDao.findAll();
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("ExpenseCategoryHome");
		rd.forward(request, response);
	}


	}


