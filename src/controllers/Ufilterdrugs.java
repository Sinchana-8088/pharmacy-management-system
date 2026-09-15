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
 * Servlet implementation class Ufilterdrugs
 */
@WebServlet("/ufilterdrugs")
public class Ufilterdrugs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ufilterdrugs() {
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

        // filtered list
        ArrayList<Drugs> list = db.getFilteredDrugs(category, drugId, sort);

        // for dropdowns
        request.setAttribute("drugs", list);
        request.setAttribute("category", db.getcategorydetails());
        request.setAttribute("allDrugs", db.getdrugsdetails());

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
