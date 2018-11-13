package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clz) {
		return Employee.class.equals(clz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//data validations
		Employee e=(Employee)target;
		//name accept only 4-6 chars 
		if(!Pattern.compile("[A-Za-z]{4,6}").matcher(e.getEmpName()).matches()) {
			errors.rejectValue("empName", null, "Enter EmployeeName 4-6 chars");
		}
		//pwd 2-6 upper or lower and digitis
		if(!Pattern.compile("[A-Za-z0-9]{2,6}").matcher(e.getEmpPwd()).matches()) {
			errors.rejectValue("empPwd", null, "Enter Password 2-6 chars");
		}
		//please choose one gender
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empGen", null,"Please choose one Gender!!");
		//enter address
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empAddr", null,"Please Enter Address!!");
		//choose country
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empCntry", null,"Choose one Option");
		
		//langs
		if(e.getEmpLang()==null || e.getEmpLang().isEmpty()) {
			errors.rejectValue("empLang", null, "Please choose at least one Language!!");
		}
		
		
	}

}
