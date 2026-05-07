package com.aniket;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class Addition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int firstNum = Integer.parseInt(request.getParameter("first"));
		int secondNum = Integer.parseInt(request.getParameter("second"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Addition is: " + (firstNum + secondNum) + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
