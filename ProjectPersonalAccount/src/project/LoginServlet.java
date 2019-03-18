package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UsersDao;
import pojos.UsersPojo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get request parameters for userID and password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username : " + username);
		System.out.println("password : " + password);

		if (username == null && password == null)
			response.sendRedirect("LoginForm");
		int id = UsersDao.checkAvailability(username, password);
		System.out.println("name : " + id);
		if (id != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("uid", new Integer(id));
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("template_3318/index.html");
		} else {
			response.sendRedirect("LoginForm");
		}
	}

}
