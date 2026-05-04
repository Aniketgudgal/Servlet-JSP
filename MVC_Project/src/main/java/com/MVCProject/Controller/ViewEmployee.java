package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

@WebServlet("/viewEmp")
public class ViewEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService es = new EmployeeServImp();
		Optional<List<Employee>> o = es.getEmployee();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int count = 1;
		RequestDispatcher rsd = request.getRequestDispatcher("dashboard.html");
		rsd.include(request, response);
		out.println("<table class='table  table-bordered  table-hover table-striped'>");
		out.println("<thead class='table-primary'>");
		out.println("<tr>");
		out.println("<td class = 'text-center align-middle'>Sr no</td>");
		out.println("<td class = 'text-center align-middle'>First Name</td>");
		out.println("<td class = 'text-center align-middle'>Last Name</td>");
		out.println("<td class = 'text-center align-middle'>Age</td>");
		out.println("<td class = 'text-center align-middle'>Salary</td>");
		out.println("<td class = 'text-center align-middle'>Update Employee</td>");
		out.println("<td class = 'text-center align-middle'>Delete Employee</td>");
		out.println("</tr>");
		out.println("</thead>");
		List<Employee> al = o.get();
		if (!al.isEmpty()) {
			for (Employee e : al) {
				out.println("<tr>");
				out.println("<td class = 'text-center align-middle'>" + (count++) + "</td>");
				out.println("<td class = 'text-center align-middle'>" + e.getFirstName() + "</td>");
				out.println("<td class = 'text-center align-middle'>" + e.getLastName() + "</td>");
				out.println("<td class = 'text-center align-middle'>" + e.getAge() + "</td>");
				out.println("<td class = 'text-center align-middle'>" + e.getSalary() + "</td>");
				out.println(
						"<td class = 'text-center align-middle'><a href='#' ><img src='Images/updated.png' class = 'img-fluid' width = '30' alt='Image not found'></a></td>");
				out.println(
						"<td class = 'text-center align-middle'><a href='#' ><img src='Images/delete.png' class = 'img-fluid' width = '28' alt='Image not found'></a></td>");
				out.println("</tr>");
			}
		} else {
			out.println("<tr><td class = 'text-center align-middle' colspan = '7'>No Record Found</td></tr>");
		}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
