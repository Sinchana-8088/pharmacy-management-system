package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Addcategory
 */
@WebServlet("/addcategory")
public class Addcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcategory() {
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
		String name= request.getParameter("name");
		DbTransactions d = new DbTransactions();
		int res = d.checkcategory(name);
		if(res==1){
			response.sendRedirect("addcategory.jsp?error=Category already exists");
		}
		else if(res==0){
			int id = d.InsertCategory(name);
		    response.sendRedirect("addcategory.jsp?message=Category added Successfully");
		} 
		else {
		        response.sendRedirect("addcategory.jsp?error=Failed");
		    }
	}
}
