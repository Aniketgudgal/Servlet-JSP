package com.user.Repositry;

import com.user.Model.User;

public class UserRepo extends DBConfig {

	public boolean register(User u) {
		try {
			pst = con.prepareStatement("insert into Student values('0',?,?,?,?)");
			pst.setString(1, u.getFName());
			pst.setString(2, u.getLName());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			int result = pst.executeUpdate();
			return result > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Problem to register: " + ex);
		}
		return false;
	}

	public boolean login(User u) {
		try {
			pst = con.prepareStatement("select * from student where email = ? && password = ?");
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			rs = pst.executeQuery();
			return rs.next() ? true : false;
		} catch (Exception ex) {
			System.out.println("Problem to login: " + ex);
		}
		return false;
	}
}
