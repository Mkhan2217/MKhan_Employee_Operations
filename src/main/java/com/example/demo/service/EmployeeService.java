package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

public interface EmployeeService {

	Employee addEmployee(Employee employee,HttpServletRequest request) throws EmployeeNotFoundException;

	List<Employee> addListOfEmployee(List<Employee> emList,HttpServletRequest request) throws EmployeeNotFoundException;

	Employee updateById(Employee employee, String empId,HttpServletRequest request) throws EmployeeNotFoundException;

	List<Employee> fetchListOfEmployee();

	void deleteById(String empId,HttpServletRequest request) throws EmployeeNotFoundException;

	List<Employee> fetchByCreateDateBetween(LocalDate startDate, LocalDate endDate);

	Employee fetchById(String empId,HttpServletRequest request) throws EmployeeNotFoundException;

	Employee fetchByPhone(String phone,HttpServletRequest request) throws EmployeeNotFoundException;

	Employee fetchByEmail(String email,HttpServletRequest request) throws EmployeeNotFoundException;

}
