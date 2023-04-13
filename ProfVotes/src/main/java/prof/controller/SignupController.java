package prof.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prof.dao.VoterDao;
import prof.person.Voter;

public class SignupController extends HttpServlet {
	RequestDispatcher rd;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String gender=request.getParameter("gender");
		Voter voter = new Voter();
		VoterDao voterdao = new VoterDao();
		voter.setName(name);
		voter.setEmail(email);
		voter.setGender(gender);
		voter.setMobile(mobile);
		voter.setPassword(password);

			boolean sign = voterdao.create(voter);
			if(sign) {
				
				request.setAttribute("MESSAGE", "Signup Successful....");
				rd = request.getRequestDispatcher("login.jsp");
				
			}else {
				rd = request.getRequestDispatcher("signup.jsp");
			}

			rd.forward(request, response);
		
	}
}
