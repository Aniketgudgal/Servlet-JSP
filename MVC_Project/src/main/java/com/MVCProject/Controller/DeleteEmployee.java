package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.Service.EmployeeServImp;
import com.MVCProject.Service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/delEmp")
public class DeleteEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeService es = new EmployeeServImp();
		if (es.isDeleteEmployee(id)) {
			out.println("<html> <body>");
			out.println("<script>");
			out.println("alert('Employee Deleted');");
			out.println("window.location = 'dashboard.html'");
			out.println("</script></body></html>");
		} else {
			out.println("<html> <body>");
			out.println("<script>");
			out.println("alert('Invalid data');");
			out.println("window.location = 'dashboard.html'");
			out.println("</script></body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
