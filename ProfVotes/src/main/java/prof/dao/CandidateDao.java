package prof.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prof.person.Candidate;

public class CandidateDao {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private final String URL = "jdbc:mysql://localhost:3306/profvotes_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";
	public CandidateDao() {
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
	public Candidate getCandidate(String name) {
		return null;
	}
}
