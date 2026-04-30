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
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Messages.getString("register.0")); //$NON-NLS-1$
		PrintWriter out = response.getWriter();
		try {
			Class.forName(Messages.getString("register.1")); //$NON-NLS-1$
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println(Messages.getString("register.2")); //$NON-NLS-1$
		}
		try {
			String name = request.getParameter(Messages.getString("register.3")); //$NON-NLS-1$
			String email = request.getParameter(Messages.getString("register.4")); //$NON-NLS-1$
			String pass = request.getParameter(Messages.getString("register.5")); //$NON-NLS-1$
			Connection conn = DriverManager.getConnection(Messages.getString("register.6"), Messages.getString("register.7"), Messages.getString("register.8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (conn != null) {
				PreparedStatement check = conn
						.prepareStatement(Messages.getString("register.9")); //$NON-NLS-1$
				check.setString(1, name);
				check.setString(2, email);
				ResultSet rs = check.executeQuery();
				if (rs.next()) {
					out.println(Messages.getString("register.10")); //$NON-NLS-1$
				} else {
					PreparedStatement ps = conn.prepareStatement(Messages.getString("register.11")); //$NON-NLS-1$
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, pass);
					int result = ps.executeUpdate();
					if (result > 0) {
						out.println(Messages.getString("register.12")); //$NON-NLS-1$
					} else {
						out.println(Messages.getString("register.13")); //$NON-NLS-1$
					}
				}
			} else {
				out.println(Messages.getString("register.14")); //$NON-NLS-1$
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println(Messages.getString("register.15")); //$NON-NLS-1$
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
