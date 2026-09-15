package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logintype = request.getParameter("logintype");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DbTransactions d= new DbTransactions();
		int res = d.validateLtype(email,password,logintype);
		HttpSession session = request.getSession();
		

	    if (res > 0) {

	        if (logintype.equals("Admin")) {

	            session.setAttribute("admin", email);
	            response.sendRedirect("admindashboard");

	        } else if (logintype.equals("User")) {

	            session.setAttribute("users", email);
	            response.sendRedirect("uviewdrugs");
	        }

	    } else {

	        response.sendRedirect("login.jsp?message=invalid");

	    }
		
	}

}
