package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ak.profile_management.concepts.Location;
import com.ak.profile_management.concepts.Requirement;
import com.ak.profile_management.concepts.Skill;

@Service
public class Requirements {
	static List<Requirement> requirements = new ArrayList<Requirement>();

	static {
		requirements.add(new Requirement(new Skill("JAVA, Scala, Spark | 3+ Years"), new Location("Mumbai")));

		requirements
				.add(new Requirement(new Skill("Core JAVA, Spring, Hibernate | 5+ Years"), new Location("Chennai")));
	}

	public static List<Requirement> getRequirements() {
		return requirements;
	}

	public static void setRequirements(List<Requirement> requirements1) {
		requirements = requirements1;
	}
}
