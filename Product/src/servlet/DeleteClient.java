package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mohamed.ApiClass;

/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id     = Integer.parseInt(request.getParameter("id"));
		
		int status = ApiClass.deleteClient(id);
		
		if(status > 0) {
			
			response.sendRedirect("ShowClient.jsp");
			
		}else {
			
			out.print("Try Again");
			
		}
		
	}

	
}
