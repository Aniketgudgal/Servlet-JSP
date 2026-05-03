package com.MVCProject.Repository;

import com.MVCProject.Model.User;

public interface RegisterRepo {
	boolean isRegister(User u);

	boolean alredayRegister(User u);
}
