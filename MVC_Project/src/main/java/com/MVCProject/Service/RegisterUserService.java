package com.MVCProject.Service;

import com.MVCProject.Model.User;

public interface RegisterUserService {
	boolean isRegister(User u);

	boolean isLogin(User u);
}
