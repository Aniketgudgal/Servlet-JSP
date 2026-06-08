package com.smart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.smart.Service.StudentService;
import com.smart.Service.StudentServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewComplaints")
public class ViewComplaints extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rst = request.getRequestDispatcher("Dashboard.html");
		rst.include(request, response);
		out.println("<div class = 'container'>");
		out.println("<table class = 'table table-rounded'>");
		out.println("<thead class = 'table-primary'>");
		out.println("<tr>");
		out.println("<td>Ticket ID</td>");
		out.println("<td>Student Name</td>");
		out.println("<td>Department</td>");
		out.println("<td>Issue Category</td>");
		out.println("<td>Priority</td>");
		out.println("<td>Status</td>");
		out.println("<td>Created Time</td>");
		out.println("<td colspan = '2'>Action</td>");
		out.println("</tr>");
		out.println("</thead>");

		out.println("<tbody>");
		StudentService ss = new StudentServiceImp();
		Optional<List<Object[]>> o = ss.getComplaints();
		if (o.isPresent()) {
			List<Object[]> al = o.get();
			for (Object[] cm : al) {
				out.println("<tr>");
				for (Object a : cm) {
					out.println("<td>" + a + "</td>");
				}
				out.println("<td><a class= 'btn btn-success' href = 'editComp?id='" + cm[0] + "'>Edit</a></td>");
				out.println("<td><a class = 'btn btn-primary' href = 'deleteComp?id='" + cm[0] + "'>Delete</a></td>");
				out.println("</tr>");
			}
		} else {
			out.println("<tr><td colspan = '9'>No Data Present</td></tr>");
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
