package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.FormDto;

public class formDAO {
	
	final static String path= "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/googleform?user=root&password=root";
	Connection c;
	
	public int insertGoogleForm(FormDto f) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps= c.prepareStatement("INSERT INTO form (email_id, name, phone_number, dateofbirth, address, gender, marital_status, nationality) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	       if(c!=null) {
			ps.setString(1, f.getEmailId()); 
	        ps.setString(2, f.getName());
	        ps.setString(3, f.getPhoneNumber());
	        ps.setString(4, f.getDateOfBirth());
	        ps.setString(5, f.getAddress());
	        ps.setString(6, f.getGender());
	        ps.setString(7, f.getMaritalStatus());
	        ps.setString(8, f.getNationality());
			return ps.executeUpdate();
	       }else {
	    	   return 0;
	       }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				 if (c != null) {
		                c.close();
				 }
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}

}
