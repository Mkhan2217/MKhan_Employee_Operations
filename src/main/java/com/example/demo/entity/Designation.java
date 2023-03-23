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
@Table(name = "designation_table")
public class Designation {
	@Id
	private String designationId;
	private String designationName;
	private String designationCode;
	private LocalDate designationCreateDate;
	private LocalDate designationUpdateDate;
	  
}
