package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Designation;
import com.example.demo.repository.DesignationRepository;

@Component
public class DesignationValidation {
	@Autowired
	private DesignationRepository designationRepository;

	public String validate(Designation designation) {
		StringBuilder data = new StringBuilder();
		List<Designation> emps = designationRepository.findAll();
		// Department Id VALIDATION
		if (Objects.nonNull(designation.getDesignationId()) && !"".equalsIgnoreCase(designation.getDesignationId())) {
			if (!(designation.getDesignationId().length() <= 36)) {
				data.append(" max-length of Designation Id should not exceed 36,");
			}
		} else
			data.append(" Please enter Designation Id,");

		// Department Code VALIDATION
		if (Objects.nonNull(designation.getDesignationCode())
				&& !"".equalsIgnoreCase(designation.getDesignationCode())) {
			if (designation.getDesignationCode().length() <= 30) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getDesignationCode().equals(designation.getDesignationCode()))
						data.append("Designation Existed already with Code: " + designation.getDesignationCode() + ",");
				}
			} else
				data.append("Designation Code should not exceed 30 characters");
		} else
			data.append("Please enter Designation Code");

		// Department Name VALIDATION
		if (Objects.nonNull(designation.getDesignationName())
				&& !"".equalsIgnoreCase(designation.getDesignationName())) {
			if (!(designation.getDesignationName().length() <= 50))
				data.append(" max-length of Designation Name should not exceed 50,");
		}

		return data.toString();
	}

	public String ValidUpdate(Designation designation) {
		StringBuilder data = new StringBuilder();
		List<Designation> emps = designationRepository.findAll();

		// Department Code VALIDATION
		if (Objects.nonNull(designation.getDesignationCode())
				&& !"".equalsIgnoreCase(designation.getDesignationCode())) {
			if (designation.getDesignationCode().length() <= 30) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getDesignationCode().equals(designation.getDesignationCode()))
						data.append("Designation Existed already with Code: " + designation.getDesignationCode() + ",");
				}
			} else
				data.append("Designation Code should not exceed 30 characters");
		} else
			data.append("Please enter Designation Code");

		// Department Name VALIDATION
		if (Objects.nonNull(designation.getDesignationName())
				&& !"".equalsIgnoreCase(designation.getDesignationName())) {
			if (!(designation.getDesignationName().length() <= 50))
				data.append(" max-length of Designation Name should not exceed 50,");
		}

		return data.toString();

	}

}
