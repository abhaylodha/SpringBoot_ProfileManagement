package com.ak.profile_management.concepts;

public class User {
	String user_name;
	String user_type;

	public User() {
	}

	public User(String user_name, String user_type) {
		this.user_name = user_name;
		this.user_type = user_type;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}
