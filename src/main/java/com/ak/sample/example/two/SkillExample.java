package com.ak.sample.example.two;

public class SkillExample {

	int skillId;
	String technology;
	String experience;

	protected SkillExample() {
	}

	public SkillExample(int skillId, String technology, String experience) {
		super();
		this.skillId = skillId;
		this.technology = technology;
		this.experience = experience;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", technology=" + technology + ", experience=" + experience + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + skillId;
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillExample other = (SkillExample) obj;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (skillId != other.skillId)
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		return true;
	}

}
