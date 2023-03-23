package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Designation;
import com.example.demo.error.DesignationNotFoundException;

public interface DesignationService {

	Designation addDesignation(Designation designation) throws DesignationNotFoundException;

	List<Designation> addListOfDesignation(List<Designation> dsgList) throws DesignationNotFoundException;

	Designation updateDsgById(Designation designation, String designationId) throws DesignationNotFoundException;

	Designation fetchDsgById(String designationId) throws DesignationNotFoundException;

	List<Designation> fetchListOfDesignation();

	void deletedsgById(String designationId) throws DesignationNotFoundException;

}
