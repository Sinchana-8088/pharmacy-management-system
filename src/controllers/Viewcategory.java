package controllers;

import java.io.IOException;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Categories;
import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Viewcategory
 */
@WebServlet("/viewcategory")
public class Viewcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DbTransactions d = new DbTransactions();
		    ArrayList<Categories> li = new ArrayList<Categories>();
		    li= d.getcategorydetails();
		    request.setAttribute("category", li);
		    RequestDispatcher rd = request.getRequestDispatcher("viewcategory.jsp");
		    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
