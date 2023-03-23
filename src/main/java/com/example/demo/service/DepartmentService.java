package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department addDepartment(Department department) throws DepartmentNotFoundException;

	List<Department> addListOfDepartment(List<Department> dptList) throws DepartmentNotFoundException;

	Department updateDptById(Department department, String departmentId) throws DepartmentNotFoundException;

	Department fetchDptById(String departmentId) throws DepartmentNotFoundException;

	List<Department> fetchListOfDeparment();

	void deleteById(String departmentId) throws DepartmentNotFoundException;

}
