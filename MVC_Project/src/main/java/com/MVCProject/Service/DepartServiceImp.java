package com.MVCProject.Service;

import com.MVCProject.Model.DepartmentModel;
import com.MVCProject.Repository.DepartRepo;
import com.MVCProject.Repository.DepartRepoImp;

public class DepartServiceImp implements DepartService {
	DepartRepo dp = new DepartRepoImp();

	@Override
	public boolean isAdded(DepartmentModel model) {
		return model.getName().length() < 2 ? false : dp.isAdded(model);
	}

}
