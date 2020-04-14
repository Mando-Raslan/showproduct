package mohamed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApiClass {
	
	
	public static Connection getConnection() {
		
		
		Connection mySql = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/client";
			String key = "root";
			String kPass = "";
			mySql = DriverManager.getConnection(url, key , kPass);
			
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mySql;
		
	}
	
	public static int[] registerUser(User user) {
		
		int [] status = {};
		Connection con = getConnection();
		

		
		try {
			
			String sql           = "insert into client_table (email,password,address,phone,	Country	,state,Gender,photo,Base64,AdminorUser) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAddress());
			ps.setInt(4,user.getPhone());
			ps.setString(5, user.getCountry());
			ps.setString(6, user.getState());
			ps.setString(7, user.getGender());
			ps.setBytes(8, user.getPhoto());
			ps.setString(9, user.getBase64());
			ps.setString(10, user.getAdminorUser());
			ps.addBatch();
			status  = ps.executeBatch();
			con.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static int deleteClient(int id) {
		
		int status = 0;
		Connection con = getConnection();
		
		try {
			String sql           = "delete from client_table where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.addBatch();
			status  = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
		
	}
	
	
	public static User login(String email , String password) {
		
		User user = null;
		Connection con = getConnection();
		
		try {
			String sql           = "select * from client_table where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet pointer = ps.executeQuery();
			while(pointer.next()) {
				user = new User();
				user.setEmail(pointer.getString("email"));
				user.setPassword(pointer.getString("password"));
				user.setAddress(pointer.getString("address"));
				user.setPhone(pointer.getInt("phone"));
				user.setCountry(pointer.getString("Country"));
				user.setState(pointer.getString("state"));
				user.setGender(pointer.getString("Gender"));
				user.setPhoto(pointer.getBytes("photo"));
				user.setBase64(pointer.getString("Base64"));
				user.setAdminorUser(pointer.getString("AdminorUser"));
				
				
			}
			
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
	
	public static List<User> getAllClients(){
		
		List<User> AllRecords = new ArrayList<User>();		
        Connection con = getConnection();
		
		try {
			String sql           = "select * from client_table";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet pointer    = ps.executeQuery();
			while(pointer.next()) {
				User user = new User();
				user.setEmail(pointer.getString("email"));
				user.setPassword(pointer.getString("password"));
				user.setAddress(pointer.getString("address"));
				user.setPhone(pointer.getInt("phone"));
				user.setCountry(pointer.getString("Country"));
				user.setState(pointer.getString("state"));
				user.setGender(pointer.getString("Gender"));
				user.setPhoto(pointer.getBytes("photo"));
				user.setBase64(pointer.getString("Base64"));
				user.setAdminorUser(pointer.getString("AdminorUser"));
				user.setId(pointer.getInt("id"));
				AllRecords.add(user);
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return AllRecords;
	}
	
	
	public static int addProduct(ProductModel productModel) {
		int status = 0;
		Connection con = getConnection();
		
		try {
			String sql           = "insert into product_table(productName,Base64,productPhoto,description) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,productModel.getProductName());
			ps.setString(2,productModel.getBase64());
			ps.setBytes (3, productModel.getPhoto());
			ps.setString(4, productModel.getDescription());
			status  = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
    public static List<ProductModel> getAllProduct(){
		
		List<ProductModel> AllRecords = new ArrayList<ProductModel>();		
		
        Connection con = getConnection();
		
		try {
			String sql           = "select * from product_table";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet pointer    = ps.executeQuery();
			
			while(pointer.next()) {
				ProductModel productModel = new ProductModel();
				productModel.setProductName(pointer.getString("productName"));
				productModel.setBase64(pointer.getString("Base64"));
				productModel.setPhoto(pointer.getBytes("productPhoto"));
				productModel.setDescription(pointer.getString("description"));
				productModel.setId(pointer.getInt("id"));
				
				
				productModel.setTimestamp(pointer.getTimestamp("timestamp"));
				AllRecords.add(productModel);
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		return AllRecords;
	}
    
    
    public static int deleteProduct(int id) {
    	int status = 0;
		Connection con = getConnection();
		
		try {
			String sql           = "delete from product_table where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			status  = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
    	
    }
    
    
    public static ProductModel getProduct(int id) {
    	
    	ProductModel productModel = null;
        Connection con = getConnection();
		
		try {
			String sql           = "select * from product_table where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet poinResultSet = ps.executeQuery();
			while(poinResultSet.next()) {
				productModel = new ProductModel();
				productModel.setProductName(poinResultSet.getString("productName"));
				productModel.setDescription(poinResultSet.getString("description"));
				productModel.setBase64(poinResultSet.getString("Base64"));
				productModel.setId(id);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return productModel;
    }
    
    
    
    public static int editProduct(ProductModel productModel ) {
		int status = 0;
		Connection con = getConnection();
		
		try {
			String sql           = "update product_table set productName=?,Base64=?,productPhoto=?,description=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,productModel.getProductName());
			ps.setString(2,productModel.getBase64());
			ps.setBytes (3, productModel.getPhoto());
			ps.setString(4, productModel.getDescription());
			ps.setInt(5, productModel.getId());
			status  = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
    
    
    public static List<ProductModel> Searching(String Search){
    	
    	List<ProductModel> AllRecord = new ArrayList<ProductModel>();
        Connection con = getConnection();
		
		try {
			String sql           = "select * from product_table where productName like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			String searchWord    = ""+Search+"%" ;
			ps.setString(1, searchWord);
			ResultSet poinResultSet = ps.executeQuery();
			while(poinResultSet.next()) {
				ProductModel productModel = new ProductModel();
				productModel.setProductName(poinResultSet.getString("productName"));
				productModel.setDescription(poinResultSet.getString("description"));
				productModel.setBase64(poinResultSet.getString("Base64"));
				productModel.setId(poinResultSet.getInt("id"));
				AllRecord.add(productModel);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    	return AllRecord;
    }
    
    
    
    
	
	

}
