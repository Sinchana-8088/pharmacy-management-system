package controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	 /*public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	            throws IOException, ServletException {

	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;

	       
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0);

	        HttpSession session = request.getSession(false);

	        boolean loggedIn = (session != null && session.getAttribute("admin") != null || session.getAttribute("users") != null);

	        String uri = request.getRequestURI();

	        boolean isLoginPage = uri.endsWith("login.jsp");
	        boolean isLoginServlet = uri.endsWith("login");
	        boolean isLogout = uri.endsWith("logout");
	        
	        boolean isResource = uri.contains("css") || uri.contains("js") || uri.contains("images");

	        if (loggedIn || isLoginPage || isLoginServlet || isLogout || isResource) {
	            chain.doFilter(req, res); // allow
	        } else {
	            response.sendRedirect("login.jsp"); // block
	        }
	    }*/
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);

        boolean loggedIn = false;

        if (session != null) {
            loggedIn = (session.getAttribute("admin") != null ||
                        session.getAttribute("users") != null);
        }

        String uri = request.getRequestURI();

        boolean isHomePage = uri.endsWith("index.jsp");
        boolean isLoginPage = uri.endsWith("login.jsp");
        boolean isRegisterPage = uri.endsWith("register.jsp");

        boolean isLoginServlet = uri.endsWith("login");
        boolean isRegisterServlet = uri.endsWith("register");

        boolean isLogout = uri.endsWith("logout");

        boolean isResource = uri.contains("css") || uri.contains("js") || uri.contains("images");

        
        if (loggedIn || isLoginPage || isRegisterPage ||
            isLoginServlet || isRegisterServlet ||
            isLogout || isResource) {

            chain.doFilter(req, res); // allow

        } else {
            response.sendRedirect("login.jsp"); // block
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
