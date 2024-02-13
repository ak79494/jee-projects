package com.arun.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceClient;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {   
		         
		        response.setContentType("text/html");  
		        PrintWriter writer=response.getWriter();  
		          
		        String name=request.getParameter("name");  
		        String password=request.getParameter("password");  
		        String email=request.getParameter("email");  
		        String country=request.getParameter("country");  
		          
		        Emp e=new Emp();  
		        e.setName(name);  
		        e.setPassword(password);  
		        e.setEmail(email);  
		        e.setCountry(country);  
		          
		        int status=EmpDao.save(e);  
		        if(status>0){  
		           writer.print("<p>Record saved successfully!</p>");  
		            request.getRequestDispatcher("index.html").include(request, response);  
		        }else{  
		           writer.print("Sorry! unable to save record");  
		        }     
		       
		    } 	  
}
