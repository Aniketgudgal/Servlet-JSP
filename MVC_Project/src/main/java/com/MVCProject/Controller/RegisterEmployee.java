package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Model.Employee;
import com.MVCProject.Service.DepartService;
import com.MVCProject.Service.DepartServiceImp;
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
				+ "    <input type='text' class='form-control' autocomplete= 'off' name='firstName' placeholder='First name'>"
				+ "  </div>" + "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='lastName' autocomplete = 'off' placeholder='Last name'>"
				+ "  </div>" + "</div>"

				+ "<div class='row mt-3'>" + "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='salary' autocomplete = 'off' placeholder='Salary'>"
				+ "  </div>" + "  <div class='col'>"
				+ "    <input type='text' class='form-control' name='age' autocomplete = 'off' placeholder='Age'>"
				+ "  </div>" + "</div>");
		out.println("<select name = 'dept'  class='mt-3 form-select' aria-label='Department'> "
				+ "<option selected>Select Department</option>");
		DepartService ds = new DepartServiceImp();
		Optional<List<DepartmentModel>> op = ds.getDepartment();
		if (!(op.get().isEmpty())) {
			for (DepartmentModel dm : op.get()) {
				out.println("<option value='" + dm.getId() + "'>" + dm.getName() + "</option>");
			}
		}
		out.println("</select>");
		out.println(
				"<button type='submit' onclick = 'return confirmToAddEmp()' name = 's' class='btn mt-3 btn-primary'>Register</button>"
						+ "</div></form>");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Optional<Integer> salary = Optional.empty();
		String ageStr = request.getParameter("age");
		Optional<Integer> age = Optional.empty();
		if (ageStr != null && !ageStr.isEmpty()) {
			try {
				age = Optional.of(Integer.parseInt(ageStr.trim()));
			} catch (NumberFormatException e) {
				System.out.println("Invalid age");
			}
		}
		String salaryString = request.getParameter("salary");
		if (salaryString != null && !salaryString.isEmpty()) {
			try {
				salary = Optional.of(Integer.parseInt(salaryString.trim()));
			} catch (NumberFormatException ex) {
				System.out.println("Exception to convert number :" + ex);
			}
		}
		String deptString = request.getParameter("dept");
		System.out.println(deptString);
		Optional<Integer> dept = Optional.empty();
		if (deptString != null && !deptString.isEmpty()) {
			try {
				dept = Optional.of(Integer.parseInt(deptString.trim()));
			} catch (NumberFormatException ex) {
				System.out.println("Exception in register: " + ex);
			}
		}
		System.out.println(dept.get());
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary.orElse(0));
		e.setAge(age.orElse(0));
		e.setDeptId(dept.orElse(0));
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
