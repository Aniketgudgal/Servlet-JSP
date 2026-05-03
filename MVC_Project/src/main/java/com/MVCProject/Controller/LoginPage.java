package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.Model.User;
import com.MVCProject.Service.RegisterUserImp;
import com.MVCProject.Service.RegisterUserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User u = new User();
		u.setEmail(email);
		u.setPassword(pass);
		RegisterUserService rs = new RegisterUserImp();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (rs.isLogin(u)) {
			RequestDispatcher rst = request.getRequestDispatcher("dashboard.html");
			rst.forward(request, response);
		} else {
			out.println("<html><body>" + "<script> " + "alert('Invalid User'); window.location = 'login.html' "
					+ "</script>" + "</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
