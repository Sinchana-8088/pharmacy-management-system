package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Categories;
import dbtransactions.DbTransactions;

/**
 * Servlet implementation class Adddrugs
 */
@WebServlet("/adddrugs")
public class Adddrugs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adddrugs() {
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
	    RequestDispatcher rd = request.getRequestDispatcher("adddrugs.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String catergory_id= request.getParameter("catergory_id");
		String price= request.getParameter("price");
		String discount= request.getParameter("discount");
		String stock= request.getParameter("stock");
		
		DbTransactions d = new DbTransactions();
		if (d.checkDrug(name) == 1) {
            response.sendRedirect("adddrugs?error=Drug already exists");
            return;
        }

        int id = d.InsertDrug(name, catergory_id, price, discount, stock);

        if (id > 0) {
            response.sendRedirect("adddrugs?message=Drug Added Successfully");
        } else {
            response.sendRedirect("adddrugs?error=Failed to add drug");
        }
    }

}
