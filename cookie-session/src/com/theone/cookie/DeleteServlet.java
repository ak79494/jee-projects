package com.theone.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			Cookie cookie = cookies[0];
			String user = cookie.getValue();
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			writer.print("<h3> This is a DeleteServlet, destroyed cookie from the browser logout Mr. "+user+"</h3>");
			writer.print("<h3> Please Login first</h3>");
		
		}
	}

}
