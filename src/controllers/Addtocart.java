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
 * Servlet implementation class Addtocart
 */
@WebServlet("/addtocart")
public class Addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		

	    if (session == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    String email = (String) session.getAttribute("users");

	    if (email == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    String drug_id = request.getParameter("drug_id");

	    DbTransactions d = new DbTransactions();
	    int user_id = d.getUserIdByEmail(email);

	    if (user_id == 0) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    d.addToCart(user_id, Integer.parseInt(drug_id));

	    response.sendRedirect("viewcart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
