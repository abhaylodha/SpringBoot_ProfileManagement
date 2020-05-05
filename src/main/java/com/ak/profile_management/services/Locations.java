package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ak.excel_utils.ExcelUtils;
import com.ak.profile_management.concepts.Location;

@Service
public class Locations {
	private static ExcelUtils exl = new ExcelUtils("Data.xls");

	public static List<Location> getLocations() {
		List<Location> locations = new ArrayList<Location>();
		List<Map<String, String>> records = exl.getAllRecords("Locations");
		for (Map<String, String> record : records) {
			locations.add(new Location(record.get("location_name")));
		}
		return locations;
	}

	public static void addLocations(String name) {
		// skills.add(new Skill(asString));
		exl.insertRecord("Locations", Arrays.asList(name));
	}

	public static void setLocations(List<Location> locations) {
		List<List<String>> data = new ArrayList<List<String>>();

		for (Location location : locations) {
			List<String> d = Arrays.asList(location.getName());
			data.add(d);
		}

		exl.overwriteAllRecords("Locations", data);

	}
}
