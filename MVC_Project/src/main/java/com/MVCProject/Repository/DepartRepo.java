package com.MVCProject.Repository;

import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;

public interface DepartRepo {
	boolean isAdded(DepartmentModel model);

	Optional<List<DepartmentModel>> getDepartment();

	boolean deleteDepartment(int id);

	Optional<DepartmentModel> getDepartment(int id);

	boolean isUpdated(DepartmentModel model);

}
