package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ak.excel_utils.ExcelUtils;
import com.ak.profile_management.concepts.Skill;

@Service
public class Skills {
	private static ExcelUtils exl = new ExcelUtils("Data.xls");

	public static List<Skill> getSkills() {
		List<Skill> skills = new ArrayList<Skill>();
		List<Map<String, String>> records = exl.getAllRecords("Skills");
		for (Map<String, String> record : records) {
			skills.add(new Skill(record.get("as_string")));
		}
		return skills;
	}

	public static void addSkills(String asString) {
		exl.insertRecord("Skills", Arrays.asList(asString));

	}

	public static void setSkills(List<Skill> skills) {
		List<List<String>> data = new ArrayList<List<String>>();

		for (Skill skill : skills) {
			List<String> d = Arrays.asList(skill.getAsString());
			data.add(d);
		}

		exl.overwriteAllRecords("Skills", data);

	}
}
