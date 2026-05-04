package com.MVCProject.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<List<Employee>> getEmployee() {
		try {
			pst = conn.prepareStatement("select * from Employee");
			rs = pst.executeQuery();
			List<Employee> al = new ArrayList<>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setSalary(rs.getInt(5));
				al.add(e);
			}
			return Optional.of(al);
		} catch (SQLException ex) {
			System.out.println("Error to select employee from database: " + ex);
			return Optional.empty();
		}
	}

	@Override
	public boolean isDeleteEmployee(int id) {
		try {
			pst = conn.prepareStatement("delete from employee where empId= ?");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			System.out.println("Exception to delete employee" + e);
			return false;
		}
	}

}
