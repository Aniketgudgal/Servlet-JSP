package com.user.Service;

import com.user.Model.User;
import com.user.Repositry.UserRepo;

public class UserService {
	UserRepo repo = new UserRepo();

	public boolean register(User u) {
		return repo.register(u);
	}

	public boolean login(User u) {
		return repo.login(u);
	}
}
