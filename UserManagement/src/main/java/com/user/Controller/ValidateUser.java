package com.user.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validate")
public class ValidateUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RequestDispatcher req = request.getRequestDispatcher("Dashboard.html");
		if (session != null) {
			req.include(request, response);
		} else {
			response.setHeader("Cache-Control", "no-cache, no-store, must-invalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
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
