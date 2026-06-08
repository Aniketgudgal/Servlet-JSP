package com.LoginApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String contact = request.getParameter("contact");
		System.out.println(contact);
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "Pass@12345");

			if (conn != null) {

				PreparedStatement check = conn
						.prepareStatement("SELECT * FROM user WHERE lname=? and fname = ? or email=?");
				check.setString(1, lname);
				check.setString(2, fname);
				check.setString(3, email);

				ResultSet rs = check.executeQuery();

				if (rs.next()) {
					out.println("<h1>User already exists</h1>");
				} else {

					PreparedStatement ps = conn.prepareStatement(
							"INSERT INTO user(fname,lname, email, contact, password) VALUES(?,?,?,?,?)");

					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, email);
					ps.setString(4, contact);
					ps.setString(5, pass);

					int result = ps.executeUpdate();

					if (result > 0) {
						response.sendRedirect("data.html");
					} else {
						out.println("<p>Problem while registering</p>");
					}
				}
				rs.close();
				check.close();
				conn.close();

			} else {
				out.println("<p>Database connection failed</p>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("<p>Error: " + e.getMessage() + "</p>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("register.html");
	}
}