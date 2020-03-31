package mohamed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	

}
