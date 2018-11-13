package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private EmployeeValidator validator;
	
	/* #1 Show EmployeeRegister JSP, 
	 * when /reg is entered in browser
	 */
	@RequestMapping("/reg")
	public String showRegPage(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	/**
	 * 2. On click submit read ModelAttribute
	 * validate, if no errors save else
	 * return to same page
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	//***read modelAttribute, next param must be Errors
	public String saveEmp(@ModelAttribute("employee")Employee emp,Errors errors,ModelMap map ) {
		//check validation errors
		validator.validate(emp, errors);
		//if no errors
		if(!errors.hasErrors()) {
			//save data to DB
			int empId=service.saveEmployee(emp);
			//show success message
			map.addAttribute("message", "Employee '"+empId+"' Registered");
			//clear form
			map.addAttribute("employee", new Employee());
		}else {//if errors exist
			map.addAttribute("message", "Please check all Errors!!");
		}
		//finally goto UI page
		return "EmployeeRegister";
	}
	
	
	
	
	
	
	
	
	
}
