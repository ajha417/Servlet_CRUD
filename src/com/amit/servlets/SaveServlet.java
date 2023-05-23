package com.amit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amit.beans.Emp;
import com.amit.dao.EmployeeDao;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Emp emp = new Emp();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		int status = EmployeeDao.save(emp);
		if(status > 0)
		{
			out.print("Employee added successfully!!!");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		else {
			out.print("sorry! unable to save the record");
		}
		out.close();
	}

}
