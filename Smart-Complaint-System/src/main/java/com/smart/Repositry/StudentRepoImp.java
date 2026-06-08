package com.smart.Repositry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.smart.Model.CategoryModel;
import com.smart.Model.DepartmentModel;
import com.smart.Model.StudentModel;

public class StudentRepoImp extends DBConfig implements StudentRepo {

	@Override
	public Optional<List<DepartmentModel>> getDepartment() {
		try {
			pst = conn.prepareStatement("select * from department");
			rs = pst.executeQuery();
			List<DepartmentModel> al = new ArrayList<>();
			while (rs.next()) {
				al.add(new DepartmentModel(rs.getInt(1), rs.getString(2)));
			}
			return Optional.of(al);
		} catch (SQLException e) {
			System.out.println("problem to get data department");
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<CategoryModel>> getCategory() {
		try {
			pst = conn.prepareStatement("select * from category");
			rs = pst.executeQuery();
			List<CategoryModel> al = new ArrayList<>();
			while (rs.next()) {
				al.add(new CategoryModel(rs.getInt(1), rs.getString(2)));
			}
			return Optional.of(al);
		} catch (SQLException ex) {
			System.out.println("Problem to get Data of Category: " + ex);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Object[]>> getComplaints() {
		try {
			pst = conn.prepareStatement(
					"select c.ticket_id, s.student_name, d.department_name, cg.category_name, c.priority, c.status, c.created_time from complaint c inner join student s on s.student_id = c.student_id inner join category cg on cg.category_id = c.category_id inner join department d on d.department_id = s.department_id");
			rs = pst.executeQuery();
			List<Object[]> al = new ArrayList<>();
			while (rs.next()) {
				al.add(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7) });
			}
			return Optional.of(al);
		} catch (SQLException ex) {
			System.out.println("Problem to get Complaints: " + ex);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<StudentModel>> getStudent() {
		try {
			pst = conn.prepareStatement("select * from student");
			rs = pst.executeQuery();
			List<StudentModel> al = new ArrayList<>();
			while (rs.next()) {
				al.add(new StudentModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			return Optional.of(al);
		} catch (SQLException ex) {
			System.out.println("problem to get student data: " + ex);
		}
		return Optional.empty();
	}

}
