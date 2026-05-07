package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

@WebServlet("/ViewDept")
public class ViewDepartment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("dashboard.html");
		rs.include(request, response);
		out.println("<div class= 'container'>");
		out.println("<table class = ' text-center container p-5 table  table-bordered mt-2 table-hover'>");
		out.println("<thead class = ' table-primary'>");
		out.println("<tr>");
		out.println("<td>Sr No.</td>");
		out.println("<td>Department Name</td>");
		out.println("<td>Update Department</td>");
		out.println("<td>Delete Department</td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		DepartService ds = new DepartServiceImp();
		Optional<List<DepartmentModel>> op = ds.getDepartment();
		if (!(op.get().isEmpty())) {
			int count = 0;
			for (DepartmentModel dm : op.get()) {
				out.println("<tr>");
				out.println("<td>" + (++count) + "</td>");
				out.println("<td>" + dm.getName() + "</td>");
				out.println("<td> <a href='updateDept?id=" + dm.getId()
						+ "' > <img src='Images/pen.png' alt='not found' width='30'> </a></td>");
				out.println("<td><a onclick = 'return confirmToDelDepartment()' href = 'deptDelete?id=" + dm.getId()
						+ "'> <img src='Images/deleteDept.png' alt='not found' width='30'> </a></td>");
				out.println("</tr>");
			}
		} else {
			out.println("<tr> <td colspan='4'> No Record Found </td></tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
