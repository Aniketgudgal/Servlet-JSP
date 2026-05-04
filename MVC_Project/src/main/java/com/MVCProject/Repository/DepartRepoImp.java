package com.MVCProject.Repository;

import java.sql.SQLException;

import com.MVCProject.Model.DepartmentModel;

public class DepartRepoImp extends DBConfig implements DepartRepo {

	@Override
	public boolean isAdded(DepartmentModel model) {
		try {
			pst = conn.prepareStatement("insert into department value('0',?)");
			pst.setString(1, model.getName());
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException ex) {
			System.out.println("Repo Exception :" + ex);
			return false;
		}
	}

}
