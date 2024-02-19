package com.theone.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false); // call old sesssion
		if(session!=null) {
			String user = (String) session.getValue("user");
			session.invalidate(); // destroyed session
			writer.print("<h3>This ia a DeleteServlet, destroyed session logout Mr. "+user+"</h3>");
		}else{
			writer.print("<h3>Please Login First</a>");
		}
	}

}
