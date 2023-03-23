package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Designation;
import com.example.demo.error.DesignationNotFoundException;
import com.example.demo.service.DesignationService;

@RestController
public class DegisnationController {
	@Autowired
	private DesignationService designationService;

	@PostMapping("/adddsg")
	public Designation addDesignation(@RequestBody Designation designation) throws DesignationNotFoundException {
		return designationService.addDesignation(designation);
	}

	@PostMapping("/addlistdsg")
	public List<Designation> addListOfDesignation(@RequestBody List<Designation> dsgList) throws DesignationNotFoundException {
		return designationService.addListOfDesignation(dsgList);

	}

	@PutMapping("/dsg/{id}")
	public Designation updateById(@RequestBody Designation designation, @PathVariable("id") String designationId) throws DesignationNotFoundException {
		return designationService.updateDsgById(designation, designationId);

	}

	@GetMapping("/dsg/{id}")
	public Designation fetchDsgById(@PathVariable("id") String designationId) throws DesignationNotFoundException {
		return designationService.fetchDsgById(designationId);
	}

	@GetMapping("/dsg")
	public List<Designation> fetchListOfDesignation() {
		return designationService.fetchListOfDesignation();
	}

	@DeleteMapping("/dsg/{id}")
	public String deleteById(@PathVariable("id") String designationId) throws DesignationNotFoundException {
		designationService.deletedsgById(designationId);
		return "Designation Deleted Successfully";

	}

}
