package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Drugs;
import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Uviewdrugs
 */
@WebServlet("/uviewdrugs")
public class Uviewdrugs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uviewdrugs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DbTransactions db = new DbTransactions();

		    
		    ArrayList<Drugs> drugsList = db.getdrugsdetails();

		    
		    request.setAttribute("drugs", drugsList);             
		    request.setAttribute("category", db.getcategorydetails()); 
		    request.setAttribute("allDrugs", drugsList);           

		    RequestDispatcher rd = request.getRequestDispatcher("uviewdrugs.jsp");
		    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
