package com.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteRec
 */
@WebServlet("/DeleteRec")
public class DeleteRec extends HttpServlet {
	String url= "jdbc:sqlserver://localhost:1433;databasename= clg_mgmt;";
	String usrname= "admin";
	String pass= "1234";
	String sql7= "delete from stu_rec where uname= ?;";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection(url, usrname, pass);
			PreparedStatement st1= con.prepareStatement(sql7);
			st1.setString(1, uname);
			st1.executeUpdate();
			HttpSession session= request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("AdminOpt.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
