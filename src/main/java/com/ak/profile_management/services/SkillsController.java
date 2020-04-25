package com.ak.profile_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.profile_management.concepts.Skill;

@CrossOrigin
@RestController
public class SkillsController {

	@Autowired
	Skills skills;

	@GetMapping(path = "/skills.json")
	public List<Skill> getAllusers() {
		return Skills.getSkills();
	}

	@PutMapping(path = "/skills.json")
	public ResponseEntity<Void> addUpdateSkill(@RequestBody List<Skill> skills1) {
		Skills.setSkills(skills1);
		return ResponseEntity.noContent().build();
	}

}
