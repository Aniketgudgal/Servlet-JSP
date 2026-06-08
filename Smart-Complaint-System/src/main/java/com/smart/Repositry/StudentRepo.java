package com.smart.Repositry;

import java.util.List;
import java.util.Optional;

import com.smart.Model.CategoryModel;
import com.smart.Model.DepartmentModel;
import com.smart.Model.StudentModel;

public interface StudentRepo {
	Optional<List<DepartmentModel>> getDepartment();

	Optional<List<CategoryModel>> getCategory();

	Optional<List<Object[]>> getComplaints();

	Optional<List<StudentModel>> getStudent();
}
