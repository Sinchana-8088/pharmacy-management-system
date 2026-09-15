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
 * Servlet implementation class Placeorder
 */
@WebServlet("/placeorder")
public class Placeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Placeorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("users") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    String email = (String) session.getAttribute("users");
	    DbTransactions d = new DbTransactions();
	    int user_id = d.getUserIdByEmail(email);
	    if (user_id == 0) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    // Get prescription details from session (set by VerifyOrderPrescription)
	    String doctorName = (String) session.getAttribute("prescription_doctor");
	    String hospitalName = (String) session.getAttribute("prescription_hospital");
	    String prescriptionFile = (String) session.getAttribute("prescription_file");

	    // Payment method (optional – we ignore but you can store it)
	    String paymentMethod = request.getParameter("payment_method");

	    // Place order with prescription details
	    d.placeOrderWithPrescription(user_id, doctorName, hospitalName, prescriptionFile);

	    // Clear prescription details from session
	    session.removeAttribute("prescription_doctor");
	    session.removeAttribute("prescription_hospital");
	    session.removeAttribute("prescription_file");

	    // Redirect to My Orders page with success message
	    response.sendRedirect("myorders?message=Order placed successfully");
	}

}
