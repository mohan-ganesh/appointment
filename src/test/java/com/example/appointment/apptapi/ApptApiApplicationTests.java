package com.example.appointment.apptapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appointment.apptapi.api.UserApi;
import com.example.appointment.apptapi.config.FirestoreConfig;
import com.example.appointment.apptapi.pojo.User;

@SpringBootTest
class ApptApiApplicationTests {

	@Autowired
	FirestoreConfig firestoreConfig;

	@Autowired
	UserApi userApi;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserCreate() {

		int id = getRandomNumber(1, 99999);
		User user = new User(String.valueOf(id), "John", "Doe", "John.Doe@" + id + ".com");
		userApi.createUser(user);

	}

	@Test
	void testUserDetails() {

		User user = userApi.getUser("12345");
		assertNotNull(user);
	}

	public int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}

}
