package prof.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prof.dao.VoterDao;
import prof.person.Voter;

public class LoginController extends HttpServlet {
	RequestDispatcher rd=null;
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+password);
		VoterDao voterdao= new VoterDao();
		Voter voter=new Voter();
		boolean log=voterdao.login(email, password);
		if(log) {
			voter = voterdao.getVoter(email);
			HttpSession session = request.getSession();
			request.setAttribute("voter", voter);
			System.out.println(voter.getId());
			session.setAttribute("AUTHUSER", voter.getName());
			
			rd = request.getRequestDispatcher("home.jsp");
		} else {
			request.setAttribute("ERROR", "Invalid Email / Password");
			rd = request.getRequestDispatcher("login.jsp");
		}
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		
	}

}
}
