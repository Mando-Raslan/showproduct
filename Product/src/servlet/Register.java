package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mohamed.ApiClass;
import mohamed.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer  = response.getWriter();
		Part   photo        = request.getPart("photo");
		
		if(photo != null) {
			User user       = new User();
			String Base64Image   = Base64.getEncoder().encodeToString(getByte(photo.getInputStream()));
			String email    = request.getParameter("email");
			String password = request.getParameter("password");
			String address  = request.getParameter("address");
			int    phone    = Integer.parseInt(request.getParameter("phone"));
			String Country  = request.getParameter("Country");
			String state    = request.getParameter("state");
			String Gender   = request.getParameter("Gender");
			String AdminorUser = "user";
			user.setEmail(email);
			user.setPassword(password);
			user.setAddress(address);
			user.setPhone(phone);
			user.setCountry(Country);
			user.setState(state);
			user.setGender(Gender);
			user.setAdminorUser(AdminorUser);
			user.setBase64(Base64Image);
			user.setPhoto(getByte(photo.getInputStream()));
			int status      = ApiClass.registerUser(user);
			
			if(status > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("profile.jsp");
				
			}else {
				
				writer.print("<h1>Errors In Page Try Again</h1>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registerform.jsp");
				dispatcher.include(request, response);
				
				
			}
			
		}
		
	}
	
	public static byte [] getByte(InputStream input) throws IOException {
		
		byte [] buffer = new byte [8200];
		int s ; 
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
			while((s = input.read(buffer)) != -1) {
				
				outputStream.write(buffer, 0, s);
			}
			
		return outputStream.toByteArray();
	}
	

}
