package com.MVCProject.Repository;

import java.sql.SQLException;

import com.MVCProject.Model.Employee;

public class EmployeeRepoImp extends DBConfig implements EmployeeRepo {

	@Override
	public boolean isAdded(Employee emp) {
		try {
			pst = conn.prepareStatement("insert into Employee values('0',?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setInt(3, emp.getAge());
			pst.setInt(4, emp.getSalary());
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Exception in Employee add: " + e);
			return false;
		}
	}

}
