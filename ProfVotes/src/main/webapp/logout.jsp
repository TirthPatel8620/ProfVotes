<%
	request.getSession().setAttribute("AUTHUSER", null);
request.getSession().invalidate();
response.sendRedirect("index.jsp");

%>