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

@WebServlet("/addDept")
public class AddDepartment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rdp = request.getRequestDispatcher("dashboard.html");
		rdp.include(request, response);
		out.println("<form action = '' method = 'GET'><div class = 'container'>"
				+ "<div class = 'row mt-2'><label for='department' class='form-label'>Enter Department Name</label>"
				+ "<div class = 'col-4'><input type='text' name = 'deptName' value = '' class='form-control mt-2' > <div  class= 'col-6'>");
		out.println("<button class='btn btn-primary mt-3' type='submit'>Add Deparment</button>");
		out.println("</div></div>");
		out.println("</form>");
		String name = request.getParameter("deptName");
		Optional<String> ap = Optional.ofNullable(name);
		if (!ap.get().equals("null")) {
			DepartmentModel model = new DepartmentModel();
			model.setName(name);
			DepartService ds = new DepartServiceImp();
			boolean result = ds.isAdded(model);
			if (result) {
				out.println("<html><body><script>");
				out.println("alert('Successfully added Department...'); window.location = 'dashboard.html'");
				out.println("</script></body></html>");
			} else {
				out.println("<html><body><script>");
				out.println("alert('Enter Valid Data'); window.location = 'dashboard.html'");
				out.println("</script></body></html>");
			}
		} else {
			out.println("<html><body><script>");
			out.println("alert('Value is null'); window.location = 'dashboard.html'");
			out.println("</script></body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
