package com.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String methodName = request.getMethod();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root",
					"Aniket@5867")) {
				if (cn != null) {
					String name = request.getParameter("name");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					PreparedStatement check = cn.prepareStatement(
							"select * from userregister where name = ? and email = ? and password = ?");
					check.setString(1, name);
					check.setString(2, email);
					check.setString(3, password);
					ResultSet rs = check.executeQuery();
					if (rs.next()) {
						// out.println("User is already register");
						RequestDispatcher rd = request.getRequestDispatcher("login.html");
						rd.include(request, response);
						out.println("<h1>User Alreday register please login</h1>");
					} else {
						if (name.length() > 0 && email.length() > 0 && password.length() > 0) {
							PreparedStatement stmt = cn.prepareStatement("insert into userregister values('0',?,?,?)");
							stmt.setString(1, name);
							stmt.setString(2, email);
							stmt.setString(3, password);
							int result = stmt.executeUpdate();
							if (result > 0) {
								RequestDispatcher rd = request.getRequestDispatcher("login.html");
								rd.include(request, response);
								out.println("<h1>Register success</h1>");
							} else {
								out.println("<h1> user already register</h1>");
							}
						} else {
							out.println("Enter valid data");
						}
					}

				} else {
					System.out.println("Problem to connect database");
				}
			} catch (SQLException a) {
				System.out.println("Problem to connect");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found: " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
