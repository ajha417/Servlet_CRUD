package com.amit.dao;

import java.sql.*;
import java.util.*;

import com.amit.beans.Emp;
public class EmployeeDao {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static int save(Emp e) {
		int status = 0;
		try {
			String query = "insert into user_of values(?,?,?,?,?)";
			Connection conn = EmployeeDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, 34);
			statement.setString(2, e.getName());
			statement.setString(3, e.getPassword());
			statement.setString(4, e.getEmail());
			statement.setString(5, e.getCountry());
			
			status = statement.executeUpdate();
			conn.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	public static int update(Emp e) {
		int status = 0;
		try {
			
			String query = "update user_of set name=?,password=?,email=?,country=? where id=?";
			Connection conn = EmployeeDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, e.getName());
			statement.setString(2, e.getPassword());
			statement.setString(3, e.getEmail());
			statement.setString(4, e.getCountry());
			statement.setInt(5, e.getId());
			
			status = statement.executeUpdate();
			conn.close();
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		try 
		{
			String  query = "delete from user_of where id=?";
			Connection conn = EmployeeDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			status = statement.executeUpdate();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Emp getEmployee(int id) {
		Emp e = new Emp();
		try {
			String query = "select * from user_of where id=?";
			Connection conn = EmployeeDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			conn.close();
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
		
	}
	
	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			String query = "select * from user_of";
			Connection conn = EmployeeDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setCountry(rs.getString(4));
				list.add(emp);
			}
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
