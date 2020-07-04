package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ak.excel_utils.ExcelUtils;
import com.ak.profile_management.concepts.User;

@Service
public class Users {

	private static ExcelUtils exl = new ExcelUtils("Users.xls");

	public static User getUser(String id) {
		System.out.println(String.format("Received User ID Request : %s", id));
		List<Map<String, String>> records = exl.getRecords("Users", new HashMap<String, String>() {
			{
				put("id", id);
			}
		});

		if (records.size() > 0) {
			return new User(records.get(0).get("user_name"), records.get(0).get("user_type"),
					records.get(0).get("password"));
		} else {
			return null;
		}
	}

	public static List<User> getAllUsers() {
		// return new ArrayList<>(users.values());
		List<User> users = new ArrayList<User>();
		List<Map<String, String>> records = exl.getAllRecords("Users");
		for (Map<String, String> record : records) {
			users.add(new User(record.get("user_name"), record.get("user_type"), ""));
		}
		return users;
	}

	public static void addUpdateUser(String id, User usr) {

		User existingUser = getUser(id);
		if (existingUser == null) {
			exl.insertRecord("Users", Arrays.asList(id, usr.getUser_name(), usr.getUser_type(), "123456"));
		} else {
			exl.updateRecord("Users", new HashMap<String, String>() {
				{
					put("id", id);
				}
			}, Arrays.asList(id, usr.getUser_name(), usr.getUser_type(), existingUser.getPassword()));
		}
	}
}
