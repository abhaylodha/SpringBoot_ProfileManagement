package com.ak.profile_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.profile_management.concepts.Location;

@CrossOrigin
@RestController
public class LocationsController {

	@Autowired
	Locations locations;

	@GetMapping(path = "/locations.json")
	public List<Location> getAllusers() {
		return Locations.getLocations();
	}

	@PutMapping(path = "/locations.json")
	public ResponseEntity<Void> addUpdateLocation(@RequestBody List<Location> locations1) {
		Locations.setLocations(locations1);
		return ResponseEntity.noContent().build();
	}

}
