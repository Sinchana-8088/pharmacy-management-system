package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtransactions.DbTransactions;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/adddoctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("adddoctor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
        String hospital = request.getParameter("hospital");

        DbTransactions db = new DbTransactions();
        int id = db.addDoctor(name, hospital);

        if (id > 0) {
            response.sendRedirect("viewdoctors?message=Doctor added");
        } else {
            response.sendRedirect("adddoctor.jsp?error=Failed to add doctor");
	}
	}
}
