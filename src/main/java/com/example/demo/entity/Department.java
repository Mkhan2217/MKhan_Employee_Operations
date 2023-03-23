package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "department_table")
public class Department {
	@Id
	private String departmentId;
	private String departmentCode;
	private String departmentName;
	private LocalDate departmentCreateDate;
	private LocalDate departmentUpdateDate;
	 

}
