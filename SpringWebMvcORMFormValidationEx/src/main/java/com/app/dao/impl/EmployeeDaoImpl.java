package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveEmployee(Employee emp) {
		return (Integer)ht.save(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		ht.update(emp);
	}

	@Override
	public void deleteEmployee(int empId) {
		ht.delete(new Employee(empId));
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return ht.get(Employee.class, empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

}



