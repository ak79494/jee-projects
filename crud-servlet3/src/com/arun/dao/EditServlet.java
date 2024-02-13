package com.arun.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arun.dao.Emp;
import com.arun.dao.EmpDao;

public class EditServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {  
	            
	        response.setContentType("text/html");  
	        PrintWriter writer=response.getWriter();  
	        writer.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        Emp e=EmpDao.getEmployeeById(id);  
	          
	        writer.print("<form action='EditServlet2' method='post'>");  
	        writer.print("<table>");  
	        writer.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"/></td></tr>");  
	        writer.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
	        writer.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"/>  </td></tr>");  
	        writer.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
	        writer.print("<tr><td>Country:</td><td>");  
	        writer.print("<select name='country' style='width:150px'>");  
	        writer.print("<option>India</option>");  
	        writer.print("<option>USA</option>");  
	        writer.print("<option>Other</option>");  
	        writer.print("</select>");  
	        writer.print("</td></tr>");  
	        writer.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        writer.print("</table>");  
	        writer.print("</form>");  
	          
	       writer.close();  
	    }  
}
