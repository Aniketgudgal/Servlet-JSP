package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.Model.Employee;
import com.MVCProject.Service.EmployeeServImp;
import com.MVCProject.Service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/uptDetailsEmp")
public class UpdateDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int id = Integer.parseInt((request.getParameter("id").trim()));
		int age = Integer.parseInt(request.getParameter("age").trim());
		int salary = Integer.parseInt(request.getParameter("salary").trim());
		Employee newData = new Employee(id, firstName, lastName, salary, age);
		EmployeeService s = new EmployeeServImp();
		boolean result = s.updateEmpInfo(newData);
		if (result) {
			out.println("<html><body>" + "<script> " + "alert('Updated data'); window.location = 'dashboard.html' "
					+ "</script>" + "</body></html>");
		} else {
			out.println("<html><body>" + "<script> " + "alert('Problem to update'); window.location = 'dashboard.html' "
					+ "</script>" + "</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
