package com.example.demo.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentValidation departmentValidation;

	@Override
	public Department addDepartment(Department department) throws DepartmentNotFoundException {
		String st = departmentValidation.validate(department);
		if (!"".equalsIgnoreCase(st))
			throw new DepartmentNotFoundException(st);
		department.setDepartmentCreateDate(LocalDate.now());
		department.setDepartmentUpdateDate(LocalDate.now());

		return departmentRepository.save(department);
	}

	@Override
	public List<Department> addListOfDepartment(List<Department> dptList) throws DepartmentNotFoundException {
		for (int i = 0; i < dptList.size(); i++) {
			String st = departmentValidation.validate(dptList.get(i));
			if (!"".equalsIgnoreCase(st))
				throw new DepartmentNotFoundException(st);
			dptList.get(i).setDepartmentCreateDate(LocalDate.now());
			dptList.get(i).setDepartmentUpdateDate(LocalDate.now());
		}
		return departmentRepository.saveAll(dptList);
	}

	@Override
	public Department updateDptById(Department department, String departmentId) throws DepartmentNotFoundException {
		Department dpt = departmentRepository.findById(departmentId).get();
		if (dpt == null)
			throw new DepartmentNotFoundException("Department  is not avaibale whose ID :- " + departmentId);
		else {
			String st = departmentValidation.ValidUpdate(department);
			if (!"".equalsIgnoreCase(st))
				throw new DepartmentNotFoundException(st);
			else {
				Department dpt2 = departmentRepository.findById(departmentId).get();
				if (Objects.nonNull(department.getDepartmentId())
						&& !"".equalsIgnoreCase(department.getDepartmentId())) {
					dpt2.setDepartmentId(department.getDepartmentId());
				}
				if (Objects.nonNull(department.getDepartmentCode())
						&& !"".equalsIgnoreCase(department.getDepartmentCode())) {
					dpt2.setDepartmentCode(department.getDepartmentCode());
				}
				if (Objects.nonNull(department.getDepartmentName())
						&& !"".equalsIgnoreCase(department.getDepartmentName())) {
					dpt2.setDepartmentName(department.getDepartmentName());
				}

				return departmentRepository.save(dpt2);

			}

		}

	}

	@Override
	public Department fetchDptById(String departmentId) throws DepartmentNotFoundException {
		Department dpt = departmentRepository.findById(departmentId).get();
		if (dpt == null)
			throw new DepartmentNotFoundException("department Id  is not avaibale whose ID :- " + departmentId);
		else
			return departmentRepository.findById(departmentId).get();
	}

	@Override
	public List<Department> fetchListOfDeparment() {
		return departmentRepository.findAll();
	}

	@Override
	public void deleteById(String departmentId) throws DepartmentNotFoundException {
		Department dpt = departmentRepository.findById(departmentId).get();
		if (dpt == null)
			throw new DepartmentNotFoundException("department Id  is not avaibale whose ID :- " + departmentId);
		else
			departmentRepository.deleteById(departmentId);
	}

}
