package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/adddept")
	public Department addDepartment(@RequestBody Department department) throws DepartmentNotFoundException {
		LOGGER.info("Inside addDepartment of DepartmentController");
		return departmentService.addDepartment(department);
	}

	@PostMapping("/addlistdpt")
	public List<Department> addListOfDepartment(@RequestBody List<Department> dptList) throws DepartmentNotFoundException {
		LOGGER.info("Inside addListOfDepartment of DepartmentController");
		return departmentService.addListOfDepartment(dptList);

	}

	@PutMapping("/dept/{id}")
	public Department updateById(@RequestBody Department department, @PathVariable("id") String departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside updateById of DepartmentController");
		return departmentService.updateDptById(department, departmentId);

	}

	@GetMapping("/dept/{id}")
	public Department fetchById(@PathVariable("id") String departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchById of DepartmentController");
		return departmentService.fetchDptById(departmentId);
	}

	@GetMapping("/dpt")
	public List<Department> fetchListOfDepartment() {
		LOGGER.info("Inside fetchListOfDepartment of DepartmentController");
		return departmentService.fetchListOfDeparment();
	}

	@DeleteMapping("/dept/{id}")
	public String deleteById(@PathVariable("id") String departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside deleteById of DepartmentController");
		departmentService.deleteById(departmentId);
		return "Department Deleted Successfully";

	}

}
