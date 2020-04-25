package com.ak.sample.example.two;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SkillsControllerExample {

	@Autowired
	SkillsExample skillsExample;

	@GetMapping(path = "/skillsexample/getallskills")
	public List<SkillExample> getAllSkills() {
		return skillsExample.getAllSkill();
	}

	@GetMapping(path = "/skillsexample/{id}")
	public SkillExample getSkill(@PathVariable int id) {
		return SkillsExample.findById(id);
	}

	@DeleteMapping(path = "/skillsexample/delete/{id}")
	public ResponseEntity<Void> deleteSkill(@PathVariable int id) {
		if (skillsExample.deleteSkill(id))
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/skillsexample/{id}")
	public ResponseEntity<SkillExample> saveSkill(@RequestBody SkillExample receivedSkill) {
		if (SkillsExample.saveSkill(receivedSkill) != null)
			return new ResponseEntity<SkillExample>(receivedSkill, HttpStatus.OK);
		return new ResponseEntity<SkillExample>(receivedSkill, HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping(path = "/skills")
	public ResponseEntity<Void> addSkill(@RequestBody SkillExample receivedSkill) {
		SkillExample newSkill = SkillsExample.saveSkill(receivedSkill);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newSkill.getSkillId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
