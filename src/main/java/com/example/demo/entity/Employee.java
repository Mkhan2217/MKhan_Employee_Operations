package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_table")
public class Employee {
	@Id
	private String empId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String phone;
	private String password;
	private Date dateOfBirth;
	private String profilePhoto;
	private LocalDate empCreateDate;
	private LocalDate empUpdateDate;

	@ManyToOne
	private Department department;

	@ManyToOne
	private Designation designation;

}
