package com.MVCProject.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<List<DepartmentModel>> getDepartment() {
		try {
			pst = conn.prepareStatement("select * from department");
			rs = pst.executeQuery();
			List<DepartmentModel> al = new ArrayList<>();
			while (rs.next()) {
				al.add(new DepartmentModel(rs.getInt(1), rs.getString(2)));
			}
			return Optional.ofNullable(al);
		} catch (SQLException ex) {
			System.out.println("Error to get department data: " + ex);
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteDepartment(int id) {
		try {
			pst = conn.prepareStatement("delete from department where deptId = ?");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException ex) {
			System.out.println("Exception to delete department: " + ex);
			return false;
		}
	}

	@Override
	public Optional<DepartmentModel> getDepartment(int id) {
		try {
			pst = conn.prepareStatement("select * from department where deptId = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				DepartmentModel d = new DepartmentModel(rs.getInt(1), rs.getString(2));
				return Optional.of(d);
			} else {
				return Optional.empty();
			}

		} catch (SQLException ex) {
			System.out.println("Exception of get department: " + ex);
		}
		return Optional.empty();
	}

	@Override
	public boolean isUpdated(DepartmentModel model) {
		try {
			pst = conn.prepareStatement("update department SET name = ? where deptId = ?");
			pst.setString(1, model.getName());
			pst.setInt(2, model.getId());
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException ex) {
			System.out.println("Problem to Update Department: " + ex);
		}
		return false;
	}

	@Override
	public Optional<List<DepartmentModel>> getDepartment(String input) {
		try {
			pst = conn.prepareStatement("select * from department where name like ?");
			pst.setString(1, "%" + input + "%");
			rs = pst.executeQuery();
			List<DepartmentModel> ls = new ArrayList<>();
			while (rs.next()) {
				DepartmentModel d = new DepartmentModel();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				ls.add(d);
				d = null;
			}
			return Optional.of(ls);
		} catch (SQLException ex) {
			System.out.println("Problem in search department: " + ex);
			return Optional.empty();
		}
	}

}
