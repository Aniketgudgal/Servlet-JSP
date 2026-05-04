package com.MVCProject.Repository;

import java.util.List;
import java.util.Optional;

import com.MVCProject.Model.Employee;

public interface EmployeeRepo {
	boolean isAdded(Employee emp);

	Optional<List<Employee>> getEmployee();

	boolean isDeleteEmployee(int id);
}
