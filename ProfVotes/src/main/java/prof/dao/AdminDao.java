package prof.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prof.person.Admin;
import prof.person.Voter;

public class AdminDao {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private final String URL = "jdbc:mysql://localhost:3306/profvotes_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";
	public AdminDao() {
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
	public boolean removeAdmin(String email) {
		try {
			Voter voter=new Voter();
			ResultSet rs=statement.executeQuery("SELECT * FROM admin_tbl WHERE email='"+email+"'");
			while(rs.next()) {
				
				voter.setEmail(email);
				voter.setName(rs.getString("name"));
				voter.setMobile(rs.getString("mobile"));
				voter.setGender(rs.getString("gender"));
				voter.setId(rs.getInt("id"));
				voter.setName(rs.getString("name"));
			}
			String sql1="INSERT INTO voter_tbl (id,name,email,mobile,gender,password) VALUES ("+voter.getId()+",'"+voter.getName()+"','"+voter.getEmail()+"','"+voter.getMobile()+"','"+voter.getGender()+"','"+voter.getPassword()+"') ";
			String sql2="INSERT INTO login_tbl (email,password) VALUES('"+voter.getEmail()+"','"+voter.getPassword()+"')";
			String sql3="INSERT INTO vote_tbl (email,name,vote) VALUES ('"+voter.getEmail()+"','"+voter.getName()+"','NOTA')";
			String sql4="DELETE FROM admin_tbl WHERE email='"+voter.getEmail()+"'";
			String sql5="DELETE FROM adminlogin_tbl WHERE email='"+voter.getEmail()+"'";
			statement.execute(sql1);
			statement.execute(sql2);
			statement.execute(sql3);
			statement.execute(sql4);
			statement.execute(sql5);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Admin getAdmin(String email) {
		try {
			ResultSet rs= statement.executeQuery("SELECT * FROM admin_tbl WHERE email='"+email+"'");
			while(rs.next()) {
				Admin admin=new Admin();
				admin.setEmail(email);
				admin.setName(rs.getString("name"));
				admin.setMobile(rs.getString("mobile"));
				admin.setGender(rs.getString("gender"));
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				return admin;
//				Set all roles as lists...
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Admin> getAllAdmin(){
		List<Admin> adminList=new ArrayList<Admin>();
		try {
			ResultSet rs=statement.executeQuery("SELECT * FROM admin_tbl");
			while(rs.next()) {
				Admin admin=new Admin();
				admin.setEmail(rs.getString("email"));
				admin.setName(rs.getString("name"));
				admin.setMobile(rs.getString("mobile"));
				admin.setGender(rs.getString("gender"));
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				adminList.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminList;
	}
	public boolean login(String email, String password) {
		try {
			ResultSet rs=statement.executeQuery("SELECT * FROM adminlogin_tbl WHERE email='"+email+"' AND password='"+password+"'");
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
