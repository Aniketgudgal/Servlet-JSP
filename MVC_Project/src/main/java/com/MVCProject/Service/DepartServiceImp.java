package com.MVCProject.Service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Repository.DepartRepo;
import com.MVCProject.Repository.DepartRepoImp;

public class DepartServiceImp implements DepartService {
	DepartRepo dp = new DepartRepoImp();

	@Override
	public boolean isAdded(DepartmentModel model) {
		return model.getName().length() < 2 ? false : dp.isAdded(model);
	}

	@Override
	public Optional<List<DepartmentModel>> getDepartment() {
		return dp.getDepartment();
	}

	@Override
	public boolean deleteDepartment(int id) {
		return dp.deleteDepartment(id);
	}

	@Override
	public Optional<DepartmentModel> getDepartment(int id) {

		return dp.getDepartment(id);
	}

	@Override
	public boolean isUpdated(DepartmentModel model) {
		return dp.isUpdated(model);
	}

}
