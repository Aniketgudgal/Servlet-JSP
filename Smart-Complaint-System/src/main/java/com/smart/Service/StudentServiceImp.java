package com.smart.Service;

import java.util.List;
import java.util.Optional;

import com.smart.Model.CategoryModel;
import com.smart.Model.DepartmentModel;
import com.smart.Model.StudentModel;
import com.smart.Repositry.StudentRepo;
import com.smart.Repositry.StudentRepoImp;

public class StudentServiceImp implements StudentService {
	StudentRepo rp = new StudentRepoImp();

	@Override
	public Optional<List<DepartmentModel>> getDepartment() {
		return rp.getDepartment();
	}

	@Override
	public Optional<List<CategoryModel>> getCategory() {
		return rp.getCategory();
	}

	@Override
	public Optional<List<Object[]>> getComplaints() {
		return rp.getComplaints();
	}

	@Override
	public Optional<List<StudentModel>> getStudent() {
		return rp.getStudent();
	}

}
