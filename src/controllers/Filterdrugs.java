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
 * Servlet implementation class Filterdrugs
 */
@WebServlet("/filterdrugs")
public class Filterdrugs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filterdrugs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
        String drugId = request.getParameter("drugId");
        String sort = request.getParameter("sort");

        DbTransactions db = new DbTransactions();

        ArrayList<Drugs> list = db.filterDrugs(category, drugId, sort);

        request.setAttribute("category", db.getcategorydetails());
        request.setAttribute("drugs", list);

        RequestDispatcher rd = request.getRequestDispatcher("aviewdrugs.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
