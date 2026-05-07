package com.LoginApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root",
						"Aniket@5867");
				if (con != null) {
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					PreparedStatement stmt = con
							.prepareStatement("select * from userregister where email = ? and password = ?");
					stmt.setString(1, email);
					stmt.setString(2, password);
					ResultSet val = stmt.executeQuery();
					if (val.next()) {
						out.println("<h1>Login Success</h>");
						System.out.println("database connected");
					} else {
						RequestDispatcher rts = request.getRequestDispatcher("register.html");
						System.out.println("Forward to register page");
						rts.forward(request, response);
					}
				} else {
					out.println("Problem to connection");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			out.println("Class Loading Exception " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
