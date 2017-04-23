package controllers;

import org.springframework.web.client.RestTemplate;

import models.User;

public class UserController {
	private RestTemplate restTemplate;
	private final String API_BASE = "https://api.github.com";

	public UserController() {
		restTemplate = new RestTemplate();
	}

	public User getUserByUserName(String userName) {
		try {
			return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User[] getFollowersByUser(String userName) {
		try {
			return restTemplate.getForObject(API_BASE + "/users/" + userName + "/followers", User[].class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
