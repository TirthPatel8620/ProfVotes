package prof.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prof.dao.VoterDao;
import prof.person.VoteListAttr;

public class ManageVoterAuthController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse responde) {
		VoterDao voterdao = new VoterDao();
		request.setAttribute("voters",voterdao.getAllVoter() );


		RequestDispatcher rd = request.getRequestDispatcher("ManageVoterAuth.jsp");
		try {
			rd.forward(request, responde);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
