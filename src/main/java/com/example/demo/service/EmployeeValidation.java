package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.example.demo.MyLocaleResolver;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletRequest;
@Component
public class EmployeeValidation {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	public String validate(Employee employee,HttpServletRequest request) {
		StringBuilder data = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();

		// EMPLOYEE ID VALIDATION
		if (Objects.nonNull(employee.getEmpId()) && !"".equalsIgnoreCase(employee.getEmpId())) {
			if (employee.getEmpId().length() <= 36) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmpId().equals(employee.getEmpId()))
						data.append(messageSource.getMessage("empmsg1", null, myLocaleResolver.resolveLocale(request))+ employee.getEmpId() + ",");
				}
			} else
				data.append(messageSource.getMessage("empmsg4", null, myLocaleResolver.resolveLocale(request)));
		} else
			data.append(messageSource.getMessage("empmsg5", null, myLocaleResolver.resolveLocale(request)));
		// EMPLOYEE FirstName VALIDATION
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				data.append(messageSource.getMessage("empmsg6", null, myLocaleResolver.resolveLocale(request)));
			}
		} else
			data.append(messageSource.getMessage("empmsg7", null, myLocaleResolver.resolveLocale(request)));
		// EMPLOYEE LastName VALIDATION
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				data.append(messageSource.getMessage("empmsg8", null, myLocaleResolver.resolveLocale(request)));
		}
		// EMPLOYEE Gender VALIDATION
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					data.append(messageSource.getMessage("empmsg9", null, myLocaleResolver.resolveLocale(request)));
				}
			} else
				data.append(messageSource.getMessage("empmsg10", null, myLocaleResolver.resolveLocale(request)));

		}
		// EMPLOYEE Email VALIDATION
		if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
			if ((employee.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmail().equals(employee.getEmail()))
						data.append(messageSource.getMessage("empmsg11", null, myLocaleResolver.resolveLocale(request)));
				}
			} else
				data.append(messageSource.getMessage("empmsg12", null, myLocaleResolver.resolveLocale(request)));

		} else
			data.append(messageSource.getMessage("empmsg13", null, myLocaleResolver.resolveLocale(request)));

		// EMPLOYEE Phone VALIDATION
		if (Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())) {
			if ((employee.getPhone().matches("[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhone().equals(employee.getPhone()))
data.append(messageSource.getMessage("empmsg14", null, myLocaleResolver.resolveLocale(request)));
				}
			} else
				data.append(messageSource.getMessage("empmsg15", null, myLocaleResolver.resolveLocale(request)));
		} else {
			data.append(messageSource.getMessage("empmsg16", null, myLocaleResolver.resolveLocale(request)));
		}
		// EMPLOYEE Password VALIDATION
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,16}$"))) {
					data.append(messageSource.getMessage("empmsg17", null, myLocaleResolver.resolveLocale(request)));
				}
			} else {
				data.append(messageSource.getMessage("empmsg18", null, myLocaleResolver.resolveLocale(request)));
			}
		} else 
			data.append(messageSource.getMessage("empmsg19", null, myLocaleResolver.resolveLocale(request)));
		
		return data.toString();
	}

	public String ValidUpdate(Employee employee,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();
		// validating firstname
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				sb.append(messageSource.getMessage("empmsg6", null, myLocaleResolver.resolveLocale(request)));
			}
		}
		// validating lastname
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				sb.append(messageSource.getMessage("empmsg8", null, myLocaleResolver.resolveLocale(request)));
		}
		// validating gender
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					sb.append(messageSource.getMessage("empmsg9", null, myLocaleResolver.resolveLocale(request)));
				}
			} else {
				sb.append(messageSource.getMessage("empmsg10", null, myLocaleResolver.resolveLocale(request)));
			}
		}
		// validating email
		if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
			if ((employee.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmail().equals(employee.getEmail())) {
						sb.append(messageSource.getMessage("empmsg11", null, myLocaleResolver.resolveLocale(request)));
					}
				}
			} else {
				sb.append(messageSource.getMessage("empmsg12", null, myLocaleResolver.resolveLocale(request)));
			}
		}
		// validating phoneNumber
		if (Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())) {
			if ((employee.getPhone().matches("^[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhone().equals(employee.getPhone())) {
						sb.append(messageSource.getMessage("empmsg14", null, myLocaleResolver.resolveLocale(request)));
					}
				}
			} else
				sb.append(messageSource.getMessage("empmsg16", null, myLocaleResolver.resolveLocale(request)));
		}
		// validating password
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,16}$"))) {
					sb.append(messageSource.getMessage("empmsg17", null, myLocaleResolver.resolveLocale(request)));
				}
			} else {
				sb.append(messageSource.getMessage("empmsg18", null, myLocaleResolver.resolveLocale(request)));
			}
		}
		return sb.toString();

	}
}
