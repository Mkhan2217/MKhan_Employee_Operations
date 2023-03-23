package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Component
public class DepartmentValidation {
	@Autowired
	private DepartmentRepository departmentRepository;

	public String validate(Department department) {
		StringBuilder data = new StringBuilder();
		List<Department> emps = departmentRepository.findAll();
		// Department Id VALIDATION
		if (Objects.nonNull(department.getDepartmentId()) && !"".equalsIgnoreCase(department.getDepartmentId())) {
			if (!(department.getDepartmentId().length() <= 36)) {
				data.append(" max-length of Department Id should not exceed 36,");
			}
		} else
			data.append(" Please enter Department Id,");

		// Department Code VALIDATION
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			if (department.getDepartmentCode().length() <= 30) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getDepartmentCode().equals(department.getDepartmentCode()))
						data.append("department Existed already with Code: " + department.getDepartmentCode() + ",");
				}
			} else
				data.append("Department Code should not exceed 30 characters");
		} else
			data.append("Please enter Department Code");

		// Department Name VALIDATION
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			if (!(department.getDepartmentName().length() <= 50))
				data.append(" max-length of Department Name should not exceed 50,");
		}

		return data.toString();
	}

	public String ValidUpdate(Department department) {
		StringBuilder data = new StringBuilder();
		List<Department> emps = departmentRepository.findAll();
		 
		// Department Code VALIDATION
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			if (department.getDepartmentCode().length() <= 30) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getDepartmentCode().equals(department.getDepartmentCode()))
						data.append("department Existed already with Code: " + department.getDepartmentCode() + ",");
				}
			} else
				data.append("Department Code should not exceed 30 characters");
		} else
			data.append("Please enter Department Code");


		// Department Name VALIDATION
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			if (!(department.getDepartmentName().length() <= 50))
				data.append(" max-length of Department Name should not exceed 50,");
		}

		return data.toString();

	}

}
