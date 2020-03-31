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
import javax.servlet.http.Part;

import mohamed.ApiClass;
import mohamed.ProductModel;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out    = response.getWriter();
		
		ProductModel productModel                    = (ProductModel)request.getSession(false).getAttribute("product");
		int id                    = productModel.getId();
	    
	    String       productName  = request.getParameter("productName");
	    String       description  = request.getParameter("description");
	    Part         photo        = request.getPart("photo");
	    
	    if(photo!=null) {
	    	ProductModel productModel2 = new ProductModel();
	    	productModel2.setProductName(productName);
	    	productModel2.setDescription(description);
	    	productModel2.setPhoto(getByte(photo.getInputStream()));
	    	productModel2.setBase64(Base64.getEncoder().encodeToString(getByte(photo.getInputStream())));
	    	productModel2.setId(id);
	    	int status      = ApiClass.editProduct(productModel2);
	    	if(status > 0) {
	    		
	    		response.sendRedirect("profile.jsp");
	    		
	    	}else {
	    		
	    		out.print("Errors Try to Add This product Later");
				RequestDispatcher dispatcher = request.getRequestDispatcher("EditProductForm.jsp");
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
