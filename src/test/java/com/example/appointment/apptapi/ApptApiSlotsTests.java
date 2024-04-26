package com.example.appointment.apptapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appointment.apptapi.api.AppointmentApi;
import com.example.appointment.apptapi.api.UserApi;
import com.example.appointment.apptapi.config.FirestoreConfig;
import com.example.appointment.apptapi.pojo.Appointment;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.User;

@SpringBootTest
class ApptApiSlotsTests {

	@Autowired
	FirestoreConfig firestoreConfig;

	@Autowired
	AppointmentApi appointmentAPI;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserCreate() {

		int id = getRandomNumber(1, 99999);

		Appointment monday_9_10_AM = new Appointment("monday-9to10", "", "available");

		Appointment monday_noon = new Appointment("monday-2to4PM", "", "available");

		Appointment tuesday_morning = new Appointment("tuesday-9-11AM", "", "available");

		Appointment tuesday_2_4PM = new Appointment("tuesday-2_4PM", "", "available");

		AppointmentSchedule schedule_monday_9_10 = new AppointmentSchedule("monday_9_10", "system", "available",
				"9:00 AM",
				"10:00 AM", monday_9_10_AM);

		AppointmentSchedule schedule_monday_2_4_PM = new AppointmentSchedule("monday_2_4", "system", "available",
				"2:00 PM",
				"4:00 PM", monday_noon);

		AppointmentSchedule schedule_tuesday_9_11_AM = new AppointmentSchedule("tuesday_9_11AM", "system", "available",
				"9:00 AM",
				"11:00 AM", tuesday_morning);

		AppointmentSchedule schedule_tuesday_2_4PM = new AppointmentSchedule("tuesday_2_4PM", "system", "available",
				"2:00 PM",
				"4:00 PM", tuesday_2_4PM);

		appointmentAPI.createAppointmentSlots(schedule_tuesday_2_4PM);

	}

	@Test
	void tesSlotDetails() {
		List<AppointmentSchedule> list = appointmentAPI.getAppointmentSlots();
	}

	public int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}

}
