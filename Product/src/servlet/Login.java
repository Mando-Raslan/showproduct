package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mohamed.ApiClass;
import mohamed.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email    = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user       = ApiClass.login(email, password);
		
		if(user != null) {
			

			
			HttpSession session = request.getSession();
			if(user.getAdminorUser().equals("admin")) {
				
				session.setAttribute("user", user);
				response.sendRedirect("profile.jsp");
				
			}else {
				//
				session.setAttribute("user", user);
				response.sendRedirect("userprofile.jsp");
				
			}
			
			
			
		}else {
			
			out.print(" <h1> Sorry Error Password. </h1> ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
