package com.MVCProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Service.DepartService;
import com.MVCProject.Service.DepartServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAjaxDepartment
 */
@WebServlet("/searchDept")
public class SearchAjaxDepartment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String searchStr = request.getParameter("name");
		DepartService ds = new DepartServiceImp();
		Optional<List<DepartmentModel>> ls = ds.getDepartment(searchStr);
		if (ls.isPresent() && (!ls.get().isEmpty())) {
			int count = 1;
			for (DepartmentModel dm : ls.get()) {
				out.println("<tr>");
				out.println("<td>" + (count++) + "</td>");
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
