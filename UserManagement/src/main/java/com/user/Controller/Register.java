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

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = new User();
		u.setFName(fName);
		u.setLName(lName);
		u.setEmail(email);
		u.setPassword(password);
		if (fName.length() > 0 && lName.length() > 0 && email.length() > 0 && password.length() > 0) {
			UserService us = new UserService();
			if (us.register(u)) {
				out.println("<html><body>");
				out.println("<script>");
				out.println("alert('Register successful');");
				out.println("window.location = 'login.html';");
				out.println("</script>");
				out.println("</body></html>");
			} else {
				out.println("<html><body>");
				out.println("<script>");
				out.println("alert('Register successful');");
				out.println("window.location = 'register.html';");
				out.println("</script>");
				out.println("</body></html>");
			}
		} else {
			out.println("<html><body>");
			out.println("<script>");
			out.println("alert('Enter Valid Data');");
			out.println("window.location = 'register.html';");
			out.println("</script>");
			out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
