package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ak.excel_utils.ExcelUtils;
import com.ak.profile_management.concepts.Location;
import com.ak.profile_management.concepts.Requirement;
import com.ak.profile_management.concepts.Skill;

@Service
public class Requirements {
	private static ExcelUtils exl = new ExcelUtils("Data.xls");

	public static List<Requirement> getRequirements() {

		List<Requirement> requirements = new ArrayList<Requirement>();
		List<Map<String, String>> records = exl.getAllRecords("Requirements");
		for (Map<String, String> record : records) {
			requirements.add(
					new Requirement(new Skill(record.get("as_string")), new Location(record.get("location_name"))));
		}

		return requirements;
	}

	public static void setRequirements(List<Requirement> requirements) {
		List<List<String>> data = new ArrayList<List<String>>();

		for (Requirement requirement : requirements) {
			List<String> d = Arrays.asList(requirement.getSkill().getAsString(), requirement.getLocation().getName());
			data.add(d);
		}

		exl.overwriteAllRecords("Requirements", data);

	}
}
