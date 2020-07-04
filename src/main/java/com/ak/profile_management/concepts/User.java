package com.ak.profile_management.concepts;

public class User {
	String user_name;
	String user_type;
	String password;

	public User() {
	}

	public User(String user_name, String user_type, String password) {
		this.user_name = user_name;
		this.user_type = user_type;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
