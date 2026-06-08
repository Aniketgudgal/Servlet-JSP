package com.smart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dataAdd")
public class AddStudentData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Optional<Integer> student_id = Optional.empty();
		Optional<Integer> department_id = Optional.empty();
		Optional<Integer> category_id = Optional.empty();
		String priority = request.getParameter("priority");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		try {
			student_id = Optional.of(null);
		} catch (Exception ex) {
			System.out.println("Problem to convert: " + ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
