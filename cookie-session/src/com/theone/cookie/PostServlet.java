package com.theone.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    Cookie[] cookies = request.getCookies();
	    if(cookies!=null && cookies.length>0) {
	    	 Cookie cookie = cookies[0];
	    	  String user = cookie.getValue();
	    	  writer.print("<h3>This is  a PostServlet class Mr. "+user+"</h3>");
	    	  
	    }else{
	    	writer.print("<h3> Please login first</h3>");
	    }
	  
	    
	    
	}

}
