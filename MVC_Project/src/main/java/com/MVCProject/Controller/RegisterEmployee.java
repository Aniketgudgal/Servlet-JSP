package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerEmp")
public class RegisterEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rspt = request.getRequestDispatcher("dashboard.html");
		rspt.include(request, response);
		out.println("<div class=\"container mt-3\">\r\n" + "</form action=\"\"><div class=\"row\">\r\n"
				+ "  <div class=\"col\">\r\n"
				+ "    <input type=\"text\" class=\"form-control\" value=\"\" name=\"firstName\"   placeholder=\"First name\" aria-label=\"First name\">\r\n"
				+ "  </div>\r\n" + "  <div class=\"col\">\r\n"
				+ "    <input type=\"text\" class=\"form-control\" value=\"\"  name=\"lastName\"  placeholder=\"Last name\" aria-label=\"Last name\">\r\n"
				+ "  </div>\r\n" + "</div>" + "<div class=\"row mt-3\">\r\n" + "  <div class=\"col\">\r\n"
				+ "    <input type=\"text\" class=\"form-control\" name=\"salary\" placeholder=\"Salary\" aria-label=\"salary\">\r\n"
				+ "  </div>\r\n" + "  <div class=\"col\">\r\n"
				+ "    <input type=\"text\" class=\"form-control\" value=\"\" placeholder=\"Age\" name=\"age\" aria-label=\"age\">\r\n"
				+ "  </div>\r\n" + "</div>" + " <button type=\"button\" class=\"btn mt-3 btn-primary\">Primary</button>"
				+ "</form></div>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
