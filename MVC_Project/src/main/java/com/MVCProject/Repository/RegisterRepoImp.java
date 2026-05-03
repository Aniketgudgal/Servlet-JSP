package com.MVCProject.Repository;

import java.sql.SQLException;

import com.MVCProject.Model.User;

public class RegisterRepoImp extends DBConfig implements RegisterRepo {

	@Override
	public boolean isRegister(User u) {
		try {
			pst = conn.prepareStatement("insert into user values('0',?,?,?,?,?)");
			pst.setString(1, u.getFName());
			pst.setString(2, u.getLName());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getContact());
			pst.setString(5, u.getPassword());
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Error in Repo :" + e);
			return false;
		}

	}

	@Override
	public boolean alredayRegister(User u) {
		try {
			pst = conn.prepareStatement("select * from user where email = ? and contact = ? and password = ?");
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getContact());
			pst.setString(3, u.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Exception in alredy register repo: " + e);
			return false;
		}
	}

}
