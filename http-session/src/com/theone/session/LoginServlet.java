package com.theone.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String user = request.getParameter("user");
		
		HttpSession session = request.getSession(true); // new session created and it is inteface take implement object beaceuse interface not create object
		session.setAttribute("user", user);
		writer.print("<h3>login success"+user+"</h3>");
		writer.print("<hr><br><a href='PostServlet'>Post</a>");
		writer.print("<hr><br><a href='DeleteServlet'>Logout</a>");
		
		
	}

}
