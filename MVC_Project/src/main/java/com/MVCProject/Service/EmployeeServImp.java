package com.MVCProject.Service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.Employee;
import com.MVCProject.Repository.EmployeeRepo;
import com.MVCProject.Repository.EmployeeRepoImp;

public class EmployeeServImp implements EmployeeService {
	EmployeeRepo ep = new EmployeeRepoImp();

	@Override
	public boolean isAddEmp(Employee emp) {
		if (emp.getFirstName().length() == 0 || emp.getLastName().length() == 0 || emp.getSalary() == 0
				|| emp.getAge() == 0) {
			return false;
		} else if (emp.getFirstName().isEmpty() || emp.getLastName().isEmpty()) {
			return false;
		} else {
			return ep.isAdded(emp);
		}
	}

	@Override
	public Optional<List<Employee>> getEmployee() {

		return ep.getEmployee();
	}

	@Override
	public boolean isDeleteEmployee(int id) {
		return ep.isDeleteEmployee(id);
	}

}
