package com.ak.profile_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.profile_management.concepts.Requirement;

@CrossOrigin
@RestController
public class RequirementsController {

	@Autowired
	Requirements requirements;

	@GetMapping(path = "/requirements.json")
	public List<Requirement> getAllusers() {
		return Requirements.getRequirements();
	}

	@PutMapping(path = "/requirements.json")
	public ResponseEntity<Void> addUpdateRequirement(@RequestBody List<Requirement> reqs) {
		Requirements.setRequirements(reqs);
		return ResponseEntity.noContent().build();
	}

}
