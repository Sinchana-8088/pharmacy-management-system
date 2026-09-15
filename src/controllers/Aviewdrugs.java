package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Categories;
import pojo.Drugs;
import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Aviewdrugs
 */
@WebServlet("/aviewdrugs")
public class Aviewdrugs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aviewdrugs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbTransactions d = new DbTransactions();
	    ArrayList<Drugs> li = new ArrayList<Drugs>();
	    li= d.getdrugsdetails();
	    request.setAttribute("drugs", li);
	    request.setAttribute("category", d.getcategorydetails());
	    RequestDispatcher rd = request.getRequestDispatcher("aviewdrugs.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
