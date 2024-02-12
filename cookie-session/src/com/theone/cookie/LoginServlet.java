package com.theone.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    String user = request.getParameter("user");
	 
	    Cookie cookie = new Cookie("user", user);
	    response.addCookie(cookie);
	    
	    writer.print("<h3>login success "+user+"</h3>");
	    writer.print("<hr><br><a href='PostServlet'>Post</a>");
	    writer.print("<hr><br><a href='DeleteServlet'>Logout</a>");
	    	
		
	}

}
