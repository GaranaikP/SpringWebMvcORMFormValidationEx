package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	@Transactional
	public int saveEmployee(Employee emp) {
		return dao.saveEmployee(emp);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Transactional
	public void deleteEmployee(int empId) {
		dao.deleteEmployee(empId);
	}

	@Transactional(readOnly=true)
	public Employee getEmployeeById(int empId) {
		return dao.getEmployeeById(empId);
	}

	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}