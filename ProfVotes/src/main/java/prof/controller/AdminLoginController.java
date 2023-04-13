package prof.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prof.dao.AdminDao;
import prof.person.Admin;

public class AdminLoginController extends HttpServlet {
	RequestDispatcher rd=null;
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+password);
		AdminDao admindao = new AdminDao();
		Admin admin = new Admin();

		if(admindao.login(email, password)) {
			admin = admindao.getAdmin(email);
			HttpSession session = request.getSession();
			request.setAttribute("admin", admin);
			System.out.println(admin.getId());
			session.setAttribute("AUTHUSER", admin.getName());
			rd = request.getRequestDispatcher("AdminHome.jsp");
		}
		else {
			request.setAttribute("ERROR", "Invalid Email / Password");
			rd = request.getRequestDispatcher("adminLogin.jsp");
		}
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
