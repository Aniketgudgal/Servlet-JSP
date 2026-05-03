package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.Model.User;
import com.MVCProject.Service.RegisterUserImp;
import com.MVCProject.Service.RegisterUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		User u = new User();
		u.setFName(fname);
		u.setLName(lname);
		u.setEmail(email);
		u.setContact(contact);
		u.setPassword(password);
		RegisterUserService rs = new RegisterUserImp();
		boolean result = rs.isRegister(u);
		if (result) {
			out.println("<html><body>");
			out.println("<script>");
			out.println("alert('Register successful');");
			out.println("window.location = 'login.html';");
			out.println("</script>");
			out.println("</body></html>");

		} else {
			out.println("<html><body>");
			out.println("<script>");
			out.println("alert('Invalid data');");
			out.println("window.location='Register.html';"); // redirect
			out.println("</script>");
			out.println("</body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
