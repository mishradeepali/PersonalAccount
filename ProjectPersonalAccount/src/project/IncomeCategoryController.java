package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.IncomeCategoryDao;
import pojos.IncomeCategoryPojo;

/**
 * Servlet implementation class IncomeCategoryController
 */
@WebServlet("/IncomeCategoryController")
public class IncomeCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategoryController() {
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
		int inc_catid = 0;
		if(request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length()>0)
			inc_catid = Integer.parseInt(request.getParameter("inc_catid"));
		String inc_catname = request.getParameter("inc_catname");
		if (inc_catname == null) {
			inc_catname = new String();
		}
		String inc_catdetails = request.getParameter("inc_catdetails");
		if (inc_catdetails == null) {
			inc_catdetails = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		IncomeCategoryDao catDao = new IncomeCategoryDao();

		if (operation.equals("create")) {
			IncomeCategoryPojo cat = new IncomeCategoryPojo(inc_catid, inc_catname, inc_catdetails);
			catDao.create(cat);
		} else if (operation.equals("edit")) {
			IncomeCategoryPojo cat = new IncomeCategoryPojo(inc_catid, inc_catname, inc_catdetails);
			catDao.edit(cat);
		} else if (operation.equals("remove")) {
			catDao.remove(inc_catid);
		} 

		ArrayList<IncomeCategoryPojo> catLists = catDao.findAll();
		request.setAttribute("catLists", catLists);
		RequestDispatcher rd = request.getRequestDispatcher("IncomeCategoryHome");
		rd.forward(request, response);
	}


	

	}

