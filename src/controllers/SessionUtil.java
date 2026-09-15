package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    /*public static Integer getCid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("cid") == null) {
            response.sendRedirect("login.jsp");
            return null;
        }

        return (Integer) session.getAttribute("cid");
    }*/
	
	public static String getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.jsp");
            return null;
        }

        String admin = (String) session.getAttribute("admin");
        String user = (String) session.getAttribute("users");

        if (admin == null && user == null) {
            response.sendRedirect("login.jsp");
            return null;
        }

        return (admin != null) ? admin : user;
    }
}