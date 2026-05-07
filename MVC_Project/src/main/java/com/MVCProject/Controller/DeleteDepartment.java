package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.Service.DepartService;
import com.MVCProject.Service.DepartServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deptDelete")
public class DeleteDepartment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Optional<Integer> al = Optional.empty();
		try {
			al = Optional.of(Integer.parseInt(request.getParameter("id")));
		} catch (NumberFormatException ex) {
			System.out.println("Problem to convert int: " + ex);
		}
		DepartService ds = new DepartServiceImp();
		boolean result = ds.deleteDepartment(al.orElse(0));
		if (result) {
			out.println("<html><body><script>");
			out.println("alert('Department Delete'); window.location = 'dashboard.html'");
			out.println("</script></body></html>");
		} else {
			out.println("<html><body><script>");
			out.println("alert('Problem to delete Department'); window.location = 'dashboard.html'");
			out.println("</script></body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
