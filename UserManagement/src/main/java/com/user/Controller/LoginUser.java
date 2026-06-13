package com.user.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.user.Model.User;
import com.user.Service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		if (email.length() > 0 && pass.length() > 0) {
			UserService us = new UserService();
			User u = new User();
			u.setEmail(email);
			u.setPassword(pass);
			if (us.login(u)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				out.println("<html><body>");
				out.println("<script>");
				out.println("alert('Login successful');");
				out.println("window.location = 'Dashboard.html';");
				out.println("</script>");
				out.println("</body></html>");
			} else {
				out.println("<html><body>");
				out.println("<script>");
				out.println("alert('Enter the Valid Data');");
				out.println("window.location = 'login.html';");
				out.println("</script>");
				out.println("</body></html>");
			}
		} else {
			out.println("<html><body>");
			out.println("<script>");
			out.println("alert('Enter the Valid Data');");
			out.println("window.location = 'login.html';");
			out.println("</script>");
			out.println("</body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
