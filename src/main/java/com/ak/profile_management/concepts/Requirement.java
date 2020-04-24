package com.ak.profile_management.concepts;

public class Requirement {
	Skill skill;
	Location location;

	public Requirement() {

	}

	public Requirement(Skill skill, Location location) {
		super();
		this.skill = skill;
		this.location = location;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
