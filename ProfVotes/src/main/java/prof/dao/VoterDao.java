package prof.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prof.person.VoteListAttr;
import prof.person.Voter;

public class VoterDao {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private final String URL = "jdbc:mysql://localhost:3306/profvotes_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";
	public VoterDao() {
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
	public boolean create(Voter voter) {
//		Also add to vote table as blank vote and in vote form it will only update vote
		String sql1="INSERT INTO voter_tbl (name,email,mobile,gender,password) VALUES (?,?,?,?,?) ";
		String sql2="INSERT INTO login_tbl (email,password) VALUES(?,?)";
		String sql3="INSERT INTO vote_tbl (email,name,vote) VALUES (?,?,?)";
		
		try {

			System.out.println(voter.getEmail());
			PreparedStatement pstatement = connection.prepareStatement("INSERT INTO voter_tbl (name,email,mobile,gender,password) VALUES (?,?,?,?,?)");
			pstatement.setString(1, voter.getName());
			pstatement.setString(2, voter.getEmail());
			pstatement.setString(3, voter.getMobile());
			pstatement.setString(4, voter.getGender());
			pstatement.setString(5, voter.getPassword());
			PreparedStatement pstatement2 = connection.prepareStatement(sql2);
			pstatement2.setString(1, voter.getEmail());
			pstatement2.setString(2, voter.getPassword());
			PreparedStatement pstatement3 = connection.prepareStatement(sql3);
		
			pstatement3.setString(1, voter.getEmail());
			pstatement3.setString(2, voter.getName());
			pstatement3.setString(3, "NOTA");
			pstatement.executeUpdate();
			pstatement2.executeUpdate();
			pstatement3.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateRole(Voter voter) {
//		add to admin table and remove from voter table 
//		also update their login tables
		String sql1="INSERT INTO admin_tbl (id,name,email,mobile,gender,password) VALUES ("+voter.getId()+",'"+voter.getName()+"','"+voter.getEmail()+"','"+voter.getMobile()+"','"+voter.getGender()+"','"+voter.getPassword()+"')";//Add in admin_tbl
		String sql2="INSERT INTO adminlogin_tbl (email,password) VALUES('"+voter.getEmail()+"','"+voter.getPassword()+"')";//Add in adminlogin_tbl
		String sql3="DELETE FROM voter_tbl WHERE email='"+voter.getEmail()+"'";//Remove from voter_tbl
		String sql4="DELETE FROM login_tbl WHERE email='"+voter.getEmail()+"'";//Remove from login_tbl
		String sql5="DELETE FROM vote_tbl WHERE email='"+voter.getEmail()+"'";//For removing voter's vote cause admin can't vote
		try {
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
	public boolean remove(String email) {
		String sql3="DELETE FROM voter_tbl WHERE email='"+email+"'";
		String sql4="DELETE FROM login_tbl WHERE email='"+email+"'";
		String sql5="DELETE FROM vote_tbl WHERE email='"+email+"'";
		try {
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
	public Voter getVoter(String email) {
		try {
			resultSet= statement.executeQuery("SELECT * FROM voter_tbl WHERE email='"+email+"'");
			while(resultSet.next()) {
				Voter voter=new Voter();
				voter.setEmail(email);
				voter.setName(resultSet.getString("name"));
				voter.setMobile(resultSet.getString("mobile"));
				voter.setGender(resultSet.getString("gender"));
				voter.setId(resultSet.getInt("id"));

				return voter;
//				Set all roles as lists...
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Voter> getAllVoter(){
		List<Voter> voterList=new ArrayList<Voter>();
		try {
			resultSet=statement.executeQuery("SELECT * FROM voter_tbl");
			while(resultSet.next()) {
				Voter voter=new Voter();
				voter.setEmail(resultSet.getString("email"));
				voter.setName(resultSet.getString("name"));
				voter.setMobile(resultSet.getString("mobile"));
				voter.setGender(resultSet.getString("gender"));
				voter.setId(resultSet.getInt("id"));

				voterList.add(voter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voterList;
	}
	
	public List<VoteListAttr> voteReview(){
		List<VoteListAttr> voteList=new ArrayList<VoteListAttr>();
		try {
			resultSet=statement.executeQuery("SELECT * FROM vote_tbl");
			while(resultSet.next()) {
				VoteListAttr votelist = new VoteListAttr();
				votelist.setEmail(resultSet.getString("email"));
				votelist.setName(resultSet.getString("name"));
				votelist.setVote(resultSet.getString("vote"));
				voteList.add(votelist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voteList;
	}
	
	public boolean login(String email, String password) {
		try {
			resultSet=statement.executeQuery("SELECT * FROM login_tbl WHERE email='"+email+"' AND password='"+password+"'");
			while(resultSet.next()) {

				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean submitVote(Voter voter, String vote) {
//		Update vote in vote table
		String sql="UPDATE vote_tbl SET vote='"+vote+"' WHERE email='"+voter.getEmail()+"'";
		
		try {
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
