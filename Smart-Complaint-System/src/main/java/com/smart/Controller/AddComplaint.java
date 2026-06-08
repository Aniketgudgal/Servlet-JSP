package com.smart.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.smart.Model.CategoryModel;
import com.smart.Model.DepartmentModel;
import com.smart.Model.StudentModel;
import com.smart.Repositry.StudentRepo;
import com.smart.Repositry.StudentRepoImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addComplaint")
public class AddComplaint extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rst = request.getRequestDispatcher("Dashboard.html");
		rst.include(request, response);
		out.println("<div class = 'container mt-3'>");
		// row
		out.println("<form action = 'dataAdd' method = 'GET'>");
		out.println("<div class = 'row mt-2'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Student Name</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<select class= 'form-select' name = 'student_id'>");
		out.println("<option selected>Select Student Name</option>");
		StudentRepo sp = new StudentRepoImp();
		Optional<List<StudentModel>> opm = sp.getStudent();
		if (opm.isPresent()) {
			List<StudentModel> al = opm.get();
			for (StudentModel sm : al) {
				out.println("<option value = '" + sm.getId() + "'>" + sm.getName() + "</option>");
			}
		} else {
			out.println("<option>No Data Present</option>");
		}
		out.println("</select>");
		out.println("</div>");
		out.println("</div>");

		// second row
		out.println("<div class = 'row mt-3'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Department</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<select class= 'form-select' name = 'department_id'>");
		out.println("<option selected>Select Department</option>");
		Optional<List<DepartmentModel>> o = sp.getDepartment();
		if (o.isPresent()) {
			List<DepartmentModel> al = o.get();
			for (DepartmentModel dm : al) {
				out.println("<option value = '" + dm.getId() + "'>" + dm.getName() + "</option>");
			}
		} else {
			out.println("<option>No Data Present</option>");
		}
		out.println("</select>");
		out.println("</div>");
		out.println("</div>");

		// row 3
		out.println("<div class = 'row mt-3'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Issue Category</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<select class= 'form-select' name = 'category_id'>");
		out.println("<option selected>Select Category</option>");
		Optional<List<CategoryModel>> op = sp.getCategory();
		if (op.isPresent()) {
			List<CategoryModel> al = op.get();
			for (CategoryModel dm : al) {
				out.println("<option value = '" + dm.getId() + "'>" + dm.getName() + "</option>");
			}
		} else {
			out.println("<option>No Data Present</option>");
		}
		out.println("</select>");

		out.println("</div>");
		out.println("</div>");

		// row 4
		out.println("<div class = 'row mt-3'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Priority</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<select class = 'form-select' name = 'priority'>");
		out.println("<option selected>Select Priority</option>");
		out.println("<option value = 'Low'>Low</option>");
		out.println("<option value = 'Medium'>Medium</option>");
		out.println("<option value = 'High'>High</option>");

		out.println("</select>");
		out.println("</div>");
		out.println("</div>");

		// row 5
		out.println("<div class = 'row mt-3'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Description</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<input class = 'form-control' type = 'text' name ='description' value=''/>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class = 'row mt-3'>");

		out.println("<div class = 'col-6'>");
		out.println("<lable>Status</lable>");
		out.println("</div>");

		out.println("<div class = 'col-6'>");
		out.println("<input class = 'form-control' type = 'hidden' name ='status' value='Open'/> <span>Open</span>");
		out.println("</div>");
		out.println("</div>");

		// row 6

		//
		out.println("<button type = 'submit' class =' mt-4 btn btn-primary'>Submit</button>");
		out.println("<input type = 'reset' class = ' mt-4 me-3 border btn btn-primary-dark' value= 'Reset'>");
		out.println("</form>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
