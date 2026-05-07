package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.Employee;
import com.MVCProject.Service.EmployeeServImp;
import com.MVCProject.Service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBEmp")
public class SearchBarEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String val = request.getParameter("data");
		EmployeeService es = new EmployeeServImp();
		Optional<List<Employee>> op = es.getEmployee(val.trim());
		if (!op.isEmpty()) {
			int count = 1;
			String result = "";
			if (!op.get().isEmpty()) {
				for (Employee e : op.get()) {
					result += "<tr>";
					result += "<td class = 'text-center align-middle'>" + (count++) + "</td>";
					result += "<td class = 'text-center align-middle'>" + e.getFirstName() + "</td>";
					result += "<td class = 'text-center align-middle'>" + e.getLastName() + "</td>";
					result += "<td class = 'text-center align-middle'>" + e.getAge() + "</td>";
					result += "<td class = 'text-center align-middle'>" + e.getSalary() + "</td>";
					result += "<td class = 'text-center align-middle'><a href='updateEmployee?id=" + e.getId()
							+ "'><img src='Images/updated.png' class = 'img-fluid' width = '30' alt='Image not found'></a></td>";
					result += "<td class = 'text-center align-middle'><a onclick='return confirmDelete()' href='delEmp?id="
							+ e.getId()
							+ "' ><img src='Images/delete.png' class = 'img-fluid' width = '28' alt='Image not found'></a></td></tr>";
				}
				out.println(result);
			} else {
				out.println("<tr><td class = 'text-center align-middle' colspan = '7'>No Record Found</td></tr>");
			}
		} else {
			System.out.println("Problem to get data");
			out.println("<tr><td class = 'text-center align-middle' colspan = '7'>No Record Found</td></tr>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
