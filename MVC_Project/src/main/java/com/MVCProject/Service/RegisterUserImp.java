package com.MVCProject.Service;

import com.MVCProject.Model.User;
import com.MVCProject.Repository.RegisterRepo;
import com.MVCProject.Repository.RegisterRepoImp;

public class RegisterUserImp implements RegisterUserService {
	RegisterRepo rr = new RegisterRepoImp();

	@Override
	public boolean isRegister(User u) {
		if (u.getContact().length() == 0 || u.getEmail().length() == 0 || u.getFName().length() == 0
				|| u.getLName().length() == 0 || u.getPassword().length() == 0) {
			return false;
		}
		{
			if (rr.alredayRegister(u)) {
				return true;
			} else {
				return rr.isRegister(u);
			}
		}
	}

	@Override
	public boolean isLogin(User u) {
		return rr.isLogin(u) ? true : false;
	}

}
