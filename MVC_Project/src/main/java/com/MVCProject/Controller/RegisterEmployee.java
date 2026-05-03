package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.Model.Employee;
import com.MVCProject.Service.EmployeeServImp;
import com.MVCProject.Service.EmployeeService;

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
		out.println("<form action='' method='post'>" + "<div class='container mt-3'>"

				+ "<div class='row'>" + "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='firstName' placeholder='First name'>" + "  </div>"
				+ "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='lastName' placeholder='Last name'>" + "  </div>"
				+ "</div>"

				+ "<div class='row mt-3'>" + "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='salary' placeholder='Salary'>" + "  </div>"
				+ "  <div class='col'>" + "    <input type='text' class='form-control' name='age' placeholder='Age'>"
				+ "  </div>" + "</div>"

				+ "<button type='submit' name = 's' class='btn mt-3 btn-primary'>Submit</button>"

				+ "</div></form>");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Optional<Integer> salary = Optional.empty();
		Optional<Integer> age = Optional.empty();
		try {
			salary = Optional.of(Integer.parseInt(request.getParameter("salary")));
			age = Optional.of(Integer.parseInt(request.getParameter("age")));
		} catch (NumberFormatException ex) {
			System.out.println("Exception to convert number :" + ex);
		}
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary.orElse(0));
		e.setAge(age.orElse(0));
		EmployeeService es = new EmployeeServImp();
		boolean result = es.isAddEmp(e);
		if (result) {
			out.println("<html><body>" + "<script> "
					+ "alert('Employee Added Successfully'); window.location = 'dashboard.html' " + "</script>"
					+ "</body></html>");
		} else {
			out.println("<html><body>" + "<script> "
					+ "alert('Problem to Add Employee'); window.location = 'dashboard.html " + "</script>"
					+ "</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
