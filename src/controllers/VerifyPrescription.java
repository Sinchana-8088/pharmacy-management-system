package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dbtransactions.DbTransactions;

/**
 * Servlet implementation class VerifyPrescription
 */
@WebServlet("/verifyprescription")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
	    maxFileSize = 1024 * 1024 * 10,        // 10MB
	    maxRequestSize = 1024 * 1024 * 50
	)
public class VerifyPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads/prescriptions";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                // Extract only the base name, remove path if any (e.g., IE sends full path)
                return new File(fileName).getName();
            }
        }
        return null;
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
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("users") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String drug_id = request.getParameter("drug_id");
        String doctorName = request.getParameter("doctor_name");
        String hospitalName = request.getParameter("hospital_name");
        Part filePart = request.getPart("prescription");

        // 1. Check if doctor exists in database
        DbTransactions db = new DbTransactions();
        boolean doctorExists = db.checkDoctorExists(doctorName, hospitalName);
        if (!doctorExists) {
            response.sendRedirect("prescription.jsp?drug_id=" + drug_id + "&error=Sory, doctor not recognized! Prescription mandatory.");
            return;
        }

        // 2. Save the uploaded file
        String fileName = getFileName(filePart);
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
        String filePath = uploadPath + File.separator + uniqueFileName;
        filePart.write(filePath);

        // 3. Get user ID
        String email = (String) session.getAttribute("users");
        int user_id = db.getUserIdByEmail(email);
        if (user_id == 0) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 4. Add to cart with prescription details
        int result = db.addToCart(user_id, Integer.parseInt(drug_id), doctorName, hospitalName, uniqueFileName);
        if (result > 0) {
            response.sendRedirect("viewcart");
        } else {
            response.sendRedirect("prescription.jsp?drug_id=" + drug_id + "&error=Failed to add to cart. Try again.");
        }
    }
}


