package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query("select e from Employee e where e.empCreateDate between?1 and ?2")
	public List<Employee> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);

	public Employee findByPhone(String phone);

	public Employee findByEmail(String email);

}
