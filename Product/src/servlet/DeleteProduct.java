package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mohamed.ApiClass;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out    = response.getWriter();
		int id      = Integer.parseInt(request.getParameter("id"));
		int status  = ApiClass.deleteProduct(id);
		
		if(status > 0) {
			
			response.sendRedirect("profile.jsp");
			
		}else {
			
			out.print("Errors Try to Delete This product Later");
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.include(request, response);
			
		}
		
	}

	

}
