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
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");

	        DbTransactions db = new DbTransactions();

	        // Get drug by ID (better method)
	        Drugs drug = db.getDrugById(Integer.parseInt(id));

	        ArrayList<Categories> catList = db.getcategorydetails();

	        request.setAttribute("drug", drug);
	        request.setAttribute("category", catList);

	        RequestDispatcher rd = request.getRequestDispatcher("updatedrug.jsp");
	        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String category = request.getParameter("catergory_id");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String stock = request.getParameter("stock");

        DbTransactions db = new DbTransactions();
        db.updateDrug(id, category, price, discount, stock);

        response.sendRedirect("aviewdrugs");
	}

}
