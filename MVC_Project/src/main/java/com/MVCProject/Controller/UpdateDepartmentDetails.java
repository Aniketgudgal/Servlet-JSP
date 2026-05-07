package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Service.DepartService;
import com.MVCProject.Service.DepartServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDepartmentDetails
 */
@WebServlet("/UpdateDepartDetails")
public class UpdateDepartmentDetails extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rst = request.getRequestDispatcher("dashboard.html");
		// rst.include(request, response);
		String idString = request.getParameter("deptId");
		Optional<Integer> id = Optional.empty();
		try {
			id = Optional.of(Integer.parseInt(idString.trim()));
		} catch (NumberFormatException ex) {
			System.out.println("Problem to convert string to int: " + ex);
		}
		if (!id.isEmpty()) {
			DepartmentModel dm = new DepartmentModel();
			dm.setName(request.getParameter("deptName"));
			dm.setId(id.get());
			DepartService ds = new DepartServiceImp();
			boolean result = ds.isUpdated(dm);
			if (result) {
				out.println("<html> <body> <script>");
				out.println("alert('Department Updated'); window.location = 'dashboard.html'");
				out.println("</script> </body></html>");
			} else {
				out.println("<html> <body> <script>");
				out.println(
						"alert(' Some thing went Wrong to Department Updated'); window.location = 'dashboard.html'");
				out.println("</script> </body></html>");
			}
		} else {
			out.println("<html> <body> <script>");
			out.println("alert('Value is Empty') window.location = 'dashboard.html'");
			out.println("</script> </body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
