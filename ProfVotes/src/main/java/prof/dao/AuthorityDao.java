package prof.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prof.person.Admin;
import prof.person.Authority;

public class AuthorityDao {
	private Connection connection = null;
	private Statement statement = null;

	private final String URL = "jdbc:mysql://localhost:3306/profvotes_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";
	public AuthorityDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			connection=DriverManager.getConnection(URL,DBUSER,DBPASSWORD);
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs=statement.executeQuery("SELECT * FROM authoritylogin_tbl WHERE email='"+email+"' AND password='"+password+"'");
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Authority getAuthority(String email) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs= statement.executeQuery("SELECT * FROM authority_tbl WHERE email='"+email+"'");
			while(rs.next()) {
				Authority authority=new Authority();
				authority.setEmail(email);
				authority.setName(rs.getString("name"));
				authority.setMobile(rs.getString("mobile"));
				authority.setGender(rs.getString("gender"));
				authority.setId(rs.getInt("id"));
				authority.setName(rs.getString("name"));
				return authority;
//				Set all roles as lists...
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
