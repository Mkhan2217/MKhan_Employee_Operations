package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Designation;
import com.example.demo.error.DesignationNotFoundException;
import com.example.demo.repository.DesignationRepository;

@Service
public class DesignationServiceImlp implements DesignationService {
	@Autowired
	private DesignationRepository designationRepository;
	@Autowired
	private DesignationValidation designationValidation;

	@Override
	public Designation addDesignation(Designation designation) throws DesignationNotFoundException {
		String st = designationValidation.validate(designation);
		if (!"".equalsIgnoreCase(st))
			throw new DesignationNotFoundException(st);
		designation.setDesignationCreateDate(LocalDate.now());
		designation.setDesignationUpdateDate(LocalDate.now());
		return designationRepository.save(designation);
	}

	@Override
	public List<Designation> addListOfDesignation(List<Designation> dsgList) throws DesignationNotFoundException {
		for (int i = 0; i < dsgList.size(); i++) {
			String st = designationValidation.validate(dsgList.get(i));
			if (!"".equalsIgnoreCase(st))
				throw new DesignationNotFoundException(st);
			dsgList.get(i).setDesignationCreateDate(LocalDate.now());
			dsgList.get(i).setDesignationUpdateDate(LocalDate.now());
		}
		return designationRepository.saveAll(dsgList);
	}

	@Override
	public Designation updateDsgById(Designation designation, String designationId)
			throws DesignationNotFoundException {
		Designation dpt = designationRepository.findById(designationId).get();
		if (dpt == null)
			throw new DesignationNotFoundException("Department  is not avaibale whose ID :- " + designationId);
		else {
			String st = designationValidation.ValidUpdate(designation);
			if (!"".equalsIgnoreCase(st))
				throw new DesignationNotFoundException(st);
			else {
				Designation dpt2 = designationRepository.findById(designationId).get();
				if (Objects.nonNull(designation.getDesignationId())
						&& !"".equalsIgnoreCase(designation.getDesignationId())) {
					dpt2.setDesignationId(designation.getDesignationId());
				}
				if (Objects.nonNull(designation.getDesignationCode())
						&& !"".equalsIgnoreCase(designation.getDesignationCode())) {
					dpt2.setDesignationCode(designation.getDesignationCode());
				}
				if (Objects.nonNull(designation.getDesignationName())
						&& !"".equalsIgnoreCase(designation.getDesignationName())) {
					dpt2.setDesignationName(designation.getDesignationName());
				}

				return designationRepository.save(dpt2);

			}

		}

	}

	@Override
	public Designation fetchDsgById(String designationId) throws DesignationNotFoundException {
		Designation dpt = designationRepository.findById(designationId).get();
		if (dpt == null)
			throw new DesignationNotFoundException("designation  is not avaibale whose ID :- " + designationId);
		else
			return designationRepository.findById(designationId).get();
	}

	@Override
	public List<Designation> fetchListOfDesignation() {
		return designationRepository.findAll();
	}

	@Override
	public void deletedsgById(String designationId) throws DesignationNotFoundException {
		Designation dpt = designationRepository.findById(designationId).get();
		if (dpt == null)
			throw new DesignationNotFoundException("designation Id  is not avaibale whose ID :- " + designationId);
		else
			designationRepository.deleteById(designationId);
	}

}
