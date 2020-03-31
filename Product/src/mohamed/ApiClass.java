package mohamed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static int registerUser(User user) {
		
		int status = 0;
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
	
	
	
	

}
