package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Service.DepartService;
import com.MVCProject.Service.DepartServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateDept")
public class UpdateDepartment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rst = request.getRequestDispatcher("dashboard.html");
		rst.include(request, response);
		DepartService ds = new DepartServiceImp();
		Optional<DepartmentModel> d = ds.getDepartment(Integer.parseInt(request.getParameter("id")));
		out.println("<div class = 'container mt-3'>");
		out.println("<form action = 'UpdateDepartDetails' method = 'GET'>");
		out.println("<label for='inputPassword5' class='form-label'>Department Name</label>");
		out.println("<input type = 'hidden' name = 'deptId' value = '" + d.get().getId() + "'>");
		out.println("<input type='text'class='form-control col-6' autocomplete = 'off' name= 'deptName' value = '"
				+ d.get().getName() + "'><div class = 'col-12'>");
		out.println(
				"<button onclick = 'return sureToUpdateDept()' class='btn btn-primary mt-3'  type='submit'>Update</button>");
		out.println("<a class = 'btn btn-primary mt-3 me-4 ' href = 'ViewDept' >View Department</a>");
		out.println("</form></div>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
