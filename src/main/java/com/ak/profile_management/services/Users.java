package com.ak.profile_management.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ak.profile_management.concepts.User;

@Service
public class Users {

	private static Map<String, User> users = new HashMap<String, User>();

	static {
		users.put("abcom", new User("a@b.com", "Admin"));
		users.put("bccom", new User("b@c.com", "Panelist"));
		users.put("cdcom", new User("c@d.com", "Panelist"));
	}

	public static User getUser(String id) {
		System.out.println(String.format("Received User ID Request : %s", id));

		if (users.containsKey(id)) {
			return users.get(id);
		} else {
			return new User("none", "Panelist");
		}
	}

	public static List<User> getAllUsers() {
		return new ArrayList<>(users.values());
	}

	public static void addUpdateUser(String id, User usr) {
		users.put(id, usr);
	}
}
