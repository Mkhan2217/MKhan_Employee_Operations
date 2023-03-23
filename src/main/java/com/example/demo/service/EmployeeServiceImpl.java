package com.example.demo.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.MyLocaleResolver;
import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeValidation employeeValidation;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	@Override
	public Employee addEmployee(Employee employee,HttpServletRequest request) throws EmployeeNotFoundException {
		String st = employeeValidation.validate(employee,request);
		if (!"".equalsIgnoreCase(st))
			throw new EmployeeNotFoundException(st);
		employee.setEmpCreateDate(LocalDate.now());
		employee.setEmpUpdateDate(LocalDate.now());
		return employeeRepository.save(employee);

	}

	@Override
	public List<Employee> addListOfEmployee(List<Employee> emList,HttpServletRequest request) throws EmployeeNotFoundException {
		for (int i = 0; i < emList.size(); i++) {
			String st = employeeValidation.validate(emList.get(i),request);
			if (!"".equalsIgnoreCase(st))
				throw new EmployeeNotFoundException(st);
			emList.get(i).setEmpCreateDate(LocalDate.now());
			emList.get(i).setEmpUpdateDate(LocalDate.now());
		}
		return employeeRepository.saveAll(emList);
	}

	@Override
	public Employee updateById(Employee employee, String empId,HttpServletRequest request) throws EmployeeNotFoundException {
		Optional<Employee> emp = employeeRepository.findById(empId);
		if (!emp.isPresent())
			throw new EmployeeNotFoundException(messageSource.getMessage("empmsg1", null, myLocaleResolver.resolveLocale(request))+ empId);
		else {
			String st = employeeValidation.ValidUpdate(employee,request);
			if (!"".equalsIgnoreCase(st))
				throw new EmployeeNotFoundException(st);
			else {
				Employee emp1 = employeeRepository.findById(empId).get();

				if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
					emp1.setFirstName(employee.getFirstName());
				}
				if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
					emp1.setLastName(employee.getLastName());
				}
				if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
					emp1.setEmail(employee.getEmail());
				}
				if (Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())) {
					emp1.setPhone(employee.getPhone());
				}
				if (Objects.nonNull(employee.getDateOfBirth())) {
					emp1.setDateOfBirth(employee.getDateOfBirth());
				}
				if (Objects.nonNull(employee.getGender()) && !"".equals(employee.getGender())) {
					emp1.setGender(employee.getGender());
				}
				if (Objects.nonNull(employee.getProfilePhoto()) && !"".equalsIgnoreCase(employee.getProfilePhoto())) {
					emp1.setProfilePhoto(employee.getProfilePhoto());
				}

				emp1.setEmpUpdateDate(LocalDate.now());
				return employeeRepository.save(emp1);
			}
		}
	}


	@Override
	public List<Employee> fetchListOfEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> fetchByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
		return employeeRepository.findByCreateDateBetween(startDate, endDate);
	}

	@Override
	public void deleteById(String empId,HttpServletRequest request) throws EmployeeNotFoundException {
		Employee emp = employeeRepository.findById(empId).get();
		if (emp == null)
			throw new EmployeeNotFoundException(messageSource.getMessage("empmsg1", null, myLocaleResolver.resolveLocale(request)) + empId);
		else
			employeeRepository.deleteById(empId);
	}

	@Override
	public Employee fetchById(String empId,HttpServletRequest request) throws EmployeeNotFoundException { 
		Employee emp = employeeRepository.findById(empId).get();
		if (emp == null)
			throw new EmployeeNotFoundException(messageSource.getMessage("empmsg1", null, myLocaleResolver.resolveLocale(request)) + empId);
		return emp;
	}

	@Override
	public Employee fetchByPhone(String phone,HttpServletRequest request) throws EmployeeNotFoundException {
		Employee emp= employeeRepository.findByPhone(phone);
		if (emp == null)
			throw new EmployeeNotFoundException(messageSource.getMessage("empmsg2", null, myLocaleResolver.resolveLocale(request)) + phone);
		return emp;
	}

	@Override
	public Employee fetchByEmail(String email,HttpServletRequest request) throws EmployeeNotFoundException {
		Employee emp= employeeRepository.findByEmail(email);
		if (emp == null)
			throw new EmployeeNotFoundException(messageSource.getMessage("empmsg3", null, myLocaleResolver.resolveLocale(request))+ email);
		return emp;
	}

}
