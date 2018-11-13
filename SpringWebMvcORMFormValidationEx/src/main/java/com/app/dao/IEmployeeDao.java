package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDao {

	public int saveEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int empId);
	
	public Employee getEmployeeById(int empId);
	public List<Employee> getAllEmployees();
	
	
}
