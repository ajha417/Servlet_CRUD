package com.amit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amit.beans.Emp;
import com.amit.dao.EmployeeDao;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<a href='index.html'>Add new Employee</a>");
		out.println("<h1>Employees List</h1>");
		List<Emp> list = EmployeeDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th>"
				+ "<th>Edit</th><th>Delete</th>");
		for(Emp e:list) {
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
					+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
			
		}
		out.print("</table>");
		out.close();
	}
	
}
