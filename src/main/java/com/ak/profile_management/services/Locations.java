package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ak.profile_management.concepts.Location;
import com.ak.profile_management.concepts.Location;

@Service
public class Locations {
	static List<Location> locations = new ArrayList<Location>();

	static {
		locations.add(new Location("Mumbai"));
		locations.add(new Location("Bangalore"));
		locations.add(new Location("Chennai"));
	}

	public static List<Location> getLocations() {
		return locations;
	}

	public static void addLocations(String name) {
		locations.add(new Location(name));
	}

	public static void setLocations(List<Location> locations1) {
		locations = locations1;
	}
}
