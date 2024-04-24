package com.example.appointment.apptapi;

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

		User user = new User("12345", "John", "Doe", "John.Doe@email.com");

		userApi.createUser(user);

	}

}
