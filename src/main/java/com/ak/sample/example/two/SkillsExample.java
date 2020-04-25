package com.ak.sample.example.two;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SkillsExample {
	static int skillIdCounter = 0;
	static List<SkillExample> skills = new ArrayList<SkillExample>();

	public static boolean addSkill(String technology, String experience) {
		SkillExample s = new SkillExample(getNextSkillId(), technology, experience);
		return skills.add(s);
	}

	public static boolean addSkill(SkillExample s) {
		return skills.add(s);
	}

	public static SkillExample saveSkill(SkillExample receivedSkill) {
		SkillExample s = skills.stream().filter(t -> t.getSkillId() == receivedSkill.getSkillId()).findFirst().orElse(null);

		if (null != s) {
			s.setTechnology(receivedSkill.getTechnology());
			s.setExperience(receivedSkill.getExperience());
			return s;
		} else {
			if (receivedSkill.getSkillId() == -1) {
				receivedSkill.setSkillId(getNextSkillId());
				if (addSkill(receivedSkill))
					return receivedSkill;
				else
					return null;
			} else
				return null;
		}
	}

	static {
		SkillsExample.addSkill("JAVA", "3 Years");
		SkillsExample.addSkill("Spring", "3 Years");
		SkillsExample.addSkill("Hibernate", "3 Years");
	}

	static int getNextSkillId() {
		return skillIdCounter++;
	}

	public static SkillExample findById(int id) {
		return skills.stream().filter(t -> t.getSkillId() == id).findFirst().orElse(null);
	}

	public List<SkillExample> getAllSkill() {
		return (skills);
	}

	public SkillExample getSkill(int id) {
		return (skills.get(id));
	}

	public boolean updateSkill(int id, String technology, String experience) {
		SkillExample s = findById(id);

		if (null != s) {
			s.setTechnology(technology);
			s.setExperience(experience);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteSkill(int id) {
		return skills.removeIf(t -> t.getSkillId() == id);
	}

}
