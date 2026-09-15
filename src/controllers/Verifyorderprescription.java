package controllers;

import java.io.IOException;
import java.io.File;

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
 * Servlet implementation class Verifyorderprescription
 */
@WebServlet("/verifyorderprescription")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2,
	    maxFileSize = 1024 * 1024 * 10,
	    maxRequestSize = 1024 * 1024 * 50
	)
public class Verifyorderprescription extends HttpServlet {
	private static final String UPLOAD_DIR = "uploads/prescriptions";

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                return new File(fileName).getName();
            }
        }
        return null;
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verifyorderprescription() {
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
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("users") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String doctorName = request.getParameter("doctor_name");
        String hospitalName = request.getParameter("hospital_name");
        Part filePart = request.getPart("prescription");

        
        DbTransactions db = new DbTransactions();
        boolean doctorExists = db.checkDoctorExists(doctorName, hospitalName);
        if (!doctorExists) {
            response.sendRedirect("prescription_order.jsp?error=Doctor not recognized. Prescription mandatory.");
            return;
        }

        
        String fileName = getFileName(filePart);
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
        String filePath = uploadPath + File.separator + uniqueFileName;
        filePart.write(filePath);

        
        session.setAttribute("prescription_doctor", doctorName);
        session.setAttribute("prescription_hospital", hospitalName);
        session.setAttribute("prescription_file", uniqueFileName);

        
        response.sendRedirect("payment.jsp");
    }

}
