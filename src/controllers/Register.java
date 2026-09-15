package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		System.out.println("Register servlet called");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String pincode = request.getParameter("pincode");

        DbTransactions db = new DbTransactions();

        // check existing user
        if (db.checkUser(email) == 1) {
            response.sendRedirect("register.jsp?error=Email already exists");
            return;
        }

        int id = db.insertUser(name, email, phone, gender, age, password, address, pincode);

        System.out.println("Inserted ID: " + id);

        if (id > 0) {
            response.sendRedirect("login.jsp?message=Registration Successful!!");
        } else {
            response.sendRedirect("register.jsp?error=Registration Failed");
        }
	}

}
