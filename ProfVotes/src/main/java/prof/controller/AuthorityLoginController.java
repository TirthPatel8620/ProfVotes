package prof.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prof.dao.AuthorityDao;
import prof.person.Authority;

public class AuthorityLoginController extends HttpServlet {
	RequestDispatcher rd=null;
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+password);
		AuthorityDao authoritydao = new AuthorityDao();
		Authority authority = new Authority();

		if(authoritydao.login(email, password)) {
			authority = authoritydao.getAuthority(email);
			HttpSession session = request.getSession();
//			request.setAttribute("authority", authority);
			System.out.println(authority.getId());
			session.setAttribute("AUTHUSER", authority.getName());
			session.setAttribute("authority", authority);
			rd = request.getRequestDispatcher("authorityHome.jsp");
		}
		else {
			request.setAttribute("ERROR", "Invalid Email / Password");
			rd = request.getRequestDispatcher("authorityLogin.jsp");
		}
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
