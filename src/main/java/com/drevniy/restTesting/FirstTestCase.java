package com.drevniy.restTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import controllers.UserController;
import models.User;

public class FirstTestCase {
	private UserController userController;

	@Before
	public void setUp() {
		userController = new UserController();
	}

	@Test
	public void testUserInfoResponse() {
		User user = userController.getUserByUserName("maxkolotilkin");
		assertTrue(user.getHtml_url().contains("https://github.com/maxkolotilkin"));
	}

	@Test
	public void testFollowers() {
		User[] followers = userController.getFollowersByUser("Mak0");
		assertTrue(followers.length == 9);
	}
}
