package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ak.profile_management.concepts.Skill;

@Service
public class Skills {
	static List<Skill> skills = new ArrayList<Skill>();

	static {
		skills.add(new Skill("JAVA, Scala, Spark | 3+ Years"));
		skills.add(new Skill("Core JAVA, Spring, Hibernate | 5+ Years"));
	}

	public static List<Skill> getSkills() {
		return skills;
	}

	public static void addSkills(String asString) {
		skills.add(new Skill(asString));
	}

	public static void setSkills(List<Skill> skills1) {
		skills = skills1;
	}
}
