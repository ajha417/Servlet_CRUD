package com.amit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amit.beans.Emp;
import com.amit.dao.EmployeeDao;

public class EditServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		Emp emp = EmployeeDao.getEmployee(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+emp.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+emp.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+emp.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+emp.getEmail()+"'/></td></tr>"); 
		 out.print("<tr><td>Country:</td><td>");  
	     out.print("<select name='country' style='width:150px'>");  
	     out.print("<option>India</option>");  
	     out.print("<option>USA</option>");  
	     out.print("<option>UK</option>");  
	     out.print("<option>Other</option>");  
	     out.print("</select>");  
	     out.print("</td></tr>");  
	     out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	     out.print("</table>");  
	     out.print("</form>");  
	          
	     out.close();  
 	}

}
