package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.Model.Employee;
import com.MVCProject.Service.EmployeeServImp;
import com.MVCProject.Service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class UpdateEmpInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rest = request.getRequestDispatcher("dashboard.html");
		rest.include(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeService se = new EmployeeServImp();
		Employee e = se.getEmployee(id).get();
		out.println("<div class= 'container p-2'><form action = 'uptDetailsEmp' method = 'POST'>");
		out.println("<div class='mb-6'" + "    <label for='updateName' class='form-label'>First Name</label>"
				+ "    <input type='text' name = 'firstName' value = '" + e.getFirstName()
				+ "' class='form-control mt-2' id='exampleInputEmail1' aria-describedby='emailHelp'>" + "  </div>");
		out.println("<div class='mb-6 mt-2'>" + "<label for='lname' class='form-label'>Last Name</label>"
				+ "    <input type='text' name= 'lastName' value='" + e.getLastName() + "'  class='form-control mt-2' >"
				+ "</div>");
		out.println("<div class='mb-6 mt-2'>" + "<label for='age' class='form-label'>Age</label>"
				+ "    <input type='text' name = 'age' value='" + e.getAge() + "' class='form-control mt-2' >"
				+ "</div>");
		out.println("<input type = 'hidden' name = 'id' class = 'form-control' value = '" + e.getId() + "'>");
		out.println("<div class='mb-6 mt-2'>" + "<label for='salary' class='form-label'>Last Name</label>"
				+ "    <input type='text' name = 'salary' value= '" + e.getSalary() + "' class='form-control mt-2' >"
				+ "</div>");
		out.println("<button type='submit' class='btn btn-primary mt-4'>Submit</button></form></div>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
